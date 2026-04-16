package com.metzprojects.mnk.logic;

import com.metzprojects.mnk.domain.Board;
import com.metzprojects.mnk.domain.Player;
import com.metzprojects.mnk.domain.Symbols;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameLogicTest {

    @Test
    void isBoardFull_shouldReturnFalse_whenBoardIsEmpty() {
        Board board = new Board(3, 3);

        boolean result = GameLogic.isBoardFull(board);

        assertFalse(result);
    }

    @Test
    void isBoardFull_shouldReturnFalse_whenBoardIsPartiallyFilled() {
        Board board = new Board(3, 3);
        board.setCell(0, 0, Player.X);
        board.setCell(1, 1, Player.O);

        boolean result = GameLogic.isBoardFull(board);

        assertFalse(result);
    }

    @Test
    void isBoardFull_shouldReturnTrue_whenBoardIsFull() {
        Board board = new Board(3, 3);

        for (int r = 0; r < board.getRows(); r++) {
            for (int c = 0; c < board.getColumns(); c++) {
                board.setCell(r, c, ((r + c) % 2 == 0) ? Player.X : Player.O);
            }
        }

        boolean result = GameLogic.isBoardFull(board);

        assertTrue(result);
    }

    @Test
    void getWinner_shouldReturnEmpty_whenBoardIsEmpty() {
        Board board = new Board(3, 3);

        char winner = GameLogic.getWinner(board, 3);

        assertEquals(Symbols.EMPTY, winner);
    }

    @Test
    void getWinner_shouldDetectHorizontalWin_whenRowContainsRequiredSymbols() {
        Board board = new Board(3, 3);
        board.setCell(1, 0, Player.X);
        board.setCell(1, 1, Player.X);
        board.setCell(1, 2, Player.X);

        char winner = GameLogic.getWinner(board, 3);

        assertEquals('X', winner);
    }

    @Test
    void getWinner_shouldDetectVerticalWin_whenColumnContainsRequiredSymbols() {
        Board board = new Board(3, 3);
        board.setCell(0, 2, Player.O);
        board.setCell(1, 2, Player.O);
        board.setCell(2, 2, Player.O);

        char winner = GameLogic.getWinner(board, 3);

        assertEquals('O', winner);
    }

    @Test
    void getWinner_shouldDetectMainDiagonalWin_whenDiagonalContainsRequiredSymbols() {
        Board board = new Board(3, 3);
        board.setCell(0, 0, Player.X);
        board.setCell(1, 1, Player.X);
        board.setCell(2, 2, Player.X);

        char winner = GameLogic.getWinner(board, 3);

        assertEquals('X', winner);
    }

    @Test
    void getWinner_shouldDetectAntiDiagonalWin_whenAntiDiagonalContainsRequiredSymbols() {
        Board board = new Board(3, 3);
        board.setCell(0, 2, Player.O);
        board.setCell(1, 1, Player.O);
        board.setCell(2, 0, Player.O);

        char winner = GameLogic.getWinner(board, 3);

        assertEquals('O', winner);
    }

    @Test
    void getWinner_shouldDetectWin_whenRequiredStreakIsSmallerThanBoardSize() {
        Board board = new Board(5, 5);
        board.setCell(2, 1, Player.X);
        board.setCell(2, 2, Player.X);
        board.setCell(2, 3, Player.X);

        char winner = GameLogic.getWinner(board, 3);

        assertEquals('X', winner);
    }

    @Test
    void getWinner_shouldReturnEmpty_whenStreakIsInterrupted() {
        Board board = new Board(1, 5);
        board.setCell(0, 0, Player.X);
        board.setCell(0, 1, Player.X);
        board.setCell(0, 2, Player.O);
        board.setCell(0, 3, Player.X);
        board.setCell(0, 4, Player.X);

        char winner = GameLogic.getWinner(board, 3);

        assertEquals(Symbols.EMPTY, winner);
    }

    @Test
    void getWinner_shouldReturnEmpty_whenNobodyHasWon() {
        Board board = new Board(3, 3);
        board.setCell(0, 0, Player.X);
        board.setCell(0, 1, Player.O);
        board.setCell(0, 2, Player.X);
        board.setCell(1, 0, Player.O);
        board.setCell(1, 1, Player.X);
        board.setCell(1, 2, Player.O);

        char winner = GameLogic.getWinner(board, 3);

        assertEquals(Symbols.EMPTY, winner);
    }

    @Test
    void getWinner_shouldDetectLongerStreak_whenStreakExceedsRequiredLength() {
        Board board = new Board(1, 5);
        board.setCell(0, 0, Player.X);
        board.setCell(0, 1, Player.X);
        board.setCell(0, 2, Player.X);
        board.setCell(0, 3, Player.X);

        char winner = GameLogic.getWinner(board, 3);

        assertEquals('X', winner);
    }

    @Test
    void getDropRow_shouldReturnBottomRow_whenColumnIsEmpty() {
        Board board = new Board(6, 7);

        int row = GameLogic.getDropRow(board, 3);

        assertEquals(5, row);
    }

    @Test
    void getDropRow_shouldReturnLowestFreeRow_whenColumnIsPartiallyFilled() {
        Board board = new Board(6, 7);
        board.setCell(5, 2, Player.X);
        board.setCell(4, 2, Player.O);

        int row = GameLogic.getDropRow(board, 2);

        assertEquals(3, row);
    }

    @Test
    void getDropRow_shouldReturnMinusOne_whenColumnIsFull() {
        Board board = new Board(3, 3);
        board.setCell(2, 1, Player.X);
        board.setCell(1, 1, Player.O);
        board.setCell(0, 1, Player.X);

        int row = GameLogic.getDropRow(board, 1);

        assertEquals(-1, row);
    }

    @Test
    void isValidCol_shouldReturnTrue_whenColumnIsEmpty() {
        Board board = new Board(3, 3);

        boolean result = GameLogic.isValidCol(board, 1);

        assertTrue(result);
    }

    @Test
    void isValidCol_shouldReturnTrue_whenColumnIsPartiallyFilled() {
        Board board = new Board(4, 4);
        board.setCell(3, 2, Player.X);
        board.setCell(2, 2, Player.O);

        boolean result = GameLogic.isValidCol(board, 2);

        assertTrue(result);
    }

    @Test
    void isValidCol_shouldReturnFalse_whenColumnIsFull() {
        Board board = new Board(3, 3);
        board.setCell(0, 1, Player.X);

        boolean result = GameLogic.isValidCol(board, 1);

        assertFalse(result);
    }

    @Test
    void isValidCol_shouldReturnFalse_whenColumnIsNegative() {
        Board board = new Board(3, 3);

        boolean result = GameLogic.isValidCol(board, -1);

        assertFalse(result);
    }

    @Test
    void isValidCol_shouldReturnFalse_whenColumnIsOutsideBoard() {
        Board board = new Board(3, 3);

        boolean result = GameLogic.isValidCol(board, 3);

        assertFalse(result);
    }

    @Test
    void isValidCell_shouldReturnTrue_whenCellIsInsideBoardAndEmpty() {
        Board board = new Board(3, 3);

        boolean result = GameLogic.isValidCell(board, 1, 1);

        assertTrue(result);
    }

    @Test
    void isValidCell_shouldReturnFalse_whenCellIsOccupied() {
        Board board = new Board(3, 3);
        board.setCell(1, 1, Player.X);

        boolean result = GameLogic.isValidCell(board, 1, 1);

        assertFalse(result);
    }

    @Test
    void isValidCell_shouldReturnFalse_whenRowIsNegative() {
        Board board = new Board(3, 3);

        boolean result = GameLogic.isValidCell(board, -1, 1);

        assertFalse(result);
    }

    @Test
    void isValidCell_shouldReturnFalse_whenColumnIsNegative() {
        Board board = new Board(3, 3);

        boolean result = GameLogic.isValidCell(board, 1, -1);

        assertFalse(result);
    }

    @Test
    void isValidCell_shouldReturnFalse_whenRowIsOutsideBoard() {
        Board board = new Board(3, 3);

        boolean result = GameLogic.isValidCell(board, 3, 1);

        assertFalse(result);
    }

    @Test
    void isValidCell_shouldReturnFalse_whenColumnIsOutsideBoard() {
        Board board = new Board(3, 3);

        boolean result = GameLogic.isValidCell(board, 1, 3);

        assertFalse(result);
    }
}