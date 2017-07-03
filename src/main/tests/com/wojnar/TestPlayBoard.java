package com.wojnar;

import com.wojnar.GameEngine.Boards.AvailableMarks;
import com.wojnar.GameEngine.Boards.BoardCreator;
import com.wojnar.GameEngine.Boards.BoardUpdator;
import com.wojnar.GameEngine.Boards.PlayBoard;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by paul on 03.07.17.
 */
public class TestPlayBoard {

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
        int width =8;
        int height = 8;
        myPlayBoard.createBoard(width,height);
        BoardUpdator boardUpdator = new BoardUpdator(myPlayBoard);
        assertFalse(boardUpdator.updateBoard(65,AvailableMarks.O));
        assertTrue(boardUpdator.updateBoard(1,AvailableMarks.X));
    }


}
