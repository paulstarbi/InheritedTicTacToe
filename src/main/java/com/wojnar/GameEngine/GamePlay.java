package com.wojnar.GameEngine;

import com.wojnar.GameEngine.utils.IBoard;
import com.wojnar.GameEngine.utils.IPlayer;
import com.wojnar.GameUI.IConsoleView;

import java.util.List;
import java.util.Scanner;

/**
 * Created by bartomiej on 29.06.17.
 */
public class GamePlay implements IGamePlay{
    private IBoard board;
    private IWinChecker winChecker;
    private List<IPlayer> players;
    private boolean isGameInProgress;
    private Scanner inputController;;

    GamePlay(List<IPlayer> players, IBoard board, IWinChecker winChecker, Scanner inputController) {
        this.board = board;
        this.players = players;
        this.winChecker = winChecker;
        this.inputController = inputController;
    }

    @Override
    public boolean executeGamePlay() {
        isGameInProgress = true;
        boolean isBO3InProgress = true;
        board.clearBoard();
        for(int turns = 0;isGameInProgress && turns < board.getYSize() * board.getXSize(); turns++) {
            for (IPlayer player : players) {
                IConsoleView.printBoard(board);
                IConsoleView.printCharacterPlacingMessage(player);
                setRightCoordinatesForPlayer(player);
                isBO3InProgress = checkIfPlayerWon(player, isBO3InProgress);
            }
        }

        return isBO3InProgress;
    }

    private int getCoordinateFromUser(String coordinateName, int sideSize) {
        IConsoleView.printChoosingCoordinateMessage(coordinateName, sideSize);
        return inputController.nextInt();
    }

    private void setRightCoordinatesForPlayer(IPlayer player) {
        boolean playerGotRightCoordinates = false;
        while (!playerGotRightCoordinates) {
            int x = getCoordinateFromUser("X", board.getXSize());
            int y = getCoordinateFromUser("Y", board.getYSize());
            if (x > 0 && x < board.getXSize() + 1 && y > 0 && y < board.getYSize() + 1) {
                if (board.isFieldAvailable(x, y)) {
                    board.setField(x, y, player.getCharacter());
                    playerGotRightCoordinates = true;
                } else {
                    IConsoleView.printWrongCoordinatesMessage();
                    IConsoleView.printBoard(board);
                }
            } else {
                IConsoleView.printWrongCoordinatesMessage();
                IConsoleView.printBoard(board);
            }
        }
    }

    private boolean checkIfPlayerWon(IPlayer player, boolean isBO3InProgress) {
        if (winChecker.checkIfPlayerWon(player)) {
            player.addPoint();
            IConsoleView.printOneGameWonMessage(player);
            isGameInProgress = false;
            if (player.getScore() == 2) {
                IConsoleView.printBO3WonMessage(player);
                isBO3InProgress = false;
            }
        }

        return isBO3InProgress;
    }
}
