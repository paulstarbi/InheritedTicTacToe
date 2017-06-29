package com.wojnar.GameEngine;

import com.wojnar.GameEngine.utils.IPlayer;

/**
 * Created by bartomiej on 29.06.17.
 */
public interface IWinChecker {
    boolean checkIfPlayerWon(IPlayer player);
}
