package com.wojnar.GameEngine;

import com.wojnar.Players.Player;
import com.wojnar.board.Boards;

/**
 * Created by bartomiej on 29.06.17.
 */
public interface IWinChecker {
    boolean checkIfPlayerWon(Boards playBoard, int startPosition, Player player);
}
