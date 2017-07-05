package com.wojnar.Players;

import com.wojnar.board.AvailableMarks;

import java.util.List;

/**
 * Created by bartomiej on 29.06.17.
 */
public interface Player {
    String getName();
    int getScore();
    void addPoint(int i);
    AvailableMarks getCharacter();
    Player changePlayer(List<Player> players);

}
