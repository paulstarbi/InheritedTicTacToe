package com.paul.GameEngine;

import com.paul.IOStreams.ConnectionCreate;
import com.paul.board.AvailableMarks;
import com.paul.Players.Player;
import com.paul.IOStreams.InputController;
import com.paul.IOStreams.OutputController;
import com.paul.board.Boards;

import java.util.List;

/**
 * Created by bartomiej on 30.06.17.
 */
public class BestOfTreeFormat implements GameFormats {
    private int numGamesToPlay;
    private List<Player> players;
    private Boards playBoard;
    private InputController inputController;
    private OutputController out;


    public BestOfTreeFormat(List<Player> players, Boards board, InputController inputController, OutputController out) {
        this.players = players;
        this.playBoard = board;
        this.inputController = inputController;
        this.out = out;
        this.numGamesToPlay =3;
    }


    @Override
    public void executeGameFormat() {
        int BestOfThree = 0;
        Player currPlayer = whoStart();
        int seqToWin = winCondition();
        boolean local=false;
        if (local){
        while (BestOfThree < numGamesToPlay) {
            IGamePlay gamePlay = new GamePlay(players, playBoard, new GameStateChecker(seqToWin), inputController, out);
            gamePlay.executeGamePlay(currPlayer);
            currPlayer=currPlayer.switchPlayer(players);
            BestOfThree++;
        }
            out.writeOut("printBO3WonMessage",players.get(0).getName()+" "+players.get(0).getScore());
            out.writeOut("printBO3WonMessage",players.get(1).getName()+" "+players.get(1).getScore());
            }
        else {
            ConnectionCreate onlineGame=new ConnectionCreate(inputController,out);
            while (BestOfThree < numGamesToPlay) {
            IGamePlay gamePlay = new GamePlay(players, playBoard, new GameStateChecker(seqToWin), inputController, out,onlineGame);
            gamePlay.executeGamePlay(currPlayer);
            currPlayer=currPlayer.switchPlayer(players);
            BestOfThree++;
        }
        }
    }

    @Override
    public int winCondition() {
        out.writeOut("printSelectingSequenceLengthMessage");
        return inputController.takeNumberFromUser(playBoard.getWidth(),playBoard.getHeight());
    }

    public Player whoStart() {
        out.writeOut("printWhichPlayerHasToStar",players.get(0).getCharacter()+
                " - "+players.get(0).getName()+ "\n"
                + players.get(1).getCharacter()+
                " - "+players.get(1).getName());
        AvailableMarks mark = inputController.choseMark();
        if (players.get(0).getCharacter()==mark)
            return players.get(0);
        else
            return players.get(1);
    }


}
