package com.metzprojects.mnk.ui.console;

import com.metzprojects.mnk.domain.GameType;

import java.util.Scanner;

import static com.metzprojects.mnk.ui.i18n.English.*;

import com.metzprojects.mnk.domain.BoardStyle;

public final class Menu {

    private Menu() {} //prevents instantiation

    public static GameType getMNKGameType(Scanner sc) {
        final GameType[] games = GameType.values();
        final StringBuilder menuText = new StringBuilder();

        menuText.append("\n").append(AVAILABILITY_TEXT).append("\n\n");
        for (int i = 0; i < games.length; i++) {
            menuText.append(i + 1).append(") ").append(games[i].describe()).append("\n");
        }
        int choice = Input.getNumber(menuText + PROMPT_GAMETYPE, 1, games.length, sc);
        return games[choice - 1];
    }

    public static BoardStyle getBoardStyle(Scanner sc) {
        int choice = Input.getNumber(PROMPT_BOARD_STYLE, 1, 2, sc);
        return choice == 1 ? BoardStyle.UTF8 : BoardStyle.ASCII;
    }
}
