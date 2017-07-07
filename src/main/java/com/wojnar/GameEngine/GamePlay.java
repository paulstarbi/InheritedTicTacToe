package com.wojnar.GameEngine;

import com.wojnar.Players.Player;
import com.wojnar.board.BoardDrawer;
import com.wojnar.board.BoardUpdater;
import com.wojnar.IOstrems.InputController;
import com.wojnar.IOstrems.OutputController;
import com.wojnar.board.Boards;

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
        this.isGameInProgress=true;
        this.out=out;
        this.updater=new BoardUpdater(board,out);
    }

    @Override
    public boolean executeGamePlay(Player currPlayer) {
        playBoard.clearBoard();
            for (int turns = 0; isGameInProgress && turns < playBoard.getSize(); turns++) {
                BoardDrawer.drawBoard(playBoard);
                out.printCharacterPlacingMessage(currPlayer);
                getAvailableFieldNumFromUser(currPlayer);
                currPlayer = currPlayer.changePlayer(players);
            }
        return false;
    }

    private void getAvailableFieldNumFromUser(Player currPlayer) {
        boolean playerGotRightCoordinates = false;
        while (!playerGotRightCoordinates) {
            int where = inputController.takeNumberFromUser();
            if (where > 0 && where < playBoard.getSize()) {
                if (playBoard.isFieldAvailable(where)) {
                    updater.updateBoard(where, currPlayer.getCharacter());
                    checkIfPlayerWon(where, currPlayer);
                    playerGotRightCoordinates = true;
                } else {
                    out.fieldBusy();
                    BoardDrawer.drawBoard(playBoard);
                }
            } else {
                out.fieldNonExist();
                BoardDrawer.drawBoard(playBoard);
            }
        }
    }

    private boolean checkIfPlayerWon(int starPosition,Player player) {
        if (winChecker.checkIfPlayerWon(playBoard,starPosition,player)) {
            player.addPoint(3);
            out.printOneGameWonMessage(player);
            isGameInProgress = false;
        }
        return isGameInProgress;
    }
}
