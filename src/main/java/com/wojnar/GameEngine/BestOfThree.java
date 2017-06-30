package com.wojnar.GameEngine;

import com.wojnar.GameEngine.utils.IBoard;
import com.wojnar.GameEngine.utils.IPlayer;

import java.util.List;
import java.util.Scanner;

/**
 * Created by bartomiej on 30.06.17.
 */
public class BestOfThree implements IBestOfThree {
    private List<IPlayer> players;
    private IBoard board;
    private IWinChecker winChecker;
    private Scanner inputController;


    public BestOfThree(List<IPlayer> players, IBoard board, IWinChecker winChecker, Scanner inputController) {
        this.players = players;
        this.board = board;
        this.winChecker = winChecker;
        this.inputController = inputController;
    }

    @Override
    public void executeGameFormat() {
        boolean isBO3InProgress = true;
        while (isBO3InProgress) {
            IGamePlay gamePlay = new GamePlay(players, board, winChecker, inputController);
            isBO3InProgress = gamePlay.executeGamePlay();
        }
    }


}
