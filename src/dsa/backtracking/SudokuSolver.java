package dsa.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuSolver {
    
    public static void main(String[] args) {
        int [][]board ={
                {5,3,0, 0,7,0, 0,0,0},
                {6,0,0, 1,9,5, 0,0,0},
                {0,9,8, 0,0,0, 0,6,0},

                {8,0,0, 0,6,0, 0,0,3},
                {4,0,0, 8,0,3, 0,0,1},
                {7,0,0, 0,2,0, 0,0,6},

                {0,6,0, 0,0,0, 2,8,0},
                {0,0,0, 4,1,9, 0,0,5},
                {0,0,0, 0,8,0, 0,7,9},
        };


        new SudokuSolver().solveSudoku(board,0,0);

        display(board);



    }

    public static void display(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean solveSudoku(int [][]board, int row, int col){
        if (col == board[0].length){
            col = 0;
            row++;
        }

        if(row == board.length) {
            return true;
        }

        if (board[row][col] != 0) {
            return solveSudoku(board, row, col + 1);
        }

        for (int ele = 1; ele <= 9; ele++){
            if (isItSafeToPlace(board,row,col,ele)) {
                board[row][col] = ele;
                boolean result = solveSudoku(board, row, col+1);
                if (result)
                    return true;
                board[row][col] = 0;
            }

        }
        return false;
    }


    private boolean isItSafeToPlace(int[][] board, int row, int col,int ele) {
        return isItSafeToPlaceOnGrid(board,row,col,ele) && isItSafeToPlaceOnRow(board,col,ele) && isItSafeToPlaceOnColumn(board,row,ele);
    }

    private boolean isItSafeToPlaceOnColumn(int[][] board, int row, int ele) {
        for (int colIdx = 0; colIdx < board[0].length; colIdx++){
            if (board[row][colIdx] == ele)
                return false;
        }
        return true;
    }

    private boolean isItSafeToPlaceOnRow(int[][] board, int col, int ele) {
        for (int rowIdx = 0; rowIdx < board.length; rowIdx++){
            if (board[rowIdx][col] == ele)
                return false;
        }
        return true;
    }

    private boolean isItSafeToPlaceOnGrid(int[][] board, int row, int col,int ele) {

        int startRow =row - row % 3;
        int startCol = col - col % 3;

        for (int rowIdx = startRow; rowIdx < startRow+3; rowIdx++){
            for (int colIdx = startCol; colIdx < startCol+3; colIdx++){
                if (board[rowIdx][colIdx] == ele)
                    return false;
            }
        }
        return true;
    }
}
