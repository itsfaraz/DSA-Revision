package dsa.backtracking;

public class MatrixTraversal {


    public static void main(String[] args) {
        int [][] arr = {
                {1,2,3},
                {5,6,7},
                {9,10,11}
        };
       MatrixTraversal traversal = new MatrixTraversal();
       traversal.traverseZigZag(arr,0,0);
       System.out.println();
       traversal.traverseUpDown(arr,0,0);
    }


    // Print matrix using recursion traversal
    public void traverseZigZag(int [][]matrix,int row,int col){
        if (row == matrix.length)
            return;

        if (col >= matrix[0].length){
            traverseZigZag(matrix,row+1,col-1);
            return;
        }

        if (col < 0){
            traverseZigZag(matrix,row+1,col+1);
            return;
        }

        System.out.print(matrix[row][col]+" ");
        if (row%2 == 0)
            traverseZigZag(matrix,row,col+1);
        else traverseZigZag(matrix,row,col-1);

    }

    public void traverseUpDown(int [][]matrix,int row,int col){
        if (row >= matrix.length && col >= matrix[0].length)
            return;

        if (row >= matrix.length){
            traverseUpDown(matrix,row-1,col+1);
            return;
        }

        if (row < 0){
            traverseUpDown(matrix,row+1,col+1);
            return;
        }

        if (row < matrix.length && col < matrix[0].length)
            System.out.print(matrix[row][col]+" ");
        if (col%2 == 0)
            traverseUpDown(matrix,row+1,col);
        else traverseUpDown(matrix,row-1,col);

    }
}
