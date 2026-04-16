package com.metzprojects.mnk.logic;

import com.metzprojects.mnk.domain.Board;
import com.metzprojects.mnk.domain.Player;
import com.metzprojects.mnk.domain.Symbols;

import static com.metzprojects.mnk.ui.i18n.English.*;


public class GameLogic {

    private GameLogic() {} //prevents instantiation

    public static boolean isBoardFull(Board board) {
        for (int r = 0; r < board.getRows(); r++) {
            for (int c = 0; c < board.getColumns(); c++) {
                if (board.getCell(r, c) == Symbols.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static char getWinner(Board board, int req) {
        char winner;
        if ((winner = winChecker(board, req, 0, 1)) != Symbols.EMPTY) return winner;
        if ((winner = winChecker(board, req, 1, 0)) != Symbols.EMPTY) return winner;
        if ((winner = winChecker(board, req, 1, 1)) != Symbols.EMPTY) return winner;
        if ((winner = winChecker(board, req, 1, -1)) != Symbols.EMPTY) return winner;
        return Symbols.EMPTY;
    }

    private static char winChecker(Board board, int req, int dRow, int dCol) {
        final int rows = board.getRows();
        final int cols = board.getColumns();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                char cell = board.getCell(r, c);
                if (cell == Symbols.EMPTY) continue;
                int rr = r;
                int cc = c;
                int streak = 0;
                while (rr >= 0 && rr < rows && cc >= 0 && cc < cols && board.getCell(rr, cc) == cell) {
                    if (++streak >= req) return cell;
                    rr += dRow;
                    cc += dCol;
                }
            }
        }
        return Symbols.EMPTY;
    }


    public static int getDropRow(Board board, int col) {
        final int rows = board.getRows();
        for (int row = rows - 1; row >= 0; row--) {
            if (board.getCell(row, col) == Symbols.EMPTY) return row;
        }
        return -1;
    }

    public static boolean isValidCol(Board board, int col) {
        return col >= 0 && col < board.getColumns() && board.getCell(0, col) == Symbols.EMPTY;
    }

    public static boolean isValidCell(Board board, int row, int col) {
        return row >= 0
                && row < board.getRows()
                && col >= 0 && col < board.getColumns()
                && board.getCell(row, col) == Symbols.EMPTY;
    }

    public static void showGameState(char winner, boolean full, Player player) {
        if (winner != Symbols.EMPTY) {
            System.out.printf(GAME_STATE_WIN, winner);
        } else if (full) {
            System.out.print(GAME_STATE_TIE);
        } else {
            System.out.printf(GAME_STATE_NEXT, player.switchPlayer().getIcon());
        }
    }
}
