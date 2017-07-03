package com.wojnar.GameEngine.Boards;

import com.wojnar.GameEngine.Boards.AvailableMarks;
import com.wojnar.GameEngine.Boards.Boards;
import com.wojnar.GameUI.IConsoleView;

import java.util.InputMismatchException;

/**
 * Created by paul on 03.07.17.
 */
public class BoardUpdator {

    private Boards myPlayBoard;

    public BoardUpdator(Boards myPlayBoard) {
        this.myPlayBoard = myPlayBoard;
    }


    public boolean updateBoard(int i, AvailableMarks o){
        try {
            myPlayBoard.setValue(i,o);
            return true;
        }catch (InputMismatchException ime){
            IConsoleView.printInputMismachExMessage();
            return false;
        }
    }
}
