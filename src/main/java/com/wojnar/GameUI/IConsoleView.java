package com.wojnar.GameUI;

import com.wojnar.GameEngine.Boards.IBoard;
import com.wojnar.GameEngine.utils.IPlayer;

/**
 * Created by bartomiej on 29.06.17.
 */
public interface IConsoleView {

    static void printWelcomeMessage() {
        System.out.println("Welcome to TicTacToe game");
    }

    static void printMenuMessage() {
        System.out.println("Press:");
        System.out.println("1 - to play BO3");
        System.out.println("0 - exit game");
    }

    static void printPlayerNameSelectionMessage(int playerNumber) {
        System.out.println("Please choose name for player " + playerNumber);
    }


    static void printCharacterSelectionMessage() {
        System.out.println("Please claim the character: O or X");
    }

    static void printWrongCharacterSelection() {
        System.out.println("Unavailable characters selected. First player will get X, second player O");
    }

    static void printBoardSizeSelectionMessage(String axis) {
        System.out.println("How many fields board should have in " + axis + " axis");
    }

    static void printToSmallBoardSizeMessage(String axis) {
        System.out.println("Board size " + axis + " is too small. Setting up as default 3 ...");
    }

    static void printSelectingSequenceLengthMessage() {
        System.out.println("How long character sequence should be");
    }

    static void printSequenceLengthTooBigMessage() {
        System.out.println("Sequence length is bigger than shorter side of board. Setting it as this side value");
    }

    static void printSequenceLengthTooSmallMessage() {
        System.out.println("Sequence length is smaller than default 3 value. Setting it as this value");
    }


    static void printCharacterPlacingMessage(IPlayer player) {
        System.out.println("Where would " + player.getName() + " place his character");
    }


    static void printChoosingCoordinateMessage(String coordinate, int sideSize) {
        System.out.println("Please select " + coordinate + " coordinate: (From 1 to " + sideSize + ")");
    }


    static void printWrongCoordinatesMessage() {
        System.out.println("You've chosen wrong coordinates. Try again...");
    }

    static void printPassNumberErrorMessage() {
        System.out.println("Please pass integer value");
    }


    static void printBO3WonMessage(IPlayer player) {
        System.out.println(player.getName() + " won whole BO3!");
    }

    static void printOneGameWonMessage(IPlayer player) {
        System.out.println(player.getName() + " won match!");
    }


    static void printInputMismachExMessage() {
        System.out.println("Wrong field !!!! Try again !! Chose field number from PlayBoard!!");
    }

    static void printBoard(IBoard board) {
        for(int i = 0; i < board.getYSize(); i++) {
            String line = "";
            for(int j = 0; j < board.getXSize(); j++) {
                line += board.getField(j, i) + " | ";
            }
            System.out.println(line.substring(0, line.length() - 3));
        }
    }
}
