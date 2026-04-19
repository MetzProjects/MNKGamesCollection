package com.metzprojects.mnk.domain;

import static com.metzprojects.mnk.ui.i18n.I18n.getCurrentLanguage;

public enum MenuAction {
    LANGUAGE,
    SETTINGS_BOARD,
    EXIT_GAME;

    public String label() {
        return switch (this) {
            case LANGUAGE -> getCurrentLanguage().language();
            case SETTINGS_BOARD -> getCurrentLanguage().settingsBoardText();
            case EXIT_GAME -> getCurrentLanguage().exitGame();
        };
    }
}
