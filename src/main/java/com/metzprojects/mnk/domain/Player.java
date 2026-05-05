package com.metzprojects.mnk.domain;

//player icons can be changed here
public enum Player {
    X('X'),
    O('O');

    private final char playerIcon;

    Player(char playerIcon) {
        this.playerIcon = playerIcon;
    }

    public char getPlayerIcon() {
        return playerIcon;
    }

    public Player switchPlayer() {
        return this == X ? O : X;
    }
}
