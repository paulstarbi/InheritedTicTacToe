package com.wojnar.GameEngine;

import com.wojnar.IOstrems.OutputController;
import com.wojnar.Players.HumanPlayer;
import com.wojnar.Players.Player;
import com.wojnar.board.*;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;

import static org.testng.Assert.assertTrue;

/**
 * Created by paul on 06.07.17.
 */
public class GamePlayTests {

    Boards playBoard = new PlayBoard();
    Player player =new HumanPlayer("Pawel", AvailableMarks.O);
    OutputController out = new OutputController(new ByteArrayOutputStream());



    @Test
    public void testVerticalWinCondition(){
        playBoard.createBoard(5,5);
        BoardUpdater updater=new BoardUpdater(playBoard,out);
        updater.updateBoard(5, AvailableMarks.O);
        updater.updateBoard(10,AvailableMarks.O);
        updater.updateBoard(15,AvailableMarks.O);
        WinChecker winChecker = new WinChecker(3);
        assertTrue(winChecker.checkIfWonVertical(playBoard,player,10));
    }
    @Test
//     \thios one
    public void testDiagonalWinCondition(){
        playBoard.createBoard(5,5);
        BoardUpdater updater=new BoardUpdater(playBoard,out);
        updater.updateBoard(2, AvailableMarks.O);
        updater.updateBoard(8,AvailableMarks.O);
        updater.updateBoard(14,AvailableMarks.O);
        WinChecker winChecker = new WinChecker(3);
        assertTrue(winChecker.checkIfWonWithDiagonal(playBoard,player,8));
    }
}
