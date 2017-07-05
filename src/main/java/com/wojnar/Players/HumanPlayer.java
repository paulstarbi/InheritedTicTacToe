package com.wojnar.Players;

import com.wojnar.board.AvailableMarks;
import com.wojnar.IOstrems.OutputController;
import com.wojnar.IOstrems.InputController;

import java.util.List;

/**
 * Created by bartomiej on 29.06.17.
 */
public class HumanPlayer implements Player {
    private String name;
    private int score;
    private AvailableMarks character;

    public HumanPlayer() {
    }

    HumanPlayer(String name, AvailableMarks character) {
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
    public AvailableMarks getCharacter() {
        return character;
    }

    @Override
    public void setCharacter() {
        this.character = character;
    }

    public static HumanPlayer createPlayer(int i, InputController ic, List<AvailableMarks> availableCharacters, OutputController out) {
        out.printPlayerNameSelectionMessage(i);

        String playerName = ic.playerName();
        HumanPlayer newPlayer;
        if (availableCharacters.size() > 1) {
            out.printCharacterSelectionMessage();
            AvailableMarks chosenCharacter = ic.choseMark();
            int indexOfChosenCharacter = availableCharacters.indexOf(chosenCharacter);
            if (indexOfChosenCharacter != -1) {
                newPlayer = new HumanPlayer(playerName, availableCharacters.remove(indexOfChosenCharacter));
            } else {
                out.printWrongCharacterSelection();
                newPlayer = new HumanPlayer(playerName, availableCharacters.remove(0));
            }
        } else {
            newPlayer = new HumanPlayer(playerName, availableCharacters.remove(0));
        }

        return newPlayer;
    }
}
