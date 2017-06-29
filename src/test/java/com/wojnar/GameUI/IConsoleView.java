package com.wojnar.GameUI;

/**
 * Created by bartomiej on 29.06.17.
 */
public interface IConsoleView {
    void printWelcomeMessage();
    void printMenuMessage();
    void printCharacterSelectionMessage();
    void printCharacterPlacingMessage(String character);
    void printChoosingCoordinateMessage(String coordinate);
    void printWrongCoordinatesMessage();
    void printWonMessage(String character);
    void printBoard(String[][] board);
}
