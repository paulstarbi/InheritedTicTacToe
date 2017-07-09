package com.paul.board;

import com.paul.IOStreams.OutputController;

import java.util.InputMismatchException;

/**
 * Created by paul on 03.07.17.
 */
public class BoardUpdater {

    private Boards myPlayBoard;
    private OutputController out;

    public BoardUpdater(Boards myPlayBoard, OutputController out) {
        this.out = out;
        this.myPlayBoard = myPlayBoard;
    }


    public boolean updateBoard(int i, AvailableMarks o){
        try {
            myPlayBoard.setValue(i,o);
            return true;
        }catch (InputMismatchException ime){
            out.printInputMismatchExMessage();
            return false;
        }
    }

}
