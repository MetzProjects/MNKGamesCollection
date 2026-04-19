package com.metzprojects.mnk.ui.console;

import com.metzprojects.mnk.domain.GameType;

import java.util.Scanner;

import static com.metzprojects.mnk.ui.i18n.I18n.getCurrentLanguage;

import com.metzprojects.mnk.domain.BoardStyle;
import com.metzprojects.mnk.domain.Language;
import com.metzprojects.mnk.domain.MenuAction;

public final class Menu {

    private Menu() {
    }

    public static Object getMenuChoice(Scanner sc) {
        final GameType[] games = GameType.values();
        final MenuAction[] actions = MenuAction.values();

        final StringBuilder menuText = new StringBuilder();

        menuText.append("\n").append(getCurrentLanguage().availabilityText()).append("\n\n");

        int index = 1;

        for (GameType game : games) {
            menuText.append(index++).append(getCurrentLanguage().listBracket()).append(game.describe()).append("\n");
        }
        for (MenuAction action : actions) {
            menuText.append(index++).append(getCurrentLanguage().listBracket()).append(action.label()).append("\n");
        }

        int choice = Input.getNumber(menuText + getCurrentLanguage().promptGameType(), 1, games.length + actions.length, sc);

        if (choice <= games.length) {
            return games[choice - 1];
        }
        return actions[choice - games.length - 1];
    }

    public static BoardStyle getBoardStyle(Scanner sc) {
        int choice = Input.getNumber(getCurrentLanguage().promptBoardStyle(), 1, 2, sc);
        return choice == 1 ? BoardStyle.UNICODE : BoardStyle.ASCII;
    }

    public static Language getLanguage(Scanner sc) {
        int choice = Input.getNumber(getCurrentLanguage().promptLanguage(), 1, 2, sc);
        return choice == 1 ? Language.ENGLISH : Language.GERMAN;
    }
}
