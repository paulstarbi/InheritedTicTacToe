package com.wojnar.GameEngine;

import com.wojnar.GameEngine.utils.IBoard;
import com.wojnar.GameEngine.utils.IPlayer;
import com.wojnar.GameUI.IConsoleView;

import java.util.Arrays;
import java.util.Scanner;

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
        for (int i = 0; i < ySize - sequenceLength + 1; i++)
            for(int j = 0; j < xSize - sequenceLength + 1; j++) {
                boolean byDiagonal = true;
                boolean byBacksideDiagonal = true;
                for (int k = 0; k < sequenceLength; k++) {
                    if (!board.isFieldClaimedByCharacter(j, i, character))
                        byDiagonal = false;
                    if (!board.isFieldClaimedByCharacter(xSize - 1 - j, ySize - 1 - i, character))
                        byBacksideDiagonal = false;
                }
                if(byDiagonal || byBacksideDiagonal){
                    playerWon = true;
                    break;
                }
            }
        return playerWon;
    }

    public static int findOutLengthOfSequence(Scanner ic, IBoard board) {
        IConsoleView.printSelectingSequenceLengthMessage();

        while(!ic.hasNextInt())
            IConsoleView.printPassNumberErrorMessage();

        int length = ic.nextInt();
        if(length > board.getShorterSide()) {
            IConsoleView.printSequenceLengthTooBigMessage();
            length = board.getShorterSide();
        } else if ( length < 3) {
            IConsoleView.printSequenceLengthTooSmallMessage();
            length = 3;
        }

        return length;
    }
}
