package roadmap.dsa.leetcode.sheet.array;

import org.jetbrains.annotations.NotNull;

public class SetMatrix {

    public static void main(String[] args) {
        int matrix [][] = {
                // tc 1
//                {0,1}
                // tc 2
//                {0,1,2,0}, {3,4,5,2}, {1,3,1,5},
                // tc 3
                {1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}
        };
        display(matrix);
        new SetMatrix().setZeroesV2(matrix);
        System.out.println("-------------------");
        display(matrix);
    }

    public static void display(int [][]matrix){
        for(int row = 0; row < matrix.length;row++){
            for (int col = 0; col < matrix[0].length;col++){
                System.out.print(matrix[row][col]+"\t");
            }
            System.out.println();
        }
    }
    public void setZeroes(@NotNull int[][] matrix) {
        int [][]helper = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < helper.length; row++){
            for (int col = 0; col < helper[0].length; col++){
                helper[row][col] = -1;
            }
        }
        for (int row = 0; row < matrix.length; row++){
            for (int col = 0; col < matrix[0].length; col++){
                if (matrix[row][col] == 0){
                    setZeroInHelper(row,col,helper);
                }
            }
        }
        for (int row = 0; row < matrix.length; row++){
            for (int col = 0; col < matrix[0].length; col++){
                if (helper[row][col] == 0){
                    matrix[row][col] = 0;
                }
            }
        }
    }
    public void setZeroInHelper(int rowIdx,int colIdx,int[][] helper){
        for (int row = 0; row < helper.length; row++){
            helper[row][colIdx] = 0;
        }
        for (int col = 0; col < helper[0].length; col++){
            helper[rowIdx][col] = 0;
        }
    }

    public void setZeroesV2(int [][]matrix){
        int []horizontalArray = new int [matrix[0].length];
        int []verticalArray = new int[matrix.length];
        for (int row = 0; row < matrix.length; row++){
            for (int col = 0; col < matrix[0].length; col++){
                if (matrix[row][col] == 0){
                    horizontalArray[col] = Integer.MIN_VALUE;
                    verticalArray[row] = Integer.MIN_VALUE;
                }
            }
        }
        for (int row = 0; row < verticalArray.length; row++){
            if (verticalArray[row] == Integer.MIN_VALUE){
                fillZero(row,matrix,true);
            }
        }
        for (int col = 0; col < horizontalArray.length; col++){
            if (horizontalArray[col] == Integer.MIN_VALUE){
                fillZero(col,matrix,false);
            }
        }
    }

    public void fillZero(int idx, int [][]matrix,boolean isRow){
        if (isRow){
            for (int colIdx = 0; colIdx < matrix[0].length;colIdx++){
                matrix[idx][colIdx] = 0;
            }
        }else{
            for (int rowIdx = 0; rowIdx < matrix.length;rowIdx++){
                matrix[rowIdx][idx] = 0;
            }
        }
    }
}
