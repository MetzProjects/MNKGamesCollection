package com.metzprojects.mnk.domain;

public final class Board {

    private final char[][] field;
    private final int rows;
    private final int columns;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.field = new char[rows][columns];
        emptyField();
    }

    public void emptyField() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                this.field[i][j] = Symbols.EMPTY;
            }
        }
    }

    public void setCell(int row, int col, Player player) {
        this.field[row][col] = player.getIcon();
    }

    public char getCell(int row, int col) {
        return this.field[row][col];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

}