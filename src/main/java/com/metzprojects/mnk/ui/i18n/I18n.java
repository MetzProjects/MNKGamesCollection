package com.metzprojects.mnk.ui.i18n;

public class I18n {
    private static Lang currentLanguage = new English();

    private I18n() {
    }

    public static Lang getCurrentLanguage() {
        return currentLanguage;
    }

    public static void setEnglish() {
        currentLanguage = new English();
    }

    public static void setGerman() {
        currentLanguage = new German();
    }
}
