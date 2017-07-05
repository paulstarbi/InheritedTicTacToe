package com.wojnar;

import com.wojnar.GameEngine.*;
import com.wojnar.Players.PlayerCreator;
import com.wojnar.board.AvailableMarks;
import com.wojnar.board.Boards;
import com.wojnar.Players.Player;
import com.wojnar.board.PlayBoard;
import com.wojnar.IOstrems.InputController;
import com.wojnar.IOstrems.OutputController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bartomiej on 27.06.17.
 */

public class TicTacToeMain {
    public static void main(String[] args){
        OutputController outputController = new OutputController(System.out);
        InputController inputController = new InputController(System.in, outputController);
        boolean isApplicationRunning = true;
        outputController.printWelcomeMessage();

        List<Player> players = new ArrayList<>();
        List<AvailableMarks> availableCharacters = new ArrayList<>();
        availableCharacters.add(AvailableMarks.X);
        availableCharacters.add(AvailableMarks.O);

        for (int i = 1; i < 3; i++) {
            players.add(PlayerCreator.createPlayer(i, inputController, availableCharacters,outputController));
        }

        Boards myPlayBoard = new PlayBoard();
        int characterSequenceLength = 3; //TODO take from player
        while(isApplicationRunning) {
            outputController.printMenuMessage();
            switch(inputController.nextInt()) {
                case 1: {
                    IBestOfThree bo3 = new BestOfThree(players, myPlayBoard,
                            new WinChecker(myPlayBoard, characterSequenceLength), inputController);
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
