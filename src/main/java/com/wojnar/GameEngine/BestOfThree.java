package com.wojnar.GameEngine;

import com.wojnar.board.Boards;
import com.wojnar.Players.Player;
import com.wojnar.IOstrems.InputController;
import com.wojnar.IOstrems.OutputController;

import java.util.List;

/**
 * Created by bartomiej on 30.06.17.
 */
public class BestOfThree implements IBestOfThree {
    private List<Player> players;
    private Boards playBoard;
    private IWinChecker winChecker;
    private InputController inputController;


    public BestOfThree(List<Player> players, Boards board, IWinChecker winChecker, InputController inputController) {
        this.players = players;
        this.playBoard = board;
        this.winChecker = winChecker;
        this.inputController = inputController;
    }

    @Override
    public void executeGameFormat() {
        boolean isBO3InProgress = true;
        while (isBO3InProgress) {
            IGamePlay gamePlay = new GamePlay(players, playBoard, winChecker, inputController, new OutputController(System.out));
            isBO3InProgress = gamePlay.executeGamePlay();
        }
    }


}
