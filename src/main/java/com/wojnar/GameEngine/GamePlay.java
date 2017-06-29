package com.wojnar.GameEngine;

import com.wojnar.GameEngine.utils.IBoard;
import com.wojnar.GameEngine.utils.IPlayer;
import com.wojnar.GameUI.IConsoleView;

import java.util.List;

/**
 * Created by bartomiej on 29.06.17.
 */
public class GamePlay implements IGamePlay{
    private IBoard board;
    private IWinChecker winChecker;
    private List<IPlayer> players;
    private IConsoleView consoleView;

    public GamePlay(List<IPlayer> players, IBoard board, IWinChecker winChecker, IConsoleView consoleView) {
        this.board = board;
        this.players = players;
        this.winChecker = winChecker;
        this.consoleView = consoleView;
    }

    @Override
    public void executeGamePlay() {

    }
}
