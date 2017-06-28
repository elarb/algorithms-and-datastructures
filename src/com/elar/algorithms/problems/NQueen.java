package com.elar.algorithms.problems;

import java.util.Arrays;

public class NQueen {

    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        System.out.println(Arrays.toString(nQueen.solveNQueen(5)));
        System.out.println(nQueen.placeQueens(nQueen.solveNQueen(4)));
    }

    // Class that represents a position of the Board
    static class Position {
        int row, col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return String.format("(%d,%d)", row, col);
        }
    }

    // Solves the N Queen problem for an n x n board
    public Position[] solveNQueen(int n) {
        Position[] res = new Position[n];
        boolean hasSolution = solveNQueenHelper(n, 0, res);
        if (hasSolution) {
            return res;
        }
        return new Position[0];
    }

    // Helper method to solve the N Queen problem
    private boolean solveNQueenHelper(int n, int row, Position[] positions) {
        if (n == row) {
            return true;
        }
        for (int col = 0; col < n; col++) {
            boolean goodFind = true;
            for (int queen = 0; queen < row; queen++) {
                // We cannot place a queen at one of those positions
                if (positions[queen].col == col || positions[queen].row - positions[queen].col == row - col ||
                        positions[queen].row + positions[queen].col == row + col) {
                    goodFind = false;
                    break;
                }
            }
            if (goodFind) {
                positions[row] = new Position(row, col);
                if (solveNQueenHelper(n, row + 1, positions)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String placeQueens(Position[] positions) {
        int n = positions.length;
        char[][] res = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = '*';
            }
        }

        for (Position position : positions) {
            res[position.row][position.col] = 'Q';
        }
        return Arrays.deepToString(res);
    }
}
