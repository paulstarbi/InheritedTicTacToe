package com.wojnar.GameEngine;

import com.wojnar.board.AvailableMarks;
import com.wojnar.Players.Player;
import com.wojnar.IOstrems.InputController;
import com.wojnar.IOstrems.OutputController;
import com.wojnar.board.Boards;

import java.util.List;

/**
 * Created by bartomiej on 30.06.17.
 */
public class BestOfThree implements IBestOfThree {
    private List<Player> players;
    private Boards playBoard;
    private IWinChecker winChecker;
    private InputController inputController;
    private OutputController out;


    public BestOfThree(List<Player> players, Boards board, IWinChecker winChecker,
                       InputController inputController, OutputController out) {
        this.players = players;
        this.playBoard = board;
        this.winChecker = winChecker;
        this.inputController = inputController;
        this.out = out;
    }


    @Override
    public void executeGameFormat() {
        int BestOfThree = 0;
        Player currPlayer = whoStart();
        while (BestOfThree<3) {
            IGamePlay gamePlay = new GamePlay(players, playBoard, winChecker, inputController, out);
            gamePlay.executeGamePlay(currPlayer);
            currPlayer=currPlayer.changePlayer(players);
            BestOfThree++;
        }
        out.printBO3WonMessage(players);
    }

    public Player whoStart() {
        out.printWhichPlayerHasToStar(players);
        AvailableMarks mark = inputController.choseMark();
        if (players.get(0).getCharacter()==mark)
            return players.get(0);
        else
            return players.get(1);
    }


}
