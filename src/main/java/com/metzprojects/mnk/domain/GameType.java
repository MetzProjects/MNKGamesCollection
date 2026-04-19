package com.metzprojects.mnk.domain;

import static com.metzprojects.mnk.ui.i18n.I18n.getCurrentLanguage;

public enum GameType {
    TICTACTOE(3, 3, 3, false),
    GOMOKU(15, 15, 5, false),
    CONNECT_FOUR(6, 7, 4, true),
    CUSTOM(0, 0, 0, false);

    private final int rows, cols, reqToWin;
    private final boolean gravity;

    GameType(int rows, int cols, int reqToWin, boolean gravity) {
        this.rows = rows;
        this.cols = cols;
        this.reqToWin = reqToWin;
        this.gravity = gravity;
    }

    public String displayName() {
        return switch (this) {
            case TICTACTOE -> getCurrentLanguage().gameModeTicTacToe();
            case GOMOKU -> getCurrentLanguage().gameModeGomoku();
            case CONNECT_FOUR -> getCurrentLanguage().gameModeConnectFour();
            case CUSTOM -> getCurrentLanguage().gameModeCustom();
        };
    }

    public String describe() {
        if (this == CUSTOM) {
            return String.format(getCurrentLanguage().descriptionMNKCustom(), displayName());
        }
        return String.format(getCurrentLanguage().descriptionMNK(),
                displayName(),
                rows, cols, reqToWin,
                gravity ? getCurrentLanguage().with() : getCurrentLanguage().without()
        );
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int getReqToWin() {
        return reqToWin;
    }

    public boolean isGravity() {
        return gravity;
    }
}
