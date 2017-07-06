package com.wojnar;

import com.wojnar.GameEngine.BestOfThree;
import com.wojnar.board.WinChecker;
import com.wojnar.IOstrems.InputController;
import com.wojnar.IOstrems.OutputController;
import com.wojnar.Players.HumanPlayer;
import com.wojnar.Players.Player;
import com.wojnar.board.AvailableMarks;
import com.wojnar.board.Boards;
import com.wojnar.board.PlayBoard;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
        return new Object[][]{{"2"},{"rrr"},{"/_s"},{"|"},{AvailableMarks.EMPTY_MARK.getCharacter()}};
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


    @Test(dataProvider = "possiblMark")
    public void testChooseWhichCharacterStartTheGame(String playerChar ,AvailableMarks marks){
        inputController = new InputController(new ByteArrayInputStream(playerChar.getBytes()),out);
        BestOfThree bestOfThree = new BestOfThree(players,myPlayBoard,
                new WinChecker(myPlayBoard,3),inputController,out);
        assertEquals(bestOfThree.whoStart().getCharacter(),marks);

    }
    @Test(dataProvider = "wrongMarks", expectedExceptions = NoSuchElementException.class)
    public void testChooseWhichCharacterStartTheGameWrongMarks(String playerChar){
        inputController = new InputController(new ByteArrayInputStream(playerChar.getBytes()),out);
        BestOfThree bestOfThree = new BestOfThree(players,myPlayBoard,
                new WinChecker(myPlayBoard,3),inputController,out);
        bestOfThree.whoStart();
    }

    @Test
    public void testPlayerChangingTour(){
        Player currPlayer = players.get(0);
        assertEquals(currPlayer=currPlayer.changePlayer(players), players.get(1));
        assertEquals(currPlayer=currPlayer.changePlayer(players), players.get(0));
        assertEquals(currPlayer.changePlayer(players), players.get(1));
    }


}


