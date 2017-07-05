package com.wojnar.IOstrems;

import com.wojnar.board.AvailableMarks;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by paul on 04.07.17.
 */
public class InputController {
    private Scanner entry;
    private InputStream input;
    private OutputController out;


    public InputController(InputStream in, OutputController outputController) {
        this.entry = new Scanner(System.in);
        this.out = outputController;
    }

    public void takeBoardSizes() {
        getSizeFromUser("OX", entry);
        getSizeFromUser("OY",entry);
     }

     private int getSizeFromUser(String axis, Scanner entry) {
        int size;
        while(!entry.hasNextInt())
            out.printPassNumberErrorMessage();
        size = entry.nextInt();
        if (size < 3) {
            out.printToSmallBoardSizeMessage(axis);
            size = 3;
        }
        return size;
    }

    public int nextInt() {
        return entry.nextInt();
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
}
