package com.metzprojects.mnk.ui.i18n;

public final class German implements Lang {

    //PROMPTS
    @Override
    public String promptGameType() {
        return "Bitte wähle ein Spiel aus:";
    }

    @Override
    public String promptSizeRows() {
        return "Wie viele Zeilen sollte das Spielfeld haben:";
    }

    @Override
    public String promptSizeCols() {
        return "Wie viele Spalten sollte das Spielfeld haben:";
    }

    @Override
    public String promptReqToWin() {
        return "Wie viele Symbole muss ein Spieler in eine Reihe setzen, um zu gewinnen:";
    }

    @Override
    public String promptRow() {
        return "Bitte wähle eine Zeile aus: ";
    }

    @Override
    public String promptCol() {
        return "Bitte wähle eine Spalte aus: ";
    }

    @Override
    public String promptLanguage() {
        return """
                
                Wähle eine Sprache aus:
                1) Englisch (English)
                2) Deutsch (German)
                """;
    }

    @Override
    public String promptBoardStyle() {
        return """
                
                Wähle einen Spielfeld-Stil aus:
                1) Unicode (Standard - Empfohlen)
                2) ASCII (Empfohlen bei Problemen mit Unicode)
                """;
    }

    //[Y/N] OPTIONS
    @Override
    public String yes() {
        return "J";
    }

    @Override
    public String no() {
        return "N";
    }

    @Override
    public String promptOptions() {
        return "[%s/%s]\n";
    }

    @Override
    public String promptPlayBot() {
        return "Möchtest du gegen einen Bot spielen?";
    }

    @Override
    public String promptPlayGravity() {
        return "Möchtest du mit Gravitation spielen?";
    }

    @Override
    public String promptPlayAgain() {
        return "Möchtest du nochmal spielen?";
    }

    //ERROR MESSAGES
    @Override
    public String errorInputChoice() {
        return "Fehler: Bitte wähle zwischen '%s' und '%s' aus!\n";
    }

    @Override
    public String errorInputType() {
        return "Fehler: Eingabe muss eine %s sein!\n";
    }

    @Override
    public String errorOutOfRange() {
        return "Fehler: Eingabe muss eine Zahl zwischen %d und %d sein!\n";
    }

    @Override
    public String errorCellTaken() {
        return "Fehler: Gewähltes Feld ist bereits besetzt!";
    }

    @Override
    public String errorColFull() {
        return "Fehler: Spalte ist bereits voll!";
    }

    //GAME STATES
    @Override
    public String gameStateNext() {
        return "Spieler %c ist am Zug!\n";
    }

    @Override
    public String gameStateWin() {
        return "Spieler %c hat gewonnen!\n";
    }

    @Override
    public String gameStateTie() {
        return "Unentschieden!\n";
    }

    //GAME MESSAGES
    @Override
    public String gameStart() {
        return "Spieler %c ist als erstes dran!\n";
    }

    @Override
    public String gameRestarting() {
        return "Starte neues Spiel!";
    }

    @Override
    public String gameExit() {
        return "Kehre zum Menü zurück!";
    }

    @Override
    public String gameGoodbye() {
        return "Programm wird beendet...";
    }

    //MENU OPTIONS
    @Override
    public String gameModeTicTacToe() {
        return "Tic-Tac-Toe";
    }

    @Override
    public String gameModeGomoku() {
        return "Gomoku";
    }

    @Override
    public String gameModeConnectFour() {
        return "Vier-Gewinnt";
    }

    @Override
    public String gameModeCustom() {
        return "Eigenes Spiel";
    }

    @Override
    public String settingsBoardText() {
        return "Spielfeld-Optionen";
    }

    @Override
    public String language() {
        return "Sprachauswahl";
    }

    @Override
    public String exitGame() {
        return "Beenden";
    }

    //MENU DESCRIPTIONS
    @Override
    public String availabilityText() {
        return "Verfügbare MNK-Spiele:";
    }

    @Override
    public String descriptionMNK() {
        return "%-15s (%d x %d Spielfeld, %d in Reihe, %s Gravitation)";
    }

    @Override
    public String descriptionMNKCustom() {
        return "%-15s (Erstelle ein benutzerdefiniertes MNK-Spiel)";
    }

    //MISC
    @Override
    public String number() {
        return "Zahl";
    }

    @Override
    public String with() {
        return "mit";
    }

    @Override
    public String without() {
        return "ohne";
    }

    @Override
    public String listBracket() {
        return ") ";
    }

    @Override
    public String row() {
        return "ZEI";
    }

    @Override
    public String column() {
        return "SPA";
    }
}
