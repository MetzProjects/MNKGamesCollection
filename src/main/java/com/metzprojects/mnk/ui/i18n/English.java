package com.metzprojects.mnk.ui.i18n;

public final class English implements Text {

    //PROMPTS
    @Override
    public String promptGameType() {
        return "Please select which game you'd like to play:";
    }

    @Override
    public String promptSizeRows() {
        return "Please specify how many rows the board should have:";
    }

    @Override
    public String promptSizeCols() {
        return "Please specify how many columns the board should have:";
    }

    @Override
    public String promptReqToWin() {
        return "Please specify how many of their symbols each player is required to place in a row for a win:";
    }

    @Override
    public String promptRow() {
        return "Please choose a row: ";
    }

    @Override
    public String promptCol() {
        return "Please choose a column: ";
    }

    @Override
    public String promptLanguage() {
        return """
                
                Please select a language:
                1) English (Englisch)
                2) German (Deutsch)
                """;
    }

    @Override
    public String promptEncoding() {
        return """
                
                Please choose a text encoding::
                1) Unicode (Default - Recommended)
                2) ASCII (Choose this if you experience problems with displaying Unicode)
                """;
    }

    //[Y/N] OPTIONS
    @Override
    public String yes() {
        return "Y";
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
        return "Would you like to play against a bot?";
    }

    @Override
    public String promptPlayGravity() {
        return "Would you like to play with gravity enabled?";
    }

    @Override
    public String promptPlayAgain() {
        return "Would you like to play again?";
    }

    //ERROR MESSAGES
    @Override
    public String errorInputChoice() {
        return "Error: Please choose between '%s' and '%s'!\n";
    }

    @Override
    public String errorInputType() {
        return "Error: Input has to be a %s!\n";
    }

    @Override
    public String errorOutOfRange() {
        return "Error: Please enter a number between %d and %d!\n";
    }

    @Override
    public String errorCellTaken() {
        return "Error: The chosen cell has already been claimed!";
    }

    @Override
    public String errorColFull() {
        return "Error: The chosen column is already full!";
    }

    //GAME STATES
    @Override
    public String gameStateNext() {
        return "Player %c is next!\n";
    }

    @Override
    public String gameStateWin() {
        return "Player %c wins!\n";
    }

    @Override
    public String gameStateTie() {
        return "It's a tie!\n";
    }

    //GAME MESSAGES
    @Override
    public String gameStart() {
        return "Player %c begins!\n";
    }

    @Override
    public String gameRestarting() {
        return "Starting a new game!";
    }

    @Override
    public String gameExit() {
        return "Returning to Menu!";
    }

    @Override
    public String gameGoodbye() {
        return "Terminating program...";
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
        return "Connect Four";
    }

    @Override
    public String gameModeCustom() {
        return "Custom Game";
    }

    @Override
    public String settingsEncodingText() {
        return "Appearance";
    }

    @Override
    public String language() {
        return "Language";
    }

    @Override
    public String exitGame() {
        return "Exit";
    }

    //MENU DESCRIPTIONS
    @Override
    public String availabilityText() {
        return "Available MNK-Games:";
    }

    @Override
    public String descriptionMNK() {
        return "%-15s (%d x %d board, %d in a row, %s gravity)";
    }

    @Override
    public String descriptionMNKCustom() {
        return "%-15s (Allows you to create your own custom MNK-Game)";
    }

    //MISC
    @Override
    public String number() {
        return "Number";
    }

    @Override
    public String with() {
        return "with";
    }

    @Override
    public String without() {
        return "without";
    }

    @Override
    public String listBracket() {
        return ") ";
    }

    @Override
    public String row() {
        return "ROW";
    }

    @Override
    public String column() {
        return "COL";
    }

}
