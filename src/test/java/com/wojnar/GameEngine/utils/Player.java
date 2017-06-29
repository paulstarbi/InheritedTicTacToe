package com.wojnar.GameEngine.utils;

import com.wojnar.GameEngine.utils.IPlayer;

/**
 * Created by bartomiej on 29.06.17.
 */
public class Player implements IPlayer {
    protected String name;
    protected int score;
    protected String character;

    public Player(String name, String character) {
        this.name = name;
        this.character = character;
        score = 0;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void addPoint() {
        ++score;
    }

    @Override
    public String getCharacter() {
        return character;
    }

    @Override
    public void setCharacter() {
        this.character = character;
    }
}
