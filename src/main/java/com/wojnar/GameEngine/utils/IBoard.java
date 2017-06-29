package com.wojnar.GameEngine.utils;

/**
 * Created by bartomiej on 29.06.17.
 */
public interface IBoard {
    String getField(int x, int y);
    void setField(int x, int y, String character);
    int getXSize();
    int getYSize();
    boolean isFieldAvailable(int x, int y);
    int getShorterSide();
    String[] getRow(int index);
    String[] getColumn(int index);
    void clearBoard();
}
