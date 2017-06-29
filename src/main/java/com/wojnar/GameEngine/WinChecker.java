package com.wojnar.GameEngine;

import com.wojnar.GameEngine.utils.IBoard;
import com.wojnar.GameEngine.utils.IPlayer;

import java.util.Arrays;

/**
 * Created by bartomiej on 29.06.17.
 */
public class WinChecker implements IWinChecker {
    private IBoard board;
    private int sequenceLength;

    public WinChecker(IBoard board, int sequenceLength) {
        this.board = board;
        this.sequenceLength = sequenceLength;
    }

    @Override
    public boolean checkIfPlayerWon(IPlayer player) {
        return checkIfWonWithStraightLine(player) || checkIfWonWithDiagonal(player);
    }

    private boolean consistSequence(String[] array, String[] sequence) {
        boolean haveSequence = false;
        for(int i = 0; i < array.length - sequence.length; i++) {
            haveSequence = true;
            for(int j = 0; j < sequence.length; j++)
                if (!array[i + j].equals(sequence[j])) haveSequence = false;

            if(haveSequence) break;
        }

        return haveSequence;
    }

    private boolean checkAxisForSequence(String[] axis, String[] sequence) {
        boolean haveSequence = true;
        for (int i = 0; i < axis.length; i++){
            haveSequence = consistSequence(board.getRow(i), sequence);
            if (haveSequence) break;
        }

        return haveSequence;
    }

    private boolean checkIfWonWithStraightLine(IPlayer player) {
        boolean didPlayerWon = false;
        String[] sequence = new String[sequenceLength];
        Arrays.fill(sequence, player.getCharacter());

        for (int i = 0; i < board.getXSize(); i++)
            if(didPlayerWon = checkAxisForSequence(board.getRow(i), sequence)) break;

        if (!didPlayerWon)
            for (int i = 0; i < board.getYSize(); i++)
                if(didPlayerWon = checkAxisForSequence(board.getColumn(i), sequence)) break;

        return didPlayerWon;
    }

    private boolean checkIfWonWithDiagonal(IPlayer player) {
        boolean playerWon = false;
        String character = player.getCharacter();
        int xSize = board.getXSize();
        int ySize = board.getYSize();
        for (int i = 0; i < ySize - sequenceLength; i++)
            for(int j = 0; j < xSize - sequenceLength; j++) {
                playerWon = true;
                for (int k = 0; k < sequenceLength; k++) {
                    if (!board.getField(j, i).equals(character)) playerWon = false;
                    if (!board.getField(xSize - 1 -j, ySize - 1 - i).equals(character)) playerWon = false;
                }
                if(playerWon) break;
            }
        return playerWon;
    }
}
