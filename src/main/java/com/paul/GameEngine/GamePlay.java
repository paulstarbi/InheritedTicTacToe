package com.paul.GameEngine;

import com.paul.IOStreams.ConnectionCreate;
import com.paul.Players.Player;
import com.paul.board.BoardDrawer;
import com.paul.board.BoardUpdater;
import com.paul.IOStreams.InputController;
import com.paul.IOStreams.OutputController;
import com.paul.board.Boards;

import java.util.List;

public class GamePlay implements IGamePlay{
    private final Boards playBoard;
    private final GameState winChecker;
    private final List<Player> players;
    private final InputController inputController;
    private final OutputController out;
    private final BoardUpdater updater;
    private boolean isGameInProgress;
    private ConnectionCreate onlineGame;

    GamePlay(List<Player> players, Boards board, GameState winChecker, InputController inputController, OutputController out) {
        this.playBoard = board;
        this.players = players;
        this.winChecker = winChecker;
        this.inputController = inputController;
        this.isGameInProgress=true;
        this.out=out;
        this.updater=new BoardUpdater(board,out);
    }

    public GamePlay(List<Player> players, Boards board, GameState winChecker, InputController inputController,
                    OutputController out, ConnectionCreate onlineGame) {
        this( players, board, winChecker, inputController, out);
        this.onlineGame=onlineGame;
    }

    @Override
    public boolean executeGamePlay(Player currPlayer) {
        playBoard.clearBoard();
            for (int turns = 0; isGameInProgress && turns < playBoard.getSize(); turns++) {
                BoardDrawer.drawBoard(playBoard);
                out.writeOut("printCharacterPlacingMessage",currPlayer.getCharacter());
                int where = getAvailableFieldNumFromUser(currPlayer);
//                onlineGame.
               checkStateOfGame(where, currPlayer);
                currPlayer = currPlayer.switchPlayer(players);
            }
        return false;
    }

     int getAvailableFieldNumFromUser(Player currPlayer) {
        boolean playerGotRightCoordinates = false;
        int where=1;
        while (!playerGotRightCoordinates) {
            where = inputController.takeNumberFromUser();
            if (where > 0 && where < playBoard.getSize()+1) {
                if (playBoard.isFieldAvailable(where)) {
                    updater.updateBoard(where, currPlayer.getCharacter());
                    playerGotRightCoordinates = true;
                } else {
                    out.writeOut("fieldBusy");
                    BoardDrawer.drawBoard(playBoard);
                }
            } else {
                out.writeOut("fieldNonExist");
                BoardDrawer.drawBoard(playBoard);
            }
        }
        return where;
    }

     boolean checkStateOfGame(int starPosition, Player player) {
        if (winChecker.checkIfPlayerWon(playBoard,starPosition,player)) {
            player.addPoint(3);
            out.writeOut("printOneGameWonMessage",player.getName() +"\n");
            isGameInProgress = false;
        }
        else if (winChecker.isMovesAvailable(playBoard)) {
            out.writeOut("printNoMovesAvailable");
            for (Player p : players) {
                p.addPoint(1);
            }
            isGameInProgress = false;
        }
        return isGameInProgress;
    }
}
