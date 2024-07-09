package roadmap.dsa.leetcode.arrays;

public class RotateImage {


    public static void main(String[] args) {

        int [][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        matrix = new int[][]{
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };
        matrix = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16},
        };
        matrix = new int[][]{
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16},
        };
        displayMatrix(matrix);
        rotate(matrix);
        System.out.println("----------------------------------------------");
        displayMatrix(matrix);
    }

    private static void displayMatrix(int[][] matrix) {
        for (int row = 0; row < matrix[0].length;row++){
            for (int col = 0; col < matrix.length; col++){
                System.out.print(matrix[row][col]+" \t");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {

        for (int layer = 0; layer < Math.abs(matrix.length/2); layer++){
            System.out.println("rotation "+((matrix.length-1)-(layer+layer)));
            for (int rotation = 0; rotation < (matrix.length-1)-(layer+layer);rotation++){
                rotateMatrix(matrix,layer);
            }
        }

    }

    private static void rotateMatrix(int[][] matrix,int layer) {
        int row = layer;
        int col = layer;
        int prevValue = matrix[row][col];

        for (int horizontalCol = col+1; horizontalCol < matrix[0].length-layer; horizontalCol++){
            int temp = matrix[row][horizontalCol];
            matrix[row][horizontalCol] = prevValue;
            prevValue = temp;
            col++;
        }

        for (int verticalRow = row+1; verticalRow < matrix.length-layer; verticalRow++){
            int temp = matrix[verticalRow][col];
            matrix[verticalRow][col] = prevValue;
            prevValue = temp;
            row++;
        }

        for (int horizontalCol = col-1; horizontalCol >= layer ; horizontalCol--){
            int temp = matrix[row][horizontalCol];
            matrix[row][horizontalCol] = prevValue;
            prevValue = temp;
            col--;
        }

        for (int verticalRow = row-1; verticalRow >= layer ; verticalRow--){
            int temp = matrix[verticalRow][col];
            matrix[verticalRow][col] = prevValue;
            prevValue = temp;
            row++;
        }
    }

}
