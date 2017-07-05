package com.wojnar;

import com.wojnar.GameEngine.GamePlay;
import com.wojnar.IOstrems.InputController;
import com.wojnar.IOstrems.OutputController;
import com.wojnar.Players.HumanPlayer;
import com.wojnar.Players.Player;
import com.wojnar.Players.PlayerCreator;
import com.wojnar.board.AvailableMarks;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.print.attribute.standard.PrinterLocation;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;


/**
 * Created by paul on 05.07.17.
 */
public class GameTests {

    private OutputController out=new OutputController(System.out);
    List<Player> players;

    @Test
    public void testPlayerChangingTour(){
        players = new ArrayList<>();
        players.add(new HumanPlayer("Marek",AvailableMarks.X));
        players.add(new HumanPlayer("Pawel",AvailableMarks.O));
        Player currPlayer = players.get(0);
        assertEquals(currPlayer=currPlayer.changePlayer(players), players.get(1));
        assertEquals(currPlayer=currPlayer.changePlayer(players), players.get(0));
        assertEquals(currPlayer.changePlayer(players), players.get(1));
    }

//
//    @DataProvider(name="playerCreate")
//    public Object[][] playerData(){
//        return new Object[][]{{1,System.in,"X",out},{1,System.in, AvailableMarks.X,out},
//        {1,System.in,,out},{1,System.in,AvailableMarks.EMPTY_MARK,out}};
//    }
//
//    @Test(dataProvider = "playerCreate")
//    public void testCreatingNewPlayersByInterface(int i,InputStream in, List<AvailableMarks> list,
//                                                  OutputController out){
//
//        InputController inputController = new InputController(in,out);
//        PlayerCreator.createPlayer(i,inputController,list,out);
//    }


}
