package com.wojnar.GameEngine.board;

import java.util.Set;

/**
 * Created by paul on 03.07.17.
 */
public interface Boards {
    int getSize();
    AvailableMarks getValue(int i);
    boolean setValue(int i, AvailableMarks o);
    Set entrySet();
    int getWidth();
}
