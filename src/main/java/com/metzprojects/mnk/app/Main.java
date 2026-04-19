package com.metzprojects.mnk.app;

import com.metzprojects.mnk.domain.Language;
import com.metzprojects.mnk.domain.MenuAction;
import com.metzprojects.mnk.engine.MNKGame;
import com.metzprojects.mnk.domain.GameType;
import com.metzprojects.mnk.ui.console.Menu;
import com.metzprojects.mnk.ui.i18n.I18n;

import static com.metzprojects.mnk.ui.i18n.I18n.getCurrentLanguage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final MNKGame game = new MNKGame(sc);

        do {
            Object choice = Menu.getMenuChoice(sc);

            if (choice instanceof MenuAction action) {
                switch (action) {
                    case EXIT_GAME -> {
                        System.out.println(getCurrentLanguage().gameGoodbye());
                        sc.close();
                        return;
                    }
                    case SETTINGS_BOARD -> {
                        game.setBoardStyle(Menu.getBoardStyle(sc));
                        continue;
                    }
                    case LANGUAGE -> {
                        Language lang = Menu.getLanguage(sc);
                        if (lang == Language.ENGLISH) I18n.setEnglish();
                        else I18n.setGerman();
                        continue;
                    }
                }
            }

            GameType type = (GameType) choice;

            if (type == GameType.CUSTOM) {
                game.setup();
            } else {
                game.setup(type.getRows(), type.getCols(), type.getReqToWin(), type.isGravity());
            }

            game.run();
        } while (true);

    }
}