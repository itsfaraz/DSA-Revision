package roadmap.dsa.leetcode.arrays;

public class ValidSudoku {

    public static void main(String[] args) {

        char [][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        System.out.println(new ValidSudoku().isValidSudoku(board));

    }


    public boolean isValidSudoku(char[][] board) {

        for (int rowVal = 1; rowVal <= 3; rowVal++){
            int endRow = (rowVal*3)-1;
            int startRow = (rowVal*3)-3;
            for (int colVal = 1; colVal <= 3; colVal++){
                int endCol = (colVal*3)-1;
                int startCol = (colVal*3)-3;

                for (int row = startRow; row <= endRow; row++){
                    for (int col = startCol; col <= endCol; col++){
                        if (board[row][col] == '.')
                            continue;
                        if (isDuplicateInMatrix(board,startRow,endRow,startCol,endCol,board[row][col]) || isDuplicateInCol(board,col,board[row][col]) || isDuplicateInRow(board,row,board[row][col]))
                            return false;
                    }
                }

            }
        }

        return true;
    }


    private boolean isDuplicateInCol(char [][]board,int col,char no){
        int count = 0;
        for (int row = 0; row < board.length; row++){
            if (board[row][col] == no)
                count++;
        }
        if (count > 1)
            return true;
        return false;
    }

    private boolean isDuplicateInRow(char [][]board,int row,char no){
        int count = 0;
        for (int col = 0; col < board[0].length; col++){
            if (board[row][col] == no)
                count++;
        }
        if (count > 1)
            return true;
        return false;
    }
    private boolean isDuplicateInMatrix(char[][] board,int startRow,int endRow,int startCol,int endCol,char no){
        int count = 0;
        for(int row = startRow; row <= endRow; row++){
            for (int col = startCol; col <= endCol; col++){
                if (board[row][col] == no)
                    count++;
            }
        }
        if (count > 1)
            return true;
        return false;
    }

}
