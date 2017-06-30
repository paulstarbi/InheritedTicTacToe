package com.wojnar.GameEngine.utils;

import com.wojnar.GameUI.IConsoleView;

import java.util.List;
import java.util.Scanner;

/**
 * Created by bartomiej on 29.06.17.
 */
public class Player implements IPlayer {
    protected String name;
    protected int score;
    protected String character;

    public Player(String name, String character) {
        this.name = name;
        this.character = character;
        score = 0;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void addPoint() {
        ++score;
    }

    @Override
    public String getCharacter() {
        return character;
    }

    @Override
    public void setCharacter() {
        this.character = character;
    }

    public static Player createPlayer(int i, Scanner ic, List<String> availableCharacters) {
        IConsoleView.printPlayerNameSelectionMessage(i);
        String playerName = ic.next();
        Player newPlayer;
        if (availableCharacters.size() > 1) {
            IConsoleView.printCharacterSelectionMessage();
            String chosenCharacter = ic.next();
            int indexOfChosenCharacter = availableCharacters.indexOf(chosenCharacter);
            if (indexOfChosenCharacter != -1) {
                newPlayer = new Player(playerName, availableCharacters.remove(indexOfChosenCharacter));
            } else {
                IConsoleView.printWrongCharacterSelection();
                newPlayer = new Player(playerName, availableCharacters.remove(0));
            }
        } else {
            newPlayer = new Player(playerName, availableCharacters.remove(0));
        }

        return newPlayer;
    }
}
