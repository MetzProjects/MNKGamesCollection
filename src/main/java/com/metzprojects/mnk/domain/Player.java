package com.metzprojects.mnk.domain;

//player icons can be changed here
public enum Player {
    X('X'),
    O('O');

    private final char icon;

    Player(char icon) {
        this.icon = icon;
    }

    public char getIcon() {
        return icon;
    }

    public Player switchPlayer() {
        return this == X ? O : X;
    }
}
