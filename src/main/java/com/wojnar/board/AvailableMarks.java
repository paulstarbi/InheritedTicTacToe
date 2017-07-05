package com.wojnar.board;

/**
 * Created by paul on 03.07.17.
 */
public enum AvailableMarks {
    X("X"), O("O"), EMPTY_MARK("|");

    private String character;

    AvailableMarks(String character) {
        this.character = character;
    }

    public String getCharacter() {
        return character;
    }
}
