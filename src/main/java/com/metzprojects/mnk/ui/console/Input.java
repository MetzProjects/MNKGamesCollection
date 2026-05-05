package com.metzprojects.mnk.ui.console;

import com.metzprojects.mnk.ui.i18n.I18n;

import java.util.Scanner;

import static com.metzprojects.mnk.ui.i18n.I18n.getCurrentLanguage;

public final class Input {

    private Input() {
    }

    public static int getNumber(String text, int min, int max, Scanner scanner) {
        int input;
        while (true) {
            try {
                I18n.println(text);
                input = Integer.parseInt(scanner.nextLine());
                if (input < min || input > max) {
                    I18n.printf(getCurrentLanguage().errorOutOfRange(), min, max);
                    continue;
                }
                return input;
            } catch (Exception e) {
                I18n.printf(getCurrentLanguage().errorInputType(), getCurrentLanguage().number());
            }
        }
    }

    public static boolean getChoice(String text, String option1, String option2, Scanner scanner) {
        String input;
        I18n.println(text);
        I18n.printf(getCurrentLanguage().promptOptions(), option1, option2);
        while (true) {
            input = scanner.nextLine();
            if (input.equalsIgnoreCase(option1)) {
                return true;
            } else if (input.equalsIgnoreCase(option2)) {
                return false;
            } else {
                I18n.printf(getCurrentLanguage().errorInputChoice(), option1, option2);
            }
        }
    }

}
