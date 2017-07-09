package com.paul.GameEngine;

import com.paul.IOStreams.InputController;
import com.paul.IOStreams.OutputController;
import com.paul.Players.HumanPlayer;
import com.paul.Players.Player;
import com.paul.board.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by paul on 06.07.17.
 */
public class GamePlayTests {

    Boards playBoard = new PlayBoard();
    Player player =new HumanPlayer("Pawel", AvailableMarks.O);
    Player player2 =new HumanPlayer("Marek", AvailableMarks.X);
    List<Player> playerList = new ArrayList<Player>();
    InputController inputController;
    OutputController out = new OutputController(new ByteArrayOutputStream());

    @DataProvider(name="startMark")
    public Object[][] startPlayer(){
        return new Object[][]{{player, player.getCharacter()},{player2, player2.getCharacter()}};
    }
    @DataProvider(name="vertical")
    public Object[][] verticalProvider(){
        return new Object[][]{{15,15,100,115,130,7,3},{15,15,45,30,60,7,3},{3,3,1,4,7,5,3},{6,7,4,10,16,5,3}};
    }
    @DataProvider(name="horizontal")
    public Object[][] horProvider(){
        return new Object[][]{{5,5,22,23,24,1,3},{15,15,48,46,47,1,3},{3,3,1,2,3,9,3},{6,7,4,5,6,2,3}};
    }
    @Test(dataProvider = "horizontal")
        public void testWinChecker(int width, int height, int pos1, int pos2, int pos3, int pos4, int seq){
        playBoard.createBoard(width,height);
        BoardUpdater updater=new BoardUpdater(playBoard,out);
        updater.updateBoard(pos1, AvailableMarks.O);
        updater.updateBoard(pos2,AvailableMarks.O);
        updater.updateBoard(pos3,AvailableMarks.O);
        GameStateChecker gameStateChecker = new GameStateChecker(seq);
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(gameStateChecker.checkIfPlayerWon(playBoard,pos1,player));
        sa.assertTrue(gameStateChecker.checkIfPlayerWon(playBoard,pos2,player));
        sa.assertTrue(gameStateChecker.checkIfPlayerWon(playBoard,pos3,player));
        sa.assertFalse(gameStateChecker.checkIfPlayerWon(playBoard,pos4,player));
        sa.assertAll();
    }

    @Test(dataProvider = "horizontal")
    public void testHorizontalWinCondition(int width, int height, int pos1, int pos2, int pos3, int pos4, int seq){
        playBoard.createBoard(width,height);
        BoardUpdater updater=new BoardUpdater(playBoard,out);
        updater.updateBoard(pos1, AvailableMarks.X);
        updater.updateBoard(pos2,AvailableMarks.X);
        updater.updateBoard(pos3,AvailableMarks.X);
        GameStateChecker gameStateChecker = new GameStateChecker(seq);
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(gameStateChecker.checkIfWonHorizontal(playBoard,player2,pos1));
        sa.assertTrue(gameStateChecker.checkIfWonHorizontal(playBoard,player2,pos2));
        sa.assertTrue(gameStateChecker.checkIfWonHorizontal(playBoard,player2,pos3));
        sa.assertFalse(gameStateChecker.checkIfWonHorizontal(playBoard,player2,pos4));
        sa.assertAll();
    }
    @Test(dataProvider = "vertical")
    public void testVerticalWinCondition(int width, int height, int pos1, int pos2, int pos3, int pos4, int seq){
        playBoard.createBoard(width,height);
        BoardUpdater updater=new BoardUpdater(playBoard,out);
        updater.updateBoard(pos1, AvailableMarks.O);
        updater.updateBoard(pos2,AvailableMarks.O);
        updater.updateBoard(pos3,AvailableMarks.O);
        GameStateChecker gameStateChecker = new GameStateChecker(seq);
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(gameStateChecker.checkIfWonVertical(playBoard,player,pos1));
        sa.assertTrue(gameStateChecker.checkIfWonVertical(playBoard,player,pos2));
        sa.assertTrue(gameStateChecker.checkIfWonVertical(playBoard,player,pos3));
        sa.assertFalse(gameStateChecker.checkIfWonVertical(playBoard,player,pos4));
        sa.assertAll();
    }
    @Test(dataProvider = "horizontal")
    public void testDiagonalUpToLeftWinCondition(int width, int height, int pos1, int pos2, int pos3, int pos4, int seq){
        playBoard.createBoard(width,height);
        BoardUpdater updater=new BoardUpdater(playBoard,out);
        updater.updateBoard(pos1, AvailableMarks.O);
        updater.updateBoard(pos2,AvailableMarks.O);
        updater.updateBoard(pos3,AvailableMarks.O);
        GameStateChecker gameStateChecker = new GameStateChecker(seq);
        SoftAssert sa = new SoftAssert();
        sa.assertFalse(gameStateChecker.checkIfWonWithDiagonalUpToLeft(playBoard,player,pos1));
        sa.assertFalse(gameStateChecker.checkIfWonWithDiagonalUpToLeft(playBoard,player,pos2));
        sa.assertFalse(gameStateChecker.checkIfWonWithDiagonalUpToLeft(playBoard,player,pos3));
        sa.assertFalse(gameStateChecker.checkIfWonWithDiagonalUpToLeft(playBoard,player,pos4));
        sa.assertAll();
    }
    @Test(dataProvider = "horizontal")
    public void testDiagonalUpToRightWinCondition(int width, int height, int pos1, int pos2, int pos3, int pos4, int seq){
        playBoard.createBoard(width,height);
        BoardUpdater updater=new BoardUpdater(playBoard,out);
        updater.updateBoard(pos1, AvailableMarks.O);
        updater.updateBoard(pos2,AvailableMarks.O);
        updater.updateBoard(pos3,AvailableMarks.O);
        GameStateChecker gameStateChecker = new GameStateChecker(seq);
        SoftAssert sa = new SoftAssert();
        sa.assertFalse(gameStateChecker.checkIfWonWithDiagonalUpToRight(playBoard,player,pos1));
        sa.assertFalse(gameStateChecker.checkIfWonWithDiagonalUpToRight(playBoard,player,pos2));
        sa.assertFalse(gameStateChecker.checkIfWonWithDiagonalUpToRight(playBoard,player,pos3));
        sa.assertFalse(gameStateChecker.checkIfWonWithDiagonalUpToRight(playBoard,player,pos4));
        sa.assertAll();
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
    @Test(dataProvider = "startMark")
    public void testWhoStartChosen(Player p, AvailableMarks marks){
        playerList.add(player);
        playerList.add(player2);
        inputController = new InputController(new ByteArrayInputStream(marks.getCharacter().getBytes()),out);
        BestOfTreeFormat bestOfTreeFormat=new BestOfTreeFormat(playerList,playBoard,inputController,out);
        assertEquals(bestOfTreeFormat.whoStart(),p);
    }

}
