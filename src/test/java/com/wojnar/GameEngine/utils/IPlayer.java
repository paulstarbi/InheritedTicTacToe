package com.wojnar.GameEngine.utils;

/**
 * Created by bartomiej on 29.06.17.
 */
public interface IPlayer {
    String getName();
    void setName(String name);
    int getScore();
    void addPoint();
    String getCharacter();
    void setCharacter();
}
