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

        if (verticalChecker(width,player,playBoard,startPosition)==sequenceLength)
            return true;
        else
            return false;
    }

    boolean checkIfWonWithDiagonal(Boards playBoard, Player player, int startPosition) {
        int width = playBoard.getWidth()+1;

        if (verticalChecker(width,player,playBoard,startPosition)==sequenceLength)
            return true;
        else
            return false;

    }


    boolean checkIfWonHorizontal(Boards playBoard, Player player, int startPosition) {
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

    private boolean hitChecker(Boards board, int currentPosition,Player player) {
        if (board.getValue(currentPosition).equals(player.getCharacter()))
            return true;
        else
            return false;
    }

    int verticalChecker(int width, Player player, Boards playBoard, int startPosition) {
        int fieldsUp = startPosition + width;
        int fieldsDown = startPosition - width;
        int hit = 1;
        while (playBoard.cntainsKey(fieldsUp)) {
            if (hitChecker(playBoard, fieldsUp, player)) {
                hit++;
                fieldsUp += width;
            } else {
                break;
            }
        }
        while (playBoard.cntainsKey(fieldsDown)) {
            if (hitChecker(playBoard, fieldsDown, player)) {
                hit++;
                fieldsDown -= width;
            } else {
                break;
            }
        }
        return hit;
    }
}
