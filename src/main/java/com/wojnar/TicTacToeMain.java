package com.wojnar;

import com.wojnar.GameEngine.*;
import com.wojnar.GameEngine.utils.Board;
import com.wojnar.GameEngine.utils.IBoard;
import com.wojnar.GameEngine.utils.IPlayer;
import com.wojnar.GameEngine.utils.Player;
import com.wojnar.GameUI.IConsoleView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by bartomiej on 27.06.17.
 */
public class TicTacToeMain {
    public static void main(String[] args){
        Scanner inputController = new Scanner(System.in);;
        boolean isApplicationRunning = true;
        IConsoleView.printWelcomeMessage();

        List<IPlayer> players = new ArrayList<>();
        List<String> availableCharacters = new ArrayList<>();
        availableCharacters.add("X");
        availableCharacters.add("O");

        for (int i = 1; i < 3; i++) {
            players.add(Player.createPlayer(i, inputController, availableCharacters));
        }

        IBoard board = Board.createBoard(inputController);
        int characterSequenceLength = WinChecker.findOutLengthOfSequence(inputController, board);

        //System.out.println(board.getXSize() + " is x size, " + board.getYSize() + "is y size of board");
        //System.out.println(characterSequenceLength + " is a length of sequence");

        while(isApplicationRunning) {
            IConsoleView.printMenuMessage();
            switch(inputController.nextInt()) {
                case 1: {
                    IBestOfThree bo3 = new BestOfThree(players, board, new WinChecker(board, characterSequenceLength), inputController);
                    bo3.executeGameFormat();
                    break;
                }
                default: {
                    isApplicationRunning = false;
                }
            }
        }

    }
}
