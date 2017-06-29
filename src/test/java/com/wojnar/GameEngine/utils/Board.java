package com.wojnar.GameEngine.utils;

/**
 * Created by bartomiej on 29.06.17.
 */
public class Board implements IBoard{
    String[][] fields;

    @Override
    public String getField(int x, int y) {
        return fields[y][x];
    }

    @Override
    public void setField(int x, int y) {

    }

    @Override
    public boolean isFieldAvailable(int x, int y) {
        return fields[y][x].equals(" ");
    }
}
