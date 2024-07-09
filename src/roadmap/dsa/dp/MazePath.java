package roadmap.dsa.dp;

import java.util.Arrays;

public class MazePath {

    public static void main(String[] args) {
        int result = 0;


        int n = 1000000;
        int endRow = n;
        int endCol = n;
//        result = mazePathWaysA1(0,0,endRow,endCol,"");
//        System.out.println(result);

//        int[][] storage = new int[endRow+1][endCol+1];
//        result = mazePathWaysA2(0,0,endRow,endCol,storage,"");
//        System.out.println(result);
//        System.out.println(storage);
//        System.out.println(mazePathWaysA3(endRow+1,endCol+1));

        System.out.println(mazePathWaysA4(endRow,endCol));
    }

    // Brute Force Recursion
    public static int mazePathWaysA1(int row,int col,int endRow,int endCol,String ans){
        if (row == endRow && col == endCol){
            System.out.println(ans);
            return 1;
        }

        if (row >= endRow || col >= endCol)
            return 0;

        int count = 0;

        // Horizontal
        count += mazePathWaysA1(row,col+1,endRow,endCol,ans+"H");

        // Vertical
        count += mazePathWaysA1(row+1,col,endRow,endCol,ans+"V");

        return count;
    }

    // Top Down (Memoization)
    public static int mazePathWaysA2(int row,int col,int endRow,int endCol,int [][]storage,String ans){
        if (row == endRow && col == endCol){
            return 1;
        }

        if (row > endRow || col > endCol)
            return 0;

        if (storage[row][col] != 0){
            return storage[row][col];
        }


        int count = 0;
        // Horizontal
        count += mazePathWaysA2(row,col+1,endRow,endCol,storage,ans+"H");

        // Vertical
        count += mazePathWaysA2(row+1,col,endRow,endCol,storage,ans+"V");

        storage[row][col] = count;

        return count;
    }

    // Bottom Up (Tabulation)
    public static int mazePathWaysA3(int m,int n){
        int [][]storage = getPrefilledStorage(m,n);

        for (int row = m-2; row >= 0; row--){
            for (int col = n-2; col >= 0; col--){
                int rRow = row+1;
                int rCol = col+1;
                storage[row][col] = storage[rRow][col] + storage[row][rCol];
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
        return memory;
    }

    // Bottom Up Space Efficient
    public static int mazePathWaysA4(int m,int n){
        int []quickStorage = new int [n+1];
        Arrays.fill(quickStorage,1);
        for (int idx = 0; idx < m; idx++){
            for (int colIdx = n-1; colIdx >= 0; colIdx--){
                quickStorage[colIdx] = quickStorage[colIdx] + quickStorage[colIdx+1];
            }
        }


        return quickStorage[0];
    }

}
