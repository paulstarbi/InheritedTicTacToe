package com.paul.IOStreams;

import com.paul.Players.Player;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by bartomiej on 29.06.17.
 */
public class OutputController {
    private  OutputStream output;
    String language;
    String country;
    Locale currentLocale;
    ResourceBundle messages;

    public void changeLanguageToPolish() {
        language="pl";
        country="PL";
        currentLocale = new Locale(language, country);
        messages = ResourceBundle.getBundle("Language", currentLocale);
        writeOut(messages.getString("greetings"));

    }
    public OutputController(OutputStream output) {
        this.output=output;
        this.language="en";
        this.country="US";
        this.currentLocale=new Locale(language,country);
        this.messages = ResourceBundle.getBundle("Language",currentLocale);
    }

     void writeOut(String message) {
        try {
            String nLineMessage = message.concat("\n");
            output.write(nLineMessage.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void printWelcomeMessage() {
        writeOut(messages.getString("printWelcomeMessage"));
    }
    public void printMenuMessage() {
        writeOut(messages.getString("printMenuMessage"));
    }
    public void printPlayerNameSelectionMessage(int playerNumber) {
        writeOut(messages.getString("printPlayerNameSelectionMessage")+" "+ playerNumber);
    }
    public void printCharacterSelectionMessage() {
        writeOut(messages.getString("printCharacterSelectionMessage"));
    }
    public void printWrongCharacterSelection() {
        writeOut(messages.getString("printWrongCharacterSelection"));
    }
    public void printBoardSizeSelectionMessage(String axis) {
        writeOut(messages.getString("printBoardSizeSelectionMessage")+" "+axis);
    }
    public void printSelectingSequenceLengthMessage() {
        writeOut(messages.getString("printSelectingSequenceLengthMessage"));
    }
    public void printCharacterPlacingMessage(Player player) {
        writeOut(player.getName() +" "+ messages.getString("printCharacterPlacingMessage") +" "+ player.getCharacter());
    }
    public void printBO3WonMessage(List<Player> players) {
        writeOut(players.get(0).getName() +" "+ messages.getString("printBO3WonMessage")+" "+ players.get(0).getScore() +
        "\n" +players.get(1).getName() +" "+ messages.getString("printBO3WonMessage")+" "+ players.get(1).getScore());
    }
    public void printOneGameWonMessage(Player player) {
        writeOut(player.getName() +" "+messages.getString("printOneGameWonMessage"));
    }
    public void fieldBusy() {
        writeOut(messages.getString("fieldBusy"));
    }
    public void fieldNonExist() {
        writeOut(messages.getString("fieldNonExist"));
    }
    public void printWrongSequence(int i) {
        writeOut(messages.getString("printWrongSequence")+i);
    }
    public void printWrongSequence(int width, int height) {
        writeOut(messages.getString("printWrongSequenceHeightWidth")+width+"x"+height);
    }
    public void printInputMismachExMessage() {
        writeOut(messages.getString("printInputMismachExMessage"));
    }
    public void printBayMessage() {
        writeOut(messages.getString("printBayMessage"));
    }
    public void printWhichPlayerHasToStar(List<Player> players) {
        writeOut(messages.getString("printWhichPlayerHasToStar")+" "+players.get(0).getCharacter()+
                " - "+players.get(0).getName()+ "\n"
                + players.get(1).getCharacter()+
                " - "+players.get(1).getName());
    }
    public void printNoMovesAvailable() {
        writeOut(messages.getString("printNoMovesAvailable"));
    }

}
