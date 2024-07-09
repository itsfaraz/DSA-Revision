package roadmap.dsa.dp;

import java.util.Arrays;

public class MazePathDiagonal {

    public static void main(String[] args) {

        int n = 100000;

//        System.out.println(mazePathDiagonalA1(0,0,n,n));
//        System.out.println(mazePathDiagonalA2(0,0,n,n,new int[n][n]));
//        System.out.println(mazePathDiagonalA3(n,n));
//        System.out.println(mazePathDiagonalA4(n,n));
    }


    // Brute Force Recursion
    public static int mazePathDiagonalA1(int row,int col,int endRow,int endCol){

        if (row == endRow-1 && col == endCol-1){
            return 1;
        }

        if (row >= endRow || col >= endCol){
            return 0;
        }

        int count = 0;
        // Horizontal
        count += mazePathDiagonalA1(row,col+1,endRow,endCol);
        // Vertical
        count += mazePathDiagonalA1(row+1,col,endRow,endCol);
        // Diagonal
        count += mazePathDiagonalA1(row+1,col+1,endRow,endCol);

        return count;
    }

    public static int mazePathDiagonalA2(int row,int col,int endRow,int endCol,int [][]storage){

        if (row == endRow-1 && col == endCol-1){
            return 1;
        }

        if (row >= endRow || col >= endCol){
            return 0;
        }

        if (storage[row][col] != 0)
            return storage[row][col];

        int count = 0;
        // Horizontal
        count += mazePathDiagonalA2(row,col+1,endRow,endCol,storage);
        // Vertical
        count += mazePathDiagonalA2(row+1,col,endRow,endCol,storage);
        // Diagonal
        count += mazePathDiagonalA2(row+1,col+1,endRow,endCol,storage);

        storage[row][col] = count;

        return count;
    }

    public static int mazePathDiagonalA3(int endRow,int endCol){
        int [][]storage = getPrefilledStorage(endRow, endCol);

        for (int rowIdx = endRow-2; rowIdx >= 0; rowIdx--){
            for (int colIdx = endCol-2; colIdx >= 0; colIdx--){
                int currValue = storage[rowIdx+1][colIdx] + storage[rowIdx][colIdx+1] + storage[rowIdx+1][colIdx+1];
                storage[rowIdx][colIdx] = currValue;
            }
        }

        return storage[0][0];
    }


    private static int[][] getPrefilledStorage(int m, int n) {
        int [][]memory = new int[m][n];

        for (int row = 0; row < memory.length-1; row++){
            memory[row][memory[0].length-1] = 1;
        }
        for (int col = 0; col < memory.length-1; col++){
            memory[memory.length-1][col] = 1;
        }
        memory[memory.length-1][memory[0].length-1] = 1;
        return memory;
    }

    public static int mazePathDiagonalA4(int endRow,int endCol){
        int []quickStorage = new int[endRow];
        Arrays.fill(quickStorage,1);

        for (int rowIdx = endRow-2; rowIdx >= 0; rowIdx--){
            int diagonal =  quickStorage[endRow-1];
            for (int colIdx = endCol-2; colIdx >= 0; colIdx--){
                int value =  quickStorage[colIdx] + quickStorage[colIdx+1] + diagonal;
                diagonal = quickStorage[colIdx];
                quickStorage[colIdx] = value;
            }
        }

        return quickStorage[0];
    }

}
