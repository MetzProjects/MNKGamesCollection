package com.metzprojects.mnk.ui.i18n;

public interface Lang {

    //PROMPTS
    String promptGameType();

    String promptSizeRows();

    String promptSizeCols();

    String promptReqToWin();

    String promptRow();

    String promptCol();

    String promptLanguage();

    String promptBoardStyle();

    //[Y/N] OPTIONS
    String yes();

    String no();

    String promptOptions();

    String promptPlayBot();

    String promptPlayGravity();

    String promptPlayAgain();


    //ERROR MESSAGES
    String errorInputChoice();

    String errorInputType();

    String errorOutOfRange();

    String errorCellTaken();

    String errorColFull();

    //GAME STATES
    String gameStateNext();

    String gameStateWin();

    String gameStateTie();

    //GAME MESSAGES
    String gameStart();

    String gameRestarting();

    String gameExit();

    String gameGoodbye();

    //MENU OPTIONS
    String gameModeTicTacToe();

    String gameModeGomoku();

    String gameModeConnectFour();

    String gameModeCustom();

    String settingsBoardText();

    String language();

    String exitGame();

    //MENU DESCRIPTIONS
    String availabilityText();

    String descriptionMNK();

    String descriptionMNKCustom();


    //MISC
    String number();

    String with();

    String without();

    String listBracket();

    String row();

    String column();

}
