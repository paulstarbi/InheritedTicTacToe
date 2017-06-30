package com.wojnar.GameEngine.utils;

import com.wojnar.GameUI.IConsoleView;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by bartomiej on 29.06.17.
 */
public class Board implements IBoard{
    private String[][] fields;

    private Board(int sizeX, int sizeY) {
        fields = new String[sizeY][sizeX];
        clearBoard();
    }

    @Override
    public void clearBoard() {
        for(String[] row : fields)
            Arrays.fill(row, " ");
    }

    @Override
    public boolean isFieldClaimedByCharacter(int x, int y, String character) {
        return getField(x, y).equals(character);
    }

    @Override
    public String getField(int x, int y) {
        return fields[y][x];
    }

    @Override
    public void setField(int x, int y, String character) {
        fields[y-1][x-1] = character;
    }

    @Override
    public int getXSize() {
        return fields[0].length;
    }

    @Override
    public int getYSize() {
        return fields.length;
    }

    @Override
    public boolean isFieldAvailable(int x, int y) {
        return getField(x - 1 , y - 1).equals(" ");
    }

    @Override
    public int getShorterSide() {
        return getYSize() < getXSize() ? getYSize() : getXSize();
    }

    @Override
    public String[] getRow(int rowIndex) {
        return fields[rowIndex];
    }

    @Override
    public String[] getColumn(int columnIndex) {
        String[] column = new String[fields.length];
        for (int i = 0; i < columnIndex; i++)
            column[i] = fields[i][columnIndex];

        return column;
    }

    public static Board createBoard(Scanner ic) {
        int oX = getSizeFromUser("OX", ic);
        int oY = getSizeFromUser("OY", ic);
        return new Board(oX, oY);
    }

    private static int getSizeFromUser(String axis, Scanner ic) {
        IConsoleView.printBoardSizeSelectionMessage(axis);
        int size;
        while(!ic.hasNextInt())
            IConsoleView.printPassNumberErrorMessage();

        size = ic.nextInt();
        if (size < 3) {
            IConsoleView.printToSmallBoardSizeMessage(axis);
            size = 3;
        }

        return size;
    }
}
