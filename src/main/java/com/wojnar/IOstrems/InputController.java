package com.wojnar.IOstrems;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by paul on 04.07.17.
 */
public class InputController {
    private Scanner entry;
    private InputStream input;
    private OutputController out;


    public InputController() {
        this.entry = new Scanner(System.in);
        this.out = new OutputController(System.out);
    }

    public InputController(Scanner entry, InputStream input) {
        this.input = input;
        this.entry = entry;
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

    public String choseMark() {
        return entry.next();
    }
}
