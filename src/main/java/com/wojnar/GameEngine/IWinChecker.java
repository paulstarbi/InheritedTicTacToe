package com.wojnar.GameEngine;

import com.wojnar.GameEngine.Players.Player;

/**
 * Created by bartomiej on 29.06.17.
 */
public interface IWinChecker {
    boolean checkIfPlayerWon(Player player);
}
