//package com.wojnar.GameEngine;
//
//import com.wojnar.GameEngine.board.Boards;
//import com.wojnar.GameEngine.Players.Player;
//import com.wojnar.IOstrems.InputController;
//
//import java.util.List;
//import java.util.Scanner;
//
///**
// * Created by bartomiej on 30.06.17.
// */
//public class BestOfThree implements IBestOfThree {
//    private List<Player> players;
//    private Boards board;
//    private IWinChecker winChecker;
//    private Scanner inputController;
//
//
//    public BestOfThree(List<Player> players, Boards board, IWinChecker winChecker, InputController inputController) {
//        this.players = players;
//        this.board = board;
//        this.winChecker = winChecker;
//        this.inputController = inputController;
//    }
//
//    @Override
//    public void executeGameFormat() {
//        boolean isBO3InProgress = true;
//        while (isBO3InProgress) {
//            IGamePlay gamePlay = new GamePlay(players, board, winChecker, inputController);
//            isBO3InProgress = gamePlay.executeGamePlay();
//        }
//    }
//
//
//}
