package com.wojnar;

import com.wojnar.IOstrems.*;
import com.wojnar.board.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.InputMismatchException;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


/**
 * Created by paul on 03.07.17.
 */
public class TestPlayBoard {
    OutputController out= new OutputController(System.out);

    @DataProvider (name="avaiableSize")
    public Object[][] sizes(){
        return new Object[][]{{9,9},{123,7},{3,3}};
    }
    @DataProvider (name="valuseProvider")
    public Object[][] wherePutMark(){
        return new Object[][]{{9,AvailableMarks.O},{123,AvailableMarks.X},{3,AvailableMarks.EMPTY_MARK}};
    }

    @Test
    public void testAvaiableMarksAppropriateValueReturn(){
        assertEquals(AvailableMarks.O.getCharacter(),"O");
        assertEquals(AvailableMarks.X.getCharacter(),"X");
        assertEquals(AvailableMarks.EMPTY_MARK.getCharacter(),"|");
    }
    @Test(dataProvider ="avaiableSize" )
    public void testEmptyBoardCreation(int x, int y){
        BoardCreator myPlayBoard = new PlayBoard();
        myPlayBoard.createBoard(x,y);
        assertEquals(myPlayBoard.getSize(),x*y);

    }
    @Test(dataProvider ="avaiableSize" )
    public void testInformationBordProvides(int x, int y) {
        BoardCreator myPlayBoard = new PlayBoard();
        myPlayBoard.createBoard(x,y);
        assertEquals(myPlayBoard.getSize(),x*y);
        assertEquals(myPlayBoard.getHeight(),y);
        assertEquals(myPlayBoard.getWidth(),x);
        assertEquals(myPlayBoard.getValue(x),AvailableMarks.EMPTY_MARK);
    }

    @Test(dataProvider ="avaiableSize")
    public void testIfEachFieldInEmptyBoardContainEmptyValue(int x, int y){
        BoardCreator myPlayBoard = new PlayBoard();
        myPlayBoard.createBoard(x,y);
        for (int i=1;i<myPlayBoard.getSize()+1;i++){
            assertEquals(myPlayBoard.getValue(i), AvailableMarks.EMPTY_MARK);
        }
    }

    @Test(dataProvider ="avaiableSize")
    public void testUpdatingFieldByAvailableValues(int x, int y){
        BoardCreator myPlayBoard = new PlayBoard();
        myPlayBoard.createBoard(x,y);
        BoardUpdater updater = new BoardUpdater(myPlayBoard, out);
        for (Integer k : myPlayBoard.keySet()) {
            assertTrue(updater.updateBoard(k,AvailableMarks.X));
            assertEquals(myPlayBoard.getValue(k),AvailableMarks.X);
        }
    }

    @Test(dataProvider ="avaiableSize")
    public void testReturnClearBoardToNextPlay(int x, int y){
        BoardCreator myPlayBoard = new PlayBoard();
        myPlayBoard.createBoard(x,y);
        BoardUpdater updater = new BoardUpdater(myPlayBoard, out);
        for (Integer k : myPlayBoard.keySet()) {
            assertTrue(updater.updateBoard(k,AvailableMarks.O));
            assertEquals(myPlayBoard.getValue(k),AvailableMarks.O);
        }
        myPlayBoard.clearBoard();
        for (Integer k : myPlayBoard.keySet()) {
            assertEquals(myPlayBoard.getValue(k),AvailableMarks.EMPTY_MARK);
        }
    }

    @Test(dataProvider ="valuseProvider")
    public void testSetValue(int x, AvailableMarks mark) throws InputMismatchException {
        BoardCreator myPlayBoard = new PlayBoard();
        myPlayBoard.createBoard(100, 100);
        BoardUpdater updater = new BoardUpdater(myPlayBoard, out);
        assertTrue(myPlayBoard.setValue(x,mark));

    }

}
