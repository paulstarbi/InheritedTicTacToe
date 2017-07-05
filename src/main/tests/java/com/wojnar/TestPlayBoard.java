package com.wojnar;

import com.wojnar.GameEngine.board.*;


import com.wojnar.IOstrems.OutputController;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


/**
 * Created by paul on 03.07.17.
 */
public class TestPlayBoard {
    OutputController out= new OutputController(System.out);

    @Test
    public void testAvaiableMarksAppropriateValueReturn(){
        assertEquals(AvailableMarks.O.getCharacter(),"O");
        assertEquals(AvailableMarks.X.getCharacter(),"X");
        assertEquals(AvailableMarks.EMPTY_MARK.getCharacter(),"|");
    }
    @Test
    public void testEmptyBoardCreation(){
        BoardCreator myPlayBoard = new PlayBoard();
        int width =8;
        int height = 8;
        myPlayBoard.createBoard(width,height);
        assertEquals(myPlayBoard.getSize(),width*height);
    }

    @Test
    public void testIfEachFieldInEmptyBoardContainEmptyValue(){
        BoardCreator myPlayBoard = new PlayBoard();
        int width =8;
        int height = 8;
        myPlayBoard.createBoard(width,height);
        for (int i=1;i<myPlayBoard.getSize()+1;i++){
            assertEquals(myPlayBoard.getValue(i), AvailableMarks.EMPTY_MARK);
        }
    }
    @Test
    public void testUpdatingFieldByDifferentValues(){
        BoardCreator myPlayBoard = new PlayBoard();
        int width =3;
        int height = 3;
        myPlayBoard.createBoard(width,height);
        BoardUpdater boardUpdator = new BoardUpdater(myPlayBoard, out);
        assertTrue(boardUpdator.updateBoard(1,AvailableMarks.X));
    }

}
