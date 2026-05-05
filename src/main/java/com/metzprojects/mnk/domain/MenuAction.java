package com.metzprojects.mnk.domain;

import static com.metzprojects.mnk.ui.i18n.I18n.getCurrentLanguage;

public enum MenuAction {
    LANGUAGE,
    DISPLAY_SETTINGS,
    EXIT_GAME;

    public String label() {
        return switch (this) {
            case LANGUAGE -> getCurrentLanguage().language();
            case DISPLAY_SETTINGS -> getCurrentLanguage().settingsEncodingText();
            case EXIT_GAME -> getCurrentLanguage().exitGame();
        };
    }
}
