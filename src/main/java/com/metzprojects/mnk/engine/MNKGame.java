package com.metzprojects.mnk.engine;

import com.metzprojects.mnk.domain.Board;
import com.metzprojects.mnk.ui.i18n.I18n;
import com.metzprojects.mnk.ui.i18n.TextEncoding;
import com.metzprojects.mnk.domain.Player;
import com.metzprojects.mnk.domain.Symbols;

import java.util.Scanner;

import static com.metzprojects.mnk.ui.console.MNKBoardPrinter.printBoard;
import static com.metzprojects.mnk.logic.GameLogic.*;
import static com.metzprojects.mnk.ui.console.Input.*;
import static com.metzprojects.mnk.logic.bot.RandomBot.makeRandomMove;
import static com.metzprojects.mnk.ui.i18n.I18n.getCurrentLanguage;


public class MNKGame {
    private final Scanner scanner;
    private Board board;
    private int requiredToWin;
    private boolean versusBot, gravity;
    private Player currentMNKPlayer = Player.X;
    private TextEncoding textEncoding = TextEncoding.UNICODE;

    //size restrictions can be adjusted below
    //WARNING: LARGE BOARDS MAY CAUSE PROBLEMS WITH VISIBILITY AND RENDERING IN CONSOLE!
    private static final int MIN_REQ_TO_WIN = 3;        //Values lower than 3 can always be achieved on second turn
    private static final int MIN_BOARD_SIZE = 3;        //Minimum should always be >= MIN_REQ_TO_WIN
    private static final int MAX_BOARD_SIZE = 20;       //Larger boards are subject to rendering problems in console


    public MNKGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        while (true) {
            playSingleGame();
            if (getChoice(getCurrentLanguage().promptPlayAgain(), getCurrentLanguage().yes(), getCurrentLanguage().no(), scanner)) {
                I18n.println(getCurrentLanguage().gameRestarting());
                this.board = new Board(board.getRows(), board.getCols());
                currentMNKPlayer = currentMNKPlayer.switchPlayer();
            } else {
                I18n.println(getCurrentLanguage().gameExit());
                break;
            }
        }
    }

    private void playSingleGame() {
        printBoard(board, gravity, textEncoding);
        I18n.printf(getCurrentLanguage().gameStart(), currentMNKPlayer.getPlayerIcon());
        while (true) {
            if (versusBot && currentMNKPlayer == Player.O) {
                makeRandomMove(board, gravity);
            } else {
                setHumanMove();
            }
            printBoard(board, gravity, textEncoding);
            final char winner = getWinner(board, requiredToWin);
            final boolean full = isBoardFull(board);
            showGameState(winner, full, currentMNKPlayer);
            if (winner != Symbols.EMPTY_CELL || full) break;
            currentMNKPlayer = currentMNKPlayer.switchPlayer();
        }
    }

    private void setHumanMove() {
        while (true) {
            int row, col;
            if (gravity) {
                col = getNumber(getCurrentLanguage().promptCol(), 1, board.getCols(), scanner) - 1;
                if (isValidColumn(board, col)) {
                    row = getDropRow(board, col);
                    board.setCell(row, col, currentMNKPlayer);
                    break;
                }
                I18n.println(getCurrentLanguage().errorColFull());
            } else {
                row = getNumber(getCurrentLanguage().promptRow(), 1, board.getRows(), scanner) - 1;
                col = getNumber(getCurrentLanguage().promptCol(), 1, board.getCols(), scanner) - 1;
                if (isValidCell(board, row, col)) {
                    board.setCell(row, col, currentMNKPlayer);
                    break;
                }
                I18n.println(getCurrentLanguage().errorCellTaken());
            }
        }
    }

    public void setupGame() {
        setBoardSize();
        setRequiredToWin(board);
        setGravity();
        setVsBot();
    }

    public void setupGame(int rows, int cols, int requiredToWin, boolean gravity) {
        setBoardSize(rows, cols);
        setRequiredToWin(requiredToWin);
        setGravity(gravity);
        setVsBot();
    }

    public void setRequiredToWin(Board board) {
        final int maxReqToWin = Math.max(board.getRows(), board.getCols());
        this.requiredToWin = getNumber(getCurrentLanguage().promptReqToWin(), MIN_REQ_TO_WIN, maxReqToWin, scanner);
    }

    public void setRequiredToWin(int requiredToWin) {
        this.requiredToWin = requiredToWin;
    }

    public void setBoardSize() {
        final int rows = getNumber(getCurrentLanguage().promptSizeRows(), MIN_BOARD_SIZE, MAX_BOARD_SIZE, scanner);
        final int cols = getNumber(getCurrentLanguage().promptSizeCols(), MIN_BOARD_SIZE, MAX_BOARD_SIZE, scanner);
        this.board = new Board(rows, cols);
    }

    public void setBoardSize(int rows, int cols) {
        this.board = new Board(rows, cols);
    }

    public void setVsBot() {
        this.versusBot = getChoice(getCurrentLanguage().promptPlayBot(), getCurrentLanguage().yes(), getCurrentLanguage().no(), scanner);
    }

    public void setGravity() {
        this.gravity = getChoice(getCurrentLanguage().promptPlayGravity(), getCurrentLanguage().yes(), getCurrentLanguage().no(), scanner);
    }

    public void setGravity(boolean gravity) {
        this.gravity = gravity;
    }

    public void setBoardStyle(TextEncoding textEncoding) {
        this.textEncoding = textEncoding;
    }


}
