package com.wojnar.GameEngine.utils;

/**
 * Created by bartomiej on 29.06.17.
 */
public class Board implements IBoard{
    private String[][] fields;

    public Board(int sizeX, int sizeY) {
        fields = new String[sizeY][sizeX];
        clearBoard();
    }

    @Override
    public void clearBoard() {
        for(String[] row : fields)
            for(String field : row)
                field = " ";
    }

    @Override
    public String getField(int x, int y) {
        return fields[y][x];
    }

    @Override
    public void setField(int x, int y, String character) {
        fields[y][x] = character;
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
        return getField(x, y).equals(" ");
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
}
