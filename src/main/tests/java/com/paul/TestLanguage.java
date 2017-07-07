package com.paul;

import com.paul.IOStreams.OutputController;
import com.paul.Players.HumanPlayer;
import com.paul.Players.Player;
import com.paul.board.AvailableMarks;
import com.paul.board.PlayBoard;
import org.testng.annotations.Test;

/**
 * Created by paul on 07.07.17.
 */
public class TestLanguage {
    OutputController out = new OutputController(System.out);
    Player pawel = new HumanPlayer("Pawel", AvailableMarks.O);
    @Test
    public void outPL(){
//         out.changeLanguageToPolish();
//         out.printMenuMessage();
         out.printPlayerNameSelectionMessage(1);
         out.printMenuMessage();
         out.fieldBusy();
         out.fieldNonExist();
         out.printBoardSizeSelectionMessage("OX");
         out.printCharacterPlacingMessage(pawel);
         out.printCharacterSelectionMessage();
         out.printOneGameWonMessage(pawel);
    }
}
