package com.metzprojects.mnk.domain;

public final class Board {

    private final char[][] field;
    private final int rows;
    private final int cols;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.field = new char[rows][cols];
        emptyField();
    }

    public void emptyField() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.field[i][j] = Symbols.EMPTY_CELL;
            }
        }
    }

    public void setCell(int row, int col, Player player) {
        this.field[row][col] = player.getPlayerIcon();
    }

    public char getCell(int row, int col) {
        return this.field[row][col];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

}