package com.paul.board;

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
    void clearBoard();
    int getHeight();
    boolean isFieldAvailable(int where);
    Set<Integer> keySet();
    void createBoard(int width, int height);
    boolean isKeyExist(int key);

    boolean isAvailableFieldExist();
}
