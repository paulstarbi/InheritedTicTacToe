package com.wojnar.GameUI;

import com.wojnar.GameEngine.utils.IBoard;
import com.wojnar.GameEngine.utils.IPlayer;

/**
 * Created by bartomiej on 29.06.17.
 */
public interface IConsoleView {
    void printWelcomeMessage();
    void printMenuMessage();
    void printCharacterNameSelectionMessage(int playerNumber);
    void printCharacterPlacingMessage(IPlayer player);
    void printChoosingCoordinateMessage(String coordinate);
    void printWrongCoordinatesMessage();
    void printWonMessage(IPlayer player);
    void printBoard(IBoard board);
}
