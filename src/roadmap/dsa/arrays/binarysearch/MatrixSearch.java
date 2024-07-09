package roadmap.dsa.arrays.binarysearch;

public class MatrixSearch {

    /*
        Given a matrix which is sorted row wise and column
        we have to search an element and return the index
        TC : O(n+m)

        input :
        arr = [ [10, 20, 30, 40]
                [15, 25, 35, 45]
                [27, 29, 37, 48]
                [32, 33, 39, 50] ]
        ele = 29

        output :
        result = (2,1)
     */

    public static class Pair{
        int first = -1;
        int second = -1;
        Pair(int first,int second){
            this.first = first;
            this.second = second;
        }

    }

    public Pair search(int [][]matrix,int ele){

        int row = 0;
        int col = matrix[0].length-1;

        while (row >= 0 && row <= matrix.length-1 && col >= 0 && col <= matrix[0].length-1){

            if (matrix[row][col] == ele)
                return new Pair(row,col);
            else if (matrix[row][col] > ele){
                col--;
            }else if (matrix[row][col] < ele)
                row++;
        }

        return new Pair(-1,-1);
    }

}
