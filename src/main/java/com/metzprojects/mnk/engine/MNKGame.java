package com.metzprojects.mnk.engine;

import com.metzprojects.mnk.domain.Board;
import com.metzprojects.mnk.domain.BoardStyle;
import com.metzprojects.mnk.domain.Player;
import com.metzprojects.mnk.domain.Symbols;

import java.util.Scanner;

import static com.metzprojects.mnk.ui.console.MNKBoardPrinter.printBoard;
import static com.metzprojects.mnk.logic.GameLogic.*;
import static com.metzprojects.mnk.ui.console.Input.*;
import static com.metzprojects.mnk.logic.bot.RandomBot.makeRandomMove;
import static com.metzprojects.mnk.ui.i18n.I18n.getCurrentLanguage;


public class MNKGame {
    private final Scanner sc;
    private Board board;
    private int reqToWin;
    private boolean vsBot, gravity;
    private Player currentMNKPlayer = Player.X;
    private BoardStyle boardStyle = BoardStyle.UNICODE;

    //size restrictions can be adjusted below
    //WARNING: LARGE BOARDS MAY CAUSE PROBLEMS WITH VISIBILITY AND RENDERING IN CONSOLE!
    private static final int MIN_REQ_TO_WIN = 3;        //Values lower than 3 can always be achieved on second turn
    private static final int MIN_BOARD_SIZE = 3;        //Minimum should always be >= MIN_REQ_TO_WIN
    private static final int MAX_BOARD_SIZE = 20;       //Larger boards are subject to rendering problems in console


    public MNKGame(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        while (true) {
            playSingleGame();
            if (getChoice(getCurrentLanguage().promptPlayAgain(), getCurrentLanguage().yes(), getCurrentLanguage().no(), sc)) {
                System.out.println(getCurrentLanguage().gameRestarting());
                this.board = new Board(board.getRows(), board.getColumns());
                currentMNKPlayer = currentMNKPlayer.switchPlayer();
            } else {
                System.out.println(getCurrentLanguage().gameExit());
                break;
            }
        }
    }

    private void playSingleGame() {
        printBoard(board, gravity, boardStyle);
        System.out.printf(getCurrentLanguage().gameStart(), currentMNKPlayer.getIcon());
        while (true) {
            if (vsBot && currentMNKPlayer == Player.O) {
                makeRandomMove(board, gravity);
            } else {
                setHumanMove();
            }
            printBoard(board, gravity, boardStyle);
            final char winner = getWinner(board, reqToWin);
            final boolean full = isBoardFull(board);
            showGameState(winner, full, currentMNKPlayer);
            if (winner != Symbols.EMPTY || full) break;
            currentMNKPlayer = currentMNKPlayer.switchPlayer();
        }
    }

    private void setHumanMove() {
        while (true) {
            int row, col;
            if (gravity) {
                col = getNumber(getCurrentLanguage().promptCol(), 1, board.getColumns(), sc) - 1;
                if (isValidCol(board, col)) {
                    row = getDropRow(board, col);
                    board.setCell(row, col, currentMNKPlayer);
                    break;
                }
                System.out.println(getCurrentLanguage().errorColFull());
            } else {
                row = getNumber(getCurrentLanguage().promptRow(), 1, board.getRows(), sc) - 1;
                col = getNumber(getCurrentLanguage().promptCol(), 1, board.getColumns(), sc) - 1;
                if (isValidCell(board, row, col)) {
                    board.setCell(row, col, currentMNKPlayer);
                    break;
                }
                System.out.println(getCurrentLanguage().errorCellTaken());
            }
        }
    }

    public void setup() {
        setBoardSize();
        setReqToWin(board);
        setGravity();
        setVsBot();
    }

    public void setup(int rows, int cols, int reqToWin, boolean gravity) {
        setBoardSize(rows, cols);
        setReqToWin(reqToWin);
        setGravity(gravity);
        setVsBot();
    }

    public void setReqToWin(Board board) {
        final int maxReqToWin = Math.max(board.getRows(), board.getColumns());
        this.reqToWin = getNumber(getCurrentLanguage().promptReqToWin(), MIN_REQ_TO_WIN, maxReqToWin, sc);
    }

    public void setReqToWin(int reqToWin) {
        this.reqToWin = reqToWin;
    }

    public void setBoardSize() {
        final int rows = getNumber(getCurrentLanguage().promptSizeRows(), MIN_BOARD_SIZE, MAX_BOARD_SIZE, sc);
        final int cols = getNumber(getCurrentLanguage().promptSizeCols(), MIN_BOARD_SIZE, MAX_BOARD_SIZE, sc);
        this.board = new Board(rows, cols);
    }

    public void setBoardSize(int rows, int cols) {
        this.board = new Board(rows, cols);
    }

    public void setVsBot() {
        this.vsBot = getChoice(getCurrentLanguage().promptPlayBot(), getCurrentLanguage().yes(), getCurrentLanguage().no(), sc);
    }

    public void setGravity() {
        this.gravity = getChoice(getCurrentLanguage().promptPlayGravity(), getCurrentLanguage().yes(), getCurrentLanguage().no(), sc);
    }

    public void setGravity(boolean isGravityActive) {
        this.gravity = isGravityActive;
    }

    public void setBoardStyle(BoardStyle boardStyle) {
        this.boardStyle = boardStyle;
    }


}
