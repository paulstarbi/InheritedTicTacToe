//package com.wojnar.GameEngine;
//
//import com.wojnar.GameEngine.Players.Player;
//import com.wojnar.IOstrems.OutputController;
//
//import java.util.List;
//import java.util.Scanner;
//
///**
// * Created by bartomiej on 29.06.17.
// */
//public class GamePlay implements IGamePlay{
//    private IBoard board;
//    private IWinChecker winChecker;
//    private List<Player> players;
//    private boolean isGameInProgress;
//    private Scanner inputController;;
//
//    GamePlay(List<Player> players, IBoard board, IWinChecker winChecker, Scanner inputController) {
//        this.board = board;
//        this.players = players;
//        this.winChecker = winChecker;
//        this.inputController = inputController;
//    }
//
//    @Override
//    public boolean executeGamePlay() {
//        isGameInProgress = true;
//        boolean isBO3InProgress = true;
//        board.clearBoard();
//        for(int turns = 0;isGameInProgress && turns < board.getYSize() * board.getXSize(); turns++) {
//            for (Player player : players) {
//                OutputController.printBoard(board);
//                OutputController.printCharacterPlacingMessage(player);
//                setRightCoordinatesForPlayer(player);
//                isBO3InProgress = checkIfPlayerWon(player, isBO3InProgress);
//            }
//        }
//
//        return isBO3InProgress;
//    }
//
//    private int getCoordinateFromUser(String coordinateName, int sideSize) {
//        OutputController.printChoosingCoordinateMessage(coordinateName, sideSize);
//        return inputController.nextInt();
//    }
//
//    private void setRightCoordinatesForPlayer(Player player) {
//        boolean playerGotRightCoordinates = false;
//        while (!playerGotRightCoordinates) {
//            int x = getCoordinateFromUser("X", board.getXSize());
//            int y = getCoordinateFromUser("Y", board.getYSize());
//            if (x > 0 && x < board.getXSize() + 1 && y > 0 && y < board.getYSize() + 1) {
//                if (board.isFieldAvailable(x, y)) {
//                    board.setField(x, y, player.getCharacter());
//                    playerGotRightCoordinates = true;
//                } else {
//                    OutputController.printWrongCoordinatesMessage();
//                    OutputController.printBoard(board);
//                }
//            } else {
//                OutputController.printWrongCoordinatesMessage();
//                OutputController.printBoard(board);
//            }
//        }
//    }
//
//    private boolean checkIfPlayerWon(Player player, boolean isBO3InProgress) {
//        if (winChecker.checkIfPlayerWon(player)) {
//            player.addPoint();
//            OutputController.printOneGameWonMessage(player);
//            isGameInProgress = false;
//            if (player.getScore() == 2) {
//                OutputController.printBO3WonMessage(player);
//                isBO3InProgress = false;
//            }
//        }
//
//        return isBO3InProgress;
//    }
//}
