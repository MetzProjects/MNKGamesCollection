package com.metzprojects.mnk.app;

import com.metzprojects.mnk.engine.MNKGame;
import com.metzprojects.mnk.domain.GameType;
import com.metzprojects.mnk.ui.console.Menu;

import static com.metzprojects.mnk.ui.i18n.English.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final MNKGame game = new MNKGame(sc);
        game.setBoardStyle(Menu.getBoardStyle(sc));
        do {
            GameType type = Menu.getMNKGameType(sc);
            if (type == GameType.EXIT_GAME) break;
            if (type == GameType.CUSTOM) game.setup();
            else game.setup(type.rows, type.cols, type.reqToWin, type.gravity);
            game.run();
        } while(true);
        System.out.println(GAME_GOODBYE);
        sc.close();
    }
}