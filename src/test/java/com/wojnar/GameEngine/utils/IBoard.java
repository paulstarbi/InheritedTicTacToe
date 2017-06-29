package com.wojnar.GameEngine.utils;

/**
 * Created by bartomiej on 29.06.17.
 */
public interface IBoard {
    String getField(int x, int y);
    void setField(int x, int y);
    boolean isFieldAvailable(int x, int y);
}
