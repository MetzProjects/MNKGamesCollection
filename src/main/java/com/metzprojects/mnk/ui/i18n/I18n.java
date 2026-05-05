package com.metzprojects.mnk.ui.i18n;

public class I18n {
    private static Text currentLanguage = new English();
    private static TextEncoding encoding = TextEncoding.UNICODE;

    private I18n() {
    }

    public static Text getCurrentLanguage() {
        return currentLanguage;
    }

    public static TextEncoding getEncoding() {
        return encoding;
    }

    public static void setEnglish() {
        currentLanguage = new English();
    }

    public static void setGerman() {
        currentLanguage = new German();
    }

    public static void setEncoding(TextEncoding newEncoding) {
        encoding = newEncoding;
    }

    public static String formatUnicodeToAscii(String text) {
        if (encoding == TextEncoding.UNICODE) {
            return text;
        }
        return text
                .replace("ä", "ae")
                .replace("ö", "oe")
                .replace("ü", "ue")
                .replace("Ä", "Ae")
                .replace("Ö", "Oe")
                .replace("Ü", "Ue")
                .replace("ß", "ss");
    }


    public static void println(String text) {
        System.out.println(formatUnicodeToAscii(text));
    }

    public static void print(String text) {
        System.out.println(formatUnicodeToAscii(text));
    }

    public static void printf(String text, Object... args) {
        System.out.printf(formatUnicodeToAscii(text), args);
    }
}
