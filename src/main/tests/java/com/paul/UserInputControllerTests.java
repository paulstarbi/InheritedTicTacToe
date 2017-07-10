package com.paul;

import com.paul.GameEngine.BestOfTreeFormat;
import com.paul.IOStreams.InputController;
import com.paul.IOStreams.OutputController;
import com.paul.Players.HumanPlayer;
import com.paul.Players.Player;
import com.paul.board.AvailableMarks;
import com.paul.board.Boards;
import com.paul.board.PlayBoard;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.testng.Assert.assertEquals;


/**
 * Created by paul on 05.07.17.
 */
public class UserInputControllerTests {

    List<Player> players;
    Boards myPlayBoard;
    InputController inputController;
    private OutputController out=new OutputController(new ByteArrayOutputStream());


    @DataProvider(name = "possiblMark")
    public Object[][] marksData(){
        return new Object[][]{{"O",AvailableMarks.O},
                {"X",AvailableMarks.X}};
    }
    @DataProvider(name = "wrongMarks")
    public Object[][] wrongMarksData(){
        return new Object[][]{{"q"},{"rrr"},{"/_s"},{"|"},{AvailableMarks.EMPTY_MARK.getCharacter()}};
    }
   @DataProvider(name = "numbers")
    public Object[][] numbers(){
        return new Object[][]{{"3",3},{"5",5},{"4",4},{"7",7}};
    }

    @BeforeTest
    public void ListOfPlayersCreate() {
        players = new ArrayList<>();
        players.add(new HumanPlayer("Marek", AvailableMarks.X));
        players.add(new HumanPlayer("Pawel", AvailableMarks.O));
    }
    @BeforeTest
    public void BoardCreate(){
        myPlayBoard=new PlayBoard();
        myPlayBoard.createBoard(43,26);
        assertEquals(myPlayBoard.getSize(),43*26);
    }

    @Test
    public void testGetScoresFromPlayer(){
        for (Player p:players) {
            assertEquals(p.getScore(),0);
        }}
    @Test
    public void testSetScorePlayer(){
        SoftAssert sa = new SoftAssert();
        for (Player p:players) {
            sa.assertEquals(p.getScore(),0);
            p.addPoint(3);
            sa.assertEquals(p.getScore(),3);
            p.addPoint(1);
            sa.assertEquals(p.getScore(),4);
        }
        sa.assertAll();
    }

    @Test(dataProvider = "possiblMark")
    public void testChooseWhichCharacterStartTheGame(String playerChar ,AvailableMarks marks){
        inputController = new InputController(new ByteArrayInputStream(playerChar.getBytes()),out);
        BestOfTreeFormat bestOfTreeFormat = new BestOfTreeFormat(players,myPlayBoard,inputController,out);
        assertEquals(bestOfTreeFormat.whoStart().getCharacter(),marks);

    }
    @Test(dataProvider = "wrongMarks", expectedExceptions = NoSuchElementException.class)
    public void testChooseWhichCharacterStartTheGameWrongMarks(String playerChar){
        inputController = new InputController(new ByteArrayInputStream(playerChar.getBytes()),out);
        BestOfTreeFormat bestOfTreeFormat = new BestOfTreeFormat(players,myPlayBoard,inputController,out);
        bestOfTreeFormat.whoStart();
    }
    @Test(dataProvider = "wrongMarks", expectedExceptions = NoSuchElementException.class)
    public void testTakeNumberFromUserWrongInput(String playerChar){
        inputController = new InputController(new ByteArrayInputStream(playerChar.getBytes()),out);
        inputController.takeNumberFromUser();
        inputController.takeNumberFromUser(3,3);
    }

    @Test
    public void testPlayerChangingTour(){
        Player currPlayer = players.get(0);
        assertEquals(currPlayer=currPlayer.switchPlayer(players), players.get(1));
        assertEquals(currPlayer=currPlayer.switchPlayer(players), players.get(0));
        assertEquals(currPlayer.switchPlayer(players), players.get(1));
    }
}


