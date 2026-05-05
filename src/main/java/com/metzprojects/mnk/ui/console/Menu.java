package com.metzprojects.mnk.ui.console;

import com.metzprojects.mnk.domain.GameType;

import java.util.Scanner;

import static com.metzprojects.mnk.ui.i18n.I18n.getCurrentLanguage;

import com.metzprojects.mnk.ui.i18n.TextEncoding;
import com.metzprojects.mnk.ui.i18n.Language;
import com.metzprojects.mnk.domain.MenuAction;

public final class Menu {

    private Menu() {
    }

    public static Object getMenuChoice(Scanner scanner) {
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

        int choice = Input.getNumber(menuText + getCurrentLanguage().promptGameType(), 1, games.length + actions.length, scanner);

        if (choice <= games.length) {
            return games[choice - 1];
        }
        return actions[choice - games.length - 1];
    }

    public static TextEncoding getBoardStyle(Scanner scanner) {
        int choice = Input.getNumber(getCurrentLanguage().promptEncoding(), 1, 2, scanner);
        return choice == 1 ? TextEncoding.UNICODE : TextEncoding.ASCII;
    }

    public static Language getLanguage(Scanner scanner) {
        int choice = Input.getNumber(getCurrentLanguage().promptLanguage(), 1, 2, scanner);
        return choice == 1 ? Language.ENGLISH : Language.GERMAN;
    }
}
