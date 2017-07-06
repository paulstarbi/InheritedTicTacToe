package com.wojnar.GameEngine;

import com.wojnar.Players.Player;
import com.wojnar.board.Boards;

/**
 * Created by bartomiej on 29.06.17.
 */
public class WinChecker implements IWinChecker {
    private Boards board;
    private int sequenceLength;

    public WinChecker(Boards board, int sequenceLength) {
        this.board = board;
        this.sequenceLength = sequenceLength;
    }

    @Override
    public boolean checkIfPlayerWon(Player player) {
        return checkIfWonWithStraightLine(player) || checkIfWonWithDiagonal(player);
    }

    private boolean checkIfWonWithDiagonal(Player player) {
        return true;
    }

    private boolean checkIfWonWithStraightLine(Player player) {
        return true;
    }

}
