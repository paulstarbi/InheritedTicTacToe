package com.wojnar.GameEngine;

import com.wojnar.Players.Player;
import com.wojnar.board.BoardDrawer;
import com.wojnar.board.BoardUpdater;
import com.wojnar.board.Boards;
import com.wojnar.IOstrems.InputController;
import com.wojnar.IOstrems.OutputController;

import java.util.List;

/**
 * Created by bartomiej on 29.06.17.
 */
public class GamePlay implements IGamePlay{
    private Boards playBoard;
    private IWinChecker winChecker;
    private List<Player> players;
    private boolean isGameInProgress;
    private InputController inputController;
    private OutputController out;
    private BoardUpdater updater;

    GamePlay(List<Player> players, Boards board, IWinChecker winChecker, InputController inputController, OutputController out) {
        this.playBoard = board;
        this.players = players;
        this.winChecker = winChecker;
        this.inputController = inputController;
        this.out=out;
        this.updater=new BoardUpdater(board,out);
    }

    @Override
    public boolean executeGamePlay() {
        isGameInProgress = true;
        boolean isBO3InProgress = true;
        playBoard.clearBoard();
        for(int turns = 0; isGameInProgress && turns < playBoard.getHeight() * playBoard.getWidth(); turns++) {
            for (Player player : players) {
                BoardDrawer.drawBoard(playBoard);
                out.printCharacterPlacingMessage(player);
                getAvailableFieldNumFromUser(player);
                isBO3InProgress = checkIfPlayerWon(player, isBO3InProgress);
            }
        }

        return isBO3InProgress;
    }


    private void getAvailableFieldNumFromUser(Player player) {
        boolean playerGotRightCoordinates = false;
        while (!playerGotRightCoordinates) {
            int where = inputController.nextInt();
            if (where > 0 && where < playBoard.getSize()) {
                if (playBoard.isFieldAvailable(where)) {
                    updater.updateBoard(where, player.getCharacter());
                    playerGotRightCoordinates = true;
                } else {
                    out.printWrongCoordinatesMessage();
                    BoardDrawer.drawBoard(playBoard);
                }
            } else {
                out.printWrongCoordinatesMessage();
                BoardDrawer.drawBoard(playBoard);
            }
        }
    }

    private boolean checkIfPlayerWon(Player player, boolean isBO3InProgress) {
        if (winChecker.checkIfPlayerWon(player)) {
            player.addPoint();
            out.printOneGameWonMessage(player);
            isGameInProgress = false;
            if (player.getScore() == 2) {
                out.printBO3WonMessage(player);
                isBO3InProgress = false;
            }
        }

        return isBO3InProgress;
    }
}
