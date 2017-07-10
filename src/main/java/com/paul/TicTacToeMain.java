package com.paul;

import com.paul.GameEngine.*;
import com.paul.IOStreams.ConnectionCreate;
import com.paul.Players.PlayerCreator;
import com.paul.board.AvailableMarks;
import com.paul.Players.Player;
import com.paul.board.Boards;
import com.paul.board.PlayBoard;
import com.paul.IOStreams.InputController;
import com.paul.IOStreams.OutputController;

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
        Boards myPlayBoard = new PlayBoard();
        List<Player> players = new ArrayList<>();

        while(isApplicationRunning) {
            outControl.writeOut("printMenuMessage");
            switch(inControl.takeNumberFromUser()) {
                case 1: {
                    outControl.writeOut("printWelcomeMessage");
                    List<AvailableMarks> availableCharacters = new ArrayList<>();
                    availableCharacters.add(AvailableMarks.X);
                    availableCharacters.add(AvailableMarks.O);
                    for (int i = 1; i < 3; i++) {
                        players.add(PlayerCreator.createPlayer(i, inControl, availableCharacters,outControl));
                    }
                    myPlayBoard.createBoard(inControl.getWidth(),inControl.getHeight());
                    GameFormats bo3 = new BestOfTreeFormat(players, myPlayBoard, inControl, outControl);
                    bo3.executeGameFormat();
                    break;
                }
                case 2: {
                    outControl.switchLanguage();
                    break;
                }
                default: {
                    outControl.writeOut("printBayMessage");
                    isApplicationRunning = false;
                }
            }
        }
    }
}
