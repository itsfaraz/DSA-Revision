package revise.standard.narray;

import java.util.Arrays;

public class MatrixMultiplication {

    public static int[][] calculate(int [][]a,int [][]b){
        if (a[0].length != b.length)
            return null;
        int [][]c = new int[a.length][b[0].length];
        for (int row = 0; row < c.length; row++){
            for (int col = 0; col < c[0].length; col++){
                int sum = 0;
                for (int k = 0; k < c.length; k++){
                    sum += a[row][k] * b[k][col];
                }
                c[row][col] = sum;
            }
        }
        return c;
    }

    public static void displayMatrix(int[][] matrix) {
        if (matrix == null)
            System.out.println("Given matrix is NULL");
        for (int []arr : matrix){
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int [][]a = {
            {2,4,1},
            {0,2,2},
            {3,1,3},
        };

        int [][]b = {
                {2,1},
                {0,0},
                {1,2}
        };

        int [][]resultantMatrix = calculate(a,b);
        displayMatrix(resultantMatrix);
    }
}
