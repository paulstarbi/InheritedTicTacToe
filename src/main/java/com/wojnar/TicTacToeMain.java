package com.wojnar;

import com.wojnar.GameEngine.*;
import com.wojnar.Players.PlayerCreator;
import com.wojnar.board.AvailableMarks;
import com.wojnar.board.BoardCreator;
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
        OutputController outControl = new OutputController(System.out);
        InputController inControl = new InputController(System.in, outControl);
        boolean isApplicationRunning = true;
        outControl.printWelcomeMessage();
        BoardCreator myPlayBoard = new PlayBoard();

        List<Player> players = new ArrayList<>();
        List<AvailableMarks> availableCharacters = new ArrayList<>();
        availableCharacters.add(AvailableMarks.X);
        availableCharacters.add(AvailableMarks.O);

        for (int i = 1; i < 3; i++) {
            players.add(PlayerCreator.createPlayer(i, inControl, availableCharacters,outControl));
        }
        for (Player p:players) {
            System.out.println(p.getCharacter());
        }

        myPlayBoard.createBoard(inControl.getWidth(),inControl.getHeight());
        outControl.printSelectingSequenceLengthMessage();
        int characterSequenceLength = inControl.takeNumberFromUser(myPlayBoard.getWidth(),myPlayBoard.getHeight());

        while(isApplicationRunning) {
            outControl.printMenuMessage();
            switch(inControl.takeNumberFromUser()) {
                case 1: {
                    IBestOfThree bo3 = new BestOfThree(players, myPlayBoard,
                            new WinChecker(myPlayBoard, characterSequenceLength), inControl, outControl);
                    bo3.executeGameFormat();
                    break;
                }
                default: {
                    outControl.printGodbayMessage();
                    isApplicationRunning = false;
                }
            }
        }

    }
}
