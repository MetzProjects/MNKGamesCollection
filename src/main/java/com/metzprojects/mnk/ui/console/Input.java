package com.metzprojects.mnk.ui.console;

import java.util.Scanner;

import static com.metzprojects.mnk.ui.i18n.English.*;

public final class Input {

    private Input(){} //prevents instantiation

    public static int getNumber(String text, int min, int max, Scanner sc) {
        int input;
        while (true) {
            try {
                System.out.println(text);
                input = Integer.parseInt(sc.nextLine());
                if (input < min || input > max) {
                    System.out.printf(ERROR_OUT_OF_RANGE, min, max);
                    continue;
                }
                return input;
            } catch (Exception e) {
                System.out.printf(ERROR_INPUT_TYPE, "number");
            }
        }
    }

    public static boolean getChoice(String text, String opt1, String opt2, Scanner sc) {
        String input;
        System.out.println(text);
        System.out.printf(PROMPT_OPTIONS, opt1, opt2);
        while (true) {
            input = sc.nextLine();
            if (input.equalsIgnoreCase(opt1)) {
                return true;
            } else if (input.equalsIgnoreCase(opt2)) {
                return false;
            } else {
                System.out.printf(ERROR_INPUT_CHOICE, opt1, opt2);
            }
        }
    }

}
