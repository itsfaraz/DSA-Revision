package roadmap.dsa.backtracking;

public class MazePath {

    public static void main(String[] args) {
        int[][] maze = {
                {1,1,1,1,1},
                {0,1,0,0,1},
                {0,1,1,1,0},
                {0,1,0,1,1},
        };
        MazePath mazeObj = new MazePath();
//        mazeObj.traverseMaze(maze,0,0,"");
//        System.out.println();
//        mazeObj.traverseBlockMaze(maze,0,0,"");

      maze = new int[][]{
              {1,1,1,1,1},
              {1,0,1,1,0},
              {1,1,0,1,0},
              {0,1,1,1,0},
              {0,1,0,0,1},
              {1,1,1,1,1},
      };
      mazeObj.blockedMazeV2(maze,0,0,"");

    }

    public static int count = 0;
    public void traverseMaze(int [][]matrix,int row,int col,String ans){

        if (row == matrix.length-1 && col == matrix[0].length-1){
            System.out.println(++count+") "+ans);
            return;
        }

        if (col < matrix[0].length)
            traverseMaze(matrix,row,col+1,ans+"H");

        if (row < matrix.length)
            traverseMaze(matrix,row+1,col,ans+"V");

    }


    public void traverseBlockMaze(int [][]matrix,int row,int col,String ans){

        int lastRow = matrix.length-1;
        int lastCol = matrix[0].length-1;
        boolean removeBlock = row == lastRow && col == lastCol || row == 0 && col == 0;

        if (row == lastRow && col == lastCol){
            System.out.println(++count+") "+ans);
            return;
        }
        if (col+1 > lastCol+1)
            return;

        if (row+1 > lastRow+1)
            return;



        if (col+1 < lastCol+1 && matrix[row][col+1] == 1) {
            matrix[row][col+1] = 0;
            traverseBlockMaze(matrix, row, col + 1, ans + "H");
        }

        if (row+1 < lastRow+1 && matrix[row+1][col] == 1) {
            matrix[row+1][col] = 0;
            traverseBlockMaze(matrix, row + 1, col, ans + "V");
        }

        matrix[lastRow][lastCol] = 1;
    }

    public void blockedMazeV2(int [][]matrix,int row,int col,String ans){

        if (row == matrix.length-1 && col == matrix[0].length-1){
            System.out.println(ans);
            return;
        }
        if (row < 0 || col < 0 || row > matrix.length || col > matrix[0].length)
            return;

        if (row == matrix.length-1 && col == matrix[0].length-1 || row == 0 && col == 0)
            matrix[row][col] = 1;

        if (row-1 >= 0 && matrix[row-1][col] != 0){
            matrix[row][col] = 0;
            blockedMazeV2(matrix,row-1,col,ans+"T");
            matrix[row][col] = 1;
        }
        if (row+1 < matrix.length && matrix[row+1][col] != 0){
            matrix[row][col] = 0;
            blockedMazeV2(matrix,row+1,col,ans+"D");
            matrix[row][col] = 1;
        }
        if (col-1 >= 0 && matrix[row][col-1] != 0) {
            matrix[row][col] = 0;
            blockedMazeV2(matrix, row, col - 1, ans+"L");
            matrix[row][col] = 1;
        }
        if (col+1 <= matrix[0].length-1 && matrix[row][col+1] != 0){
            matrix[row][col] = 0;
            blockedMazeV2(matrix,row,col+1,ans+"R");
            matrix[row][col] = 1;
        }
    }

}
