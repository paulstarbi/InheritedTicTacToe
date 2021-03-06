package com.paul.Players;

import com.paul.board.AvailableMarks;

import java.util.List;

/**
 * Created by bartomiej on 29.06.17.
 */
public interface Player {
    String getName();
    int getScore();
    void addPoint(int i);
    AvailableMarks getCharacter();
    Player switchPlayer(List<Player> players);

}
