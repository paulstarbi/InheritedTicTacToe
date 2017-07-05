package com.wojnar.GameEngine.Players;

import com.wojnar.GameEngine.board.AvailableMarks;

/**
 * Created by bartomiej on 29.06.17.
 */
public interface Player {
    String getName();
    void setName(String name);
    int getScore();
    void addPoint();
    AvailableMarks getCharacter();
    void setCharacter();
}
