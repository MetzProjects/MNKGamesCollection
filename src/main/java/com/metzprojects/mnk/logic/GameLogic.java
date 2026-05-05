package com.metzprojects.mnk.logic;

import com.metzprojects.mnk.domain.Board;
import com.metzprojects.mnk.domain.Player;
import com.metzprojects.mnk.domain.Symbols;
import com.metzprojects.mnk.ui.i18n.I18n;

import static com.metzprojects.mnk.ui.i18n.I18n.getCurrentLanguage;


public class GameLogic {

    private GameLogic() {
    }

    public static boolean isBoardFull(Board board) {
        for (int r = 0; r < board.getRows(); r++) {
            for (int c = 0; c < board.getCols(); c++) {
                if (board.getCell(r, c) == Symbols.EMPTY_CELL) {
                    return false;
                }
            }
        }
        return true;
    }

    public static char getWinner(Board board, int requiredToWin) {
        char winner;
        if ((winner = winChecker(board, requiredToWin, 0, 1)) != Symbols.EMPTY_CELL) return winner;
        if ((winner = winChecker(board, requiredToWin, 1, 0)) != Symbols.EMPTY_CELL) return winner;
        if ((winner = winChecker(board, requiredToWin, 1, 1)) != Symbols.EMPTY_CELL) return winner;
        if ((winner = winChecker(board, requiredToWin, 1, -1)) != Symbols.EMPTY_CELL) return winner;
        return Symbols.EMPTY_CELL;
    }

    private static char winChecker(Board board, int requiredToWin, int deltaRow, int deltaCol) {
        final int rows = board.getRows();
        final int cols = board.getCols();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                char cell = board.getCell(r, c);
                if (cell == Symbols.EMPTY_CELL) continue;
                int rr = r;
                int cc = c;
                int streak = 0;
                while (rr >= 0 && rr < rows && cc >= 0 && cc < cols && board.getCell(rr, cc) == cell) {
                    if (++streak >= requiredToWin) return cell;
                    rr += deltaRow;
                    cc += deltaCol;
                }
            }
        }
        return Symbols.EMPTY_CELL;
    }


    public static int getDropRow(Board board, int col) {
        final int rows = board.getRows();
        for (int row = rows - 1; row >= 0; row--) {
            if (board.getCell(row, col) == Symbols.EMPTY_CELL) return row;
        }
        return -1;
    }

    public static boolean isValidColumn(Board board, int col) {
        return col >= 0 && col < board.getCols() && board.getCell(0, col) == Symbols.EMPTY_CELL;
    }

    public static boolean isValidCell(Board board, int row, int col) {
        return row >= 0
                && row < board.getRows()
                && col >= 0 && col < board.getCols()
                && board.getCell(row, col) == Symbols.EMPTY_CELL;
    }

    public static void showGameState(char winner, boolean full, Player player) {
        if (winner != Symbols.EMPTY_CELL) {
            I18n.printf(getCurrentLanguage().gameStateWin(), winner);
        } else if (full) {
            I18n.print(getCurrentLanguage().gameStateTie());
        } else {
            I18n.printf(getCurrentLanguage().gameStateNext(), player.switchPlayer().getPlayerIcon());
        }
    }
}
