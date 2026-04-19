package com.metzprojects.mnk.ui.console;

import java.util.Scanner;

import static com.metzprojects.mnk.ui.i18n.I18n.getCurrentLanguage;

public final class Input {

    private Input() {
    }

    public static int getNumber(String text, int min, int max, Scanner sc) {
        int input;
        while (true) {
            try {
                System.out.println(text);
                input = Integer.parseInt(sc.nextLine());
                if (input < min || input > max) {
                    System.out.printf(getCurrentLanguage().errorOutOfRange(), min, max);
                    continue;
                }
                return input;
            } catch (Exception e) {
                System.out.printf(getCurrentLanguage().errorInputType(), getCurrentLanguage().number());
            }
        }
    }

    public static boolean getChoice(String text, String opt1, String opt2, Scanner sc) {
        String input;
        System.out.println(text);
        System.out.printf(getCurrentLanguage().promptOptions(), opt1, opt2);
        while (true) {
            input = sc.nextLine();
            if (input.equalsIgnoreCase(opt1)) {
                return true;
            } else if (input.equalsIgnoreCase(opt2)) {
                return false;
            } else {
                System.out.printf(getCurrentLanguage().errorInputChoice(), opt1, opt2);
            }
        }
    }

}
