package com.wojnar.GameEngine.board;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Set;

public class PlayBoard implements BoardCreator {

    private Map<Integer, AvailableMarks> playBoard;
    private int width;

    public PlayBoard(){
        this.playBoard =new HashMap<>();
    }

    @Override
    public void createBoard(int width, int height) {
        for (int i = 1; i<width* height +1; i++){
            playBoard.put(i, AvailableMarks.EMPTY_MARK);
            this.width=width;
        }
    }

    @Override
    public int getSize() {
        return playBoard.size();
    }

    @Override
    public AvailableMarks getValue(int i) {
        return playBoard.get(i);
    }

    @Override
    public boolean setValue(int where, AvailableMarks marks) {
            if (playBoard.containsKey(where)){
                playBoard.put(where,marks);
                return true;
            }
                else {
                throw new InputMismatchException();
            }
    }

    @Override
    public Set entrySet() {
        return playBoard.entrySet();
    }

    @Override
    public int getWidth() {
        return this.width;
    }
}
