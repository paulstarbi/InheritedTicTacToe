package com.paul.IOStreams;

import com.paul.board.AvailableMarks;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by paul on 04.07.17.
 */
public class InputController {
    private Scanner entry;
    private OutputController out;


    public InputController(InputStream in, OutputController outputController) {
        this.entry = new Scanner(in);
        this.out = outputController;
    }

    public String playerName() {
        String playerName = entry.next();
        return playerName.trim();
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
    public int takeNumberFromUser() {
        String userInput = entry.next();
        try {
            return Integer.parseInt(userInput);
        }catch (NumberFormatException nfe){
            out.printWrongSequence(3);
            return takeNumberFromUser();
        }
    }

    private int takeNumberFromUser(int minSize){
        String userInput = Integer.toString(takeNumberFromUser());
        try {
            if (Integer.parseInt(userInput) < minSize)
                throw new InputMismatchException();
            return Integer.parseInt(userInput);
        }catch (InputMismatchException ime ) {
            out.printWrongSequence(minSize);
            return takeNumberFromUser(minSize);
        }
    }

    public int takeNumberFromUser(int width, int height) {
        String userInput = Integer.toString(takeNumberFromUser(3));
        try {
            if (Integer.parseInt(userInput) >width ||
                    Integer.parseInt(userInput) > height)
                throw new IllegalArgumentException();
                return Integer.parseInt(userInput);
        }catch (IllegalArgumentException iae){
            out.printWrongSequence(width,height);
            return takeNumberFromUser(width,height);
        }
    }


    public int getWidth() {
        out.printBoardSizeSelectionMessage("OX");

        return takeNumberFromUser(3);
    }

    public int getHeight() {
        out.printBoardSizeSelectionMessage("OY");
        return takeNumberFromUser(3);
    }
}
