package com.wojnar.GameEngine;

import com.wojnar.Players.Player;
import com.wojnar.board.Boards;

/**
 * Created by bartomiej on 29.06.17.
 */
public class WinChecker implements IWinChecker {
    private int sequenceLength;

    public WinChecker(int sequenceLength) {
        this.sequenceLength = sequenceLength;
    }

    @Override
    public boolean checkIfPlayerWon(Boards playBoard, int startPosition, Player player) {
        return checkIfWonHorizontal(playBoard, player,startPosition) || checkIfWonWithDiagonal(playBoard, player,startPosition)
                || checkIfWonVertical(playBoard, player,startPosition);
    }

    boolean checkIfWonVertical(Boards playBoard, Player player, int startPosition) {
        int width = playBoard.getWidth();
        int fieldsUp = startPosition + width;
        int fieldsDown = startPosition - width;
        int hitUp = 0;
        int hitDown = 0;

        while (playBoard.cntainsKey(fieldsUp)) {
            if (hitChecker(playBoard, fieldsUp, player)) {
                hitUp++;
                fieldsUp += width;
            } else {
                break;
            }
        }
        while (playBoard.cntainsKey(fieldsDown)) {
            if (hitChecker(playBoard, fieldsDown, player)) {
                hitDown++;
                fieldsDown -= width;
            } else {
                break;
            }
        }
        if (hitDown + hitUp +1== sequenceLength)
            return true;
        else
            return false;
    }

    private boolean hitChecker(Boards board, int currentPosition,Player player) {
        if (board.getValue(currentPosition).equals(player.getCharacter()))
            return true;
        else
            return false;
    }

    private boolean checkIfWonWithDiagonal(Boards playBoard, Player player, int startPosition) {
        return true;
    }

    private boolean checkIfWonHorizontal(Boards playBoard, Player player, int startPosition) {
//
//        for (int i = 0; i < board.getWidth(); i++) {
//            if (board.get(startPosition).equals(sign)) {
//                horizontalCheck++;
//            }
//            startPosition++;
//        }
//        return horizontalCheck;
        return true;
    }
}
