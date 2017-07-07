package com.paul.GameEngine;

import com.paul.IOStreams.OutputController;
import com.paul.Players.HumanPlayer;
import com.paul.Players.Player;
import com.paul.board.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by paul on 06.07.17.
 */
public class GamePlayTests {

    Boards playBoard = new PlayBoard();
    Player player =new HumanPlayer("Pawel", AvailableMarks.O);
    OutputController out = new OutputController(new ByteArrayOutputStream());

    @DataProvider(name="horizontal")
    public Object[][] horizontalProvider(){
        return new Object[][]{{15,15,100,115,130,7,3},{15,15,45,30,60,7,3},{3,3,1,4,7,5,3},{6,7,4,10,16,5,3}};
    }
    @Test
    public void drawer(){
        playBoard.createBoard(6,7);
        BoardDrawer.drawBoard(playBoard);
    }

    @Test(dataProvider = "horizontal")
    public void testVerticalWinCondition(int width, int height, int pos1, int pos2, int pos3, int pos4, int seq){
        playBoard.createBoard(width,height);
        BoardUpdater updater=new BoardUpdater(playBoard,out);
        updater.updateBoard(pos1, AvailableMarks.O);
        updater.updateBoard(pos2,AvailableMarks.O);
        updater.updateBoard(pos3,AvailableMarks.O);
        GameStateChecker gameStateChecker = new GameStateChecker(seq);
        assertTrue(gameStateChecker.checkIfWonVertical(playBoard,player,pos1));
        assertTrue(gameStateChecker.checkIfWonVertical(playBoard,player,pos2));
        assertTrue(gameStateChecker.checkIfWonVertical(playBoard,player,pos3));
        assertFalse(gameStateChecker.checkIfWonVertical(playBoard,player,pos4));
    }
    @Test
    public void testDiagonalUpToLeftWinCondition(){
        playBoard.createBoard(21,22);
        BoardUpdater updater=new BoardUpdater(playBoard,out);
        updater.updateBoard(21, AvailableMarks.O);
        updater.updateBoard(9,AvailableMarks.O);
        updater.updateBoard(15,AvailableMarks.O);
        BoardDrawer.drawBoard(playBoard);
        GameStateChecker gameStateChecker = new GameStateChecker(3);
        assertTrue(gameStateChecker.checkIfWonWithDiagonalUpToLeft(playBoard,player,21));
    }
    @Test
    public void testDiagonalUpToRightWinCondition(){
        playBoard.createBoard(5,5);
        BoardUpdater updater=new BoardUpdater(playBoard,out);
        updater.updateBoard(10, AvailableMarks.O);
        updater.updateBoard(14,AvailableMarks.O);
        updater.updateBoard(18,AvailableMarks.O);
        GameStateChecker gameStateChecker = new GameStateChecker(3);
        assertTrue(gameStateChecker.checkIfWonWithDiagonalUpToRight(playBoard,player,18));
    }
     @Test
    public void testHorizontalWinCondition(){
        playBoard.createBoard(3,3);
        BoardUpdater updater=new BoardUpdater(playBoard,out);
        updater.updateBoard(4, AvailableMarks.O);
        updater.updateBoard(5,AvailableMarks.O);
        updater.updateBoard(6,AvailableMarks.O);
        GameStateChecker gameStateChecker = new GameStateChecker(3);
        assertTrue(gameStateChecker.checkIfWonHorizontal(playBoard,player,5));
    }
    @Test
    public void testAvailableMoves(){
        playBoard.createBoard(3,3);
        BoardUpdater updater = new BoardUpdater(playBoard,out);
        GameStateChecker gameStateChecker = new GameStateChecker(3);

        assertFalse(gameStateChecker.isMovesAvailable(playBoard));

        for (int i = 1; i <playBoard.getSize()+1 ; i++) {
            updater.updateBoard(i,AvailableMarks.X);
        }
        assertTrue(gameStateChecker.isMovesAvailable(playBoard));
    }
}
