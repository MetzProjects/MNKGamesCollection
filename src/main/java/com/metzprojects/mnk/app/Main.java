package com.metzprojects.mnk.app;

import com.metzprojects.mnk.ui.i18n.Language;
import com.metzprojects.mnk.domain.MenuAction;
import com.metzprojects.mnk.engine.MNKGame;
import com.metzprojects.mnk.domain.GameType;
import com.metzprojects.mnk.ui.console.Menu;
import com.metzprojects.mnk.ui.i18n.I18n;
import com.metzprojects.mnk.ui.i18n.TextEncoding;

import static com.metzprojects.mnk.ui.i18n.I18n.getCurrentLanguage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final MNKGame game = new MNKGame(scanner);

        do {
            Object choice = Menu.getMenuChoice(scanner);

            if (choice instanceof MenuAction action) {
                switch (action) {
                    case DISPLAY_SETTINGS -> {
                        TextEncoding encoding = Menu.getBoardStyle(scanner);
                        game.setBoardStyle(encoding);
                        I18n.setEncoding(encoding);
                        continue;
                    }
                    case LANGUAGE -> {
                        Language lang = Menu.getLanguage(scanner);
                        if (lang == Language.ENGLISH) I18n.setEnglish();
                        else I18n.setGerman();
                        continue;
                    }
                    case EXIT_GAME -> {
                        I18n.println(getCurrentLanguage().gameGoodbye());
                        scanner.close();
                        return;
                    }
                }
            }

            GameType type = (GameType) choice;

            if (type == GameType.CUSTOM) {
                game.setupGame();
            } else {
                game.setupGame(type.getRows(), type.getCols(), type.getRequiredToWin(), type.isGravity());
            }

            game.run();
        } while (true);

    }
}