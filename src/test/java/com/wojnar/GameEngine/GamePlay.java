package com.wojnar.GameEngine;

import com.wojnar.GameEngine.utils.Board;
import com.wojnar.GameEngine.utils.Player;

import java.util.List;

/**
 * Created by bartomiej on 29.06.17.
 */
public class GamePlay implements IGamePlay{
    Board board;
    List<Player> players;

    public GamePlay(List<Player> players, Board board) {
        this.board = board;
        players = players;
    }

    @Override
    public void executeGameplay() {

    }
}
