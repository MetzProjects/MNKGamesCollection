package com.metzprojects.mnk.domain;

import static com.metzprojects.mnk.ui.i18n.English.*;

public enum GameType {
    TICTACTOE(3, 3, 3, false, GAMEMODE_TICTACTOE),
    GOMOKU(15, 15, 5, false, GAMEMODE_GOMOKU),
    CONNECT_FOUR(6, 7, 4, true, GAMEMODE_CONNECT_FOUR),
    CUSTOM(0, 0, 0, false, GAMEMODE_CUSTOM),
    EXIT_GAME(0,0,0, false, GAMEMODE_EXIT);

    public final int rows, cols, reqToWin;
    public final boolean gravity;
    public final String gameName;

    GameType(int rows, int cols, int reqToWin, boolean gravity, String gameName) {
        this.rows = rows;
        this.cols = cols;
        this.reqToWin = reqToWin;
        this.gravity = gravity;
        this.gameName = gameName;
    }

    public String describe() {
        if (this == CUSTOM) {
            return String.format(DESCRIPTION_MNK_CUSTOM, gameName);
        } else if (this == EXIT_GAME) {
            return gameName;
        }
        return String.format(DESCRIPTION_MNK,
                gameName, rows, cols, reqToWin, gravity ? "with" : "no");
    }
}
