package com.wojnar.GameUI;

import com.wojnar.GameEngine.utils.IBoard;
import com.wojnar.GameEngine.utils.IPlayer;

/**
 * Created by bartomiej on 29.06.17.
 */
public class ConsoleView implements IConsoleView{
    @Override
    public void printWelcomeMessage() {
        System.out.println("Welcome to TicTacToe game");
    }

    @Override
    public void printMenuMessage() {
        System.out.println("Press:");
        System.out.println("1 - to play single game");
        System.out.println("2 - to play in BO3 mode");
        System.out.println("3 - exit game");
    }

    @Override
    public void printCharacterNameSelectionMessage(int playerNumber) {
        System.out.println("Please choose name for player " + playerNumber);
    }

    @Override
    public void printCharacterPlacingMessage(IPlayer player) {
        System.out.println("Where would " + player.getName() + " place his character");
    }

    @Override
    public void printChoosingCoordinateMessage(String coordinate) {
        System.out.println("Please select " + coordinate + " coordinate:");
    }

    @Override
    public void printWrongCoordinatesMessage() {
        System.out.println("You've chosen wrong coordinates. Try again...");
    }

    @Override
    public void printWonMessage(IPlayer player) {
        System.out.println(player.getName() + " won!");
    }

    @Override
    public void printBoard(IBoard board) {
        for(int i = 0; i < board.getYSize(); i++) {
            String line = "";
            for(int j = 0; j < board.getXSize(); j++) {
                line += board.getField(j, i) + " | ";
            }
            System.out.println(line.substring(0, line.length() - 3));
        }
    }
}
