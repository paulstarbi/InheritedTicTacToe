package com.paul.Players;

import com.paul.IOStreams.InputController;
import com.paul.IOStreams.OutputController;
import com.paul.board.AvailableMarks;

import java.util.List;

/**
 * Created by paul on 05.07.17.
 */
  public interface PlayerCreator {

    static HumanPlayer createPlayer(int i, InputController ic, List< AvailableMarks > availableCharacters, OutputController
        out) {

            out.printPlayerNameSelectionMessage(i);

            String playerName = ic.playerName();
            HumanPlayer newPlayer;
            if (availableCharacters.size() > 1) {
                out.printCharacterSelectionMessage();
                AvailableMarks chosenCharacter = ic.choseMark();
                availableCharacters.remove(availableCharacters.indexOf(chosenCharacter));
                newPlayer = new HumanPlayer(playerName, chosenCharacter);
                }
            else {
                newPlayer = new HumanPlayer(playerName, availableCharacters.get(0));
            }

            return newPlayer;
        }
 }

