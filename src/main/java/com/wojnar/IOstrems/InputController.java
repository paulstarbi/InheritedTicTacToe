package com.wojnar.IOstrems;

import com.wojnar.board.AvailableMarks;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by paul on 04.07.17.
 */
public class InputController {
    private Scanner entry;
    private InputStream input;
    private OutputController out;


    public InputController(InputStream in, OutputController outputController) {
        this.input =in;
        this.entry = new Scanner(in);
        this.out = outputController;
    }

    public String playerName() {
        return entry.next();
    }

    public AvailableMarks choseMark() {
        try{
            String mark =entry.next();
            if(mark.equalsIgnoreCase(AvailableMarks.O.getCharacter()))
                return AvailableMarks.O;
            else if(mark.equalsIgnoreCase(AvailableMarks.X.getCharacter()))
                return AvailableMarks.X;
            else
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException iae){
            out.printWrongCharacterSelection();
            return choseMark();
        }
    }
    public int takeNumberFromUser(){
        String userNum = entry.next();
        try {
            return Integer.parseInt(userNum);
        }catch (NumberFormatException nfe){
            out.printWrongSequence();
            return takeNumberFromUser();
        }
    }

    public int takeNumberFromUser(int width, int height) {
        String userIntput = entry.next();
        try {
            if (Integer.parseInt(userIntput) < 3)
                throw new InputMismatchException();
            else if (Integer.parseInt(userIntput) >width ||
                    Integer.parseInt(userIntput) > height)
                throw new IllegalArgumentException();
                return Integer.parseInt(userIntput);
        }catch (InputMismatchException ime ) {
            out.printWrongSequence(3);
            return takeNumberFromUser();
        }catch (NumberFormatException nfe){
                out.printWrongSequence();
                return takeNumberFromUser();
        }catch (IllegalArgumentException iae){
            out.printWrongSequence(width,height);
            return takeNumberFromUser(width,height);
        }
    }


    public int getWidth() {
        out.printBoardSizeSelectionMessage("OX");
        return takeNumberFromUser();
    }

    public int getHeight() {
        out.printBoardSizeSelectionMessage("OY");
        return takeNumberFromUser();
    }
}
