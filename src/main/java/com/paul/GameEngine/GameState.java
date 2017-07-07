package com.paul.GameEngine;

import com.paul.Players.Player;
import com.paul.board.Boards;

/**
 * Created by bartomiej on 29.06.17.
 */
public interface GameState {
    boolean checkIfPlayerWon(Boards playBoard, int startPosition, Player player);
    boolean isMovesAvailable(Boards playBoard);
}
