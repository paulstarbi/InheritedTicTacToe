package com.wojnar.GameEngine.Boards;

/**
 * Created by paul on 03.07.17.
 */
public interface Boards {
    int getSize();
    AvailableMarks getValue(int i);
    boolean setValue(int i, AvailableMarks o);
}
