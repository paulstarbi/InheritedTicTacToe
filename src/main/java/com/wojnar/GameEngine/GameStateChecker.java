package com.wojnar.GameEngine;

import com.wojnar.Players.Player;
import com.wojnar.board.Boards;

/**
 * Created by bartomiej on 29.06.17.
 */
public class GameStateChecker implements GameState {
    private int sequenceLength;

    public GameStateChecker(int sequenceLength) {
        this.sequenceLength = sequenceLength;
    }

    @Override
    public boolean checkIfPlayerWon(Boards playBoard, int startPosition, Player player) {
        return checkIfWonHorizontal(playBoard, player,startPosition)
                || checkIfWonWithDiagonalUpToLeft(playBoard, player,startPosition)
                || checkIfWonWithDiagonalUpToRight(playBoard,player,startPosition)
                || checkIfWonVertical(playBoard, player,startPosition);

    }

    @Override
    public boolean isMovesAvailable(Boards playBoard) {
        return !playBoard.isAvailableFieldExist();
    }

    boolean checkIfWonVertical(Boards playBoard, Player player, int startPosition) {
        int width = playBoard.getWidth();
        int fieldsUp = startPosition + width;
        int fieldsDown = startPosition - width;
        int hit = 1;
        while (playBoard.isKeyExist(fieldsUp)) {
            if (hitChecker(playBoard, fieldsUp, player)) {
                hit++;
                fieldsUp += width;
            } else {
                break;
            }
        }
        while (playBoard.isKeyExist(fieldsDown)) {
            if (hitChecker(playBoard, fieldsDown, player)) {
                hit++;
                fieldsDown -= width;
            } else {
                break;
            }
        }
        if (hit==sequenceLength)
            return true;
        else
            return false;
    }

    boolean checkIfWonWithDiagonalUpToRight(Boards playBoard, Player player, int startPosition) {
        int width = playBoard.getWidth()-1;
        int fieldsUp = startPosition + width;
        int fieldsDown = startPosition - width;
        int hit = 1;
        if(!(startPosition%playBoard.getWidth()==1)){
        while (playBoard.isKeyExist(fieldsUp)) {
            if (hitChecker(playBoard, fieldsUp, player)) {
                hit++;
                if(fieldsUp%playBoard.getWidth()==1)
                    break;
                fieldsUp += width;
            } else {
                break;
            }
        }}
        if(!(startPosition%playBoard.getWidth()==0)){
        while (playBoard.isKeyExist(fieldsDown)) {
            if (hitChecker(playBoard, fieldsDown, player)) {
                hit++;
                if(fieldsDown%playBoard.getWidth()==0)
                    break;
                fieldsDown -= width;
            } else {
                break;
            }
        }}
        if(hit==sequenceLength)
            return true;
        else
            return false;
    }

    boolean checkIfWonWithDiagonalUpToLeft(Boards playBoard, Player player, int startPosition) {
        int width = playBoard.getWidth()+1;
        int fieldsUp = startPosition + width;
        int fieldsDown = startPosition - width;
        int hit = 1;
        if(!(startPosition%playBoard.getWidth()==0)){
            while (playBoard.isKeyExist(fieldsUp)) {
                if (hitChecker(playBoard, fieldsUp, player)) {
                    hit++;
                    if(fieldsUp%playBoard.getWidth()==0)
                        break;
                    fieldsUp += width;
                } else {
                    break;
                }
            }}
        if(!(startPosition%playBoard.getWidth()==1)){
            while (playBoard.isKeyExist(fieldsDown)) {
                if (hitChecker(playBoard, fieldsDown, player)) {
                    hit++;
                    if(fieldsDown%playBoard.getWidth()==1)
                        break;
                    fieldsDown -= width;
                } else {
                    break;
                }
            }}
        if(hit==sequenceLength)
            return true;
        else
            return false;
    }

    boolean checkIfWonHorizontal(Boards playBoard, Player player, int startPosition) {
        int width = 1;
        int fieldsUp = startPosition + width;
        int fieldsDown = startPosition - width;
        int hit = 1;
        if(!(startPosition%playBoard.getWidth()==0)){
            while (playBoard.isKeyExist(fieldsUp)) {
                if (hitChecker(playBoard, fieldsUp, player)) {
                    hit++;
                    if(fieldsUp%playBoard.getWidth()==0)
                        break;
                    fieldsUp += width;
                } else {
                    break;
                }
            }}
        if(!(startPosition%playBoard.getWidth()==1)){
            while (playBoard.isKeyExist(fieldsDown)) {
                if (hitChecker(playBoard, fieldsDown, player)) {
                    hit++;
                    if(fieldsDown%playBoard.getWidth()==1)
                        break;
                    fieldsDown -= width;
                } else {
                    break;
                }
            }}
        if(hit==sequenceLength)
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


}
