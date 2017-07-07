package com.paul.Players;

import com.paul.board.AvailableMarks;

import java.util.List;

/**
 * Created by bartomiej on 29.06.17.
 */
public class HumanPlayer implements Player {
    private String name;
    private int score;
    private AvailableMarks character;

    public HumanPlayer(String name, AvailableMarks character) {
        this.name = name;
        this.character = character;
        score = 0;
    }

    @Override
    public Player changePlayer(List<Player> players) {
            if(this.getCharacter().equals(players.get(0).getCharacter()))
                return players.get(1);
            else
                return players.get(0);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void addPoint(int i) {
        score+=i;
    }

    @Override
    public AvailableMarks getCharacter() {
        return character;
    }

}
