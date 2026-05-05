package com.metzprojects.mnk.ui.console;

import com.metzprojects.mnk.domain.Board;

import com.metzprojects.mnk.ui.i18n.TextEncoding;

import static com.metzprojects.mnk.ui.i18n.I18n.getCurrentLanguage;

public final class MNKBoardPrinter {

    private MNKBoardPrinter() {
    }

    private static final String SPACE_6 = "      ";

    private static String num(int num) {
        return String.format(" %3d  ", num + 1);
    }

    private static String cell(Board board, int row, int col) {
        return String.format("  %c  ", board.getCell(row, col));
    }


    public static void printBoard(Board board, boolean gravity, TextEncoding textEncoding) {

        if (textEncoding == TextEncoding.ASCII) {
            printAsciiBoard(board, gravity);
        } else {
            printUtf8Board(board, gravity);
        }
    }

    //UTF-8 Board
    private static void printUtf8Board(Board board, boolean gravity) {
        final int rows = board.getRows();
        final int cols = board.getCols();
        System.out.print("\n" + getCurrentLanguage().column() + " > ");
        for (int i = 0; i <= cols; i++) System.out.print(i < cols ? num(i) : "\n");

        System.out.println((gravity ? SPACE_6 : getCurrentLanguage().row() + " v ") + "╔" + "═════╦".repeat(cols - 1) + "═════╗");

        for (int i = 0; i < rows; i++) {
            System.out.print((gravity ? SPACE_6 : num(i)) + "║");
            for (int j = 0; j <= cols; j++) System.out.print(j < cols ? cell(board, i, j) + "║" : "\n");

            if (i < rows - 1) System.out.println(SPACE_6 + "╠" + "═════╬".repeat(cols - 1) + "═════╣");
        }

        System.out.println(SPACE_6 + "╚" + "═════╩".repeat(cols - 1) + "═════╝");
    }

    //ASCII Board
    private static void printAsciiBoard(Board board, boolean gravity) {
        final int rows = board.getRows();
        final int cols = board.getCols();

        System.out.print("\n" + getCurrentLanguage().column() + " > ");
        for (int i = 0; i < cols; i++) {
            System.out.print(num(i));
        }
        System.out.println();

        System.out.print((gravity ? SPACE_6 : getCurrentLanguage().row() + " v ") + "+");
        for (int c = 0; c < cols; c++) {
            System.out.print("-----");
            System.out.print(c < cols - 1 ? "+" : "+\n");
        }

        for (int i = 0; i < rows; i++) {
            System.out.print((gravity ? SPACE_6 : num(i)) + "|");
            for (int j = 0; j < cols; j++) {
                System.out.print(cell(board, i, j) + "|");
            }
            System.out.println();

            if (i < rows - 1) {
                System.out.print(SPACE_6 + "+");
                for (int c = 0; c < cols; c++) {
                    System.out.print("-----");
                    System.out.print(c < cols - 1 ? "+" : "+\n");
                }
            }
        }
        System.out.print(SPACE_6 + "+");
        for (int c = 0; c < cols; c++) {
            System.out.print("-----");
            System.out.print(c < cols - 1 ? "+" : "+\n");
        }
    }


}
