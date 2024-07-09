package roadmap.revise.standard.narray;

public class SpiralMatrix {
    public static void spiralPrint(int[][] matrix){
        int counter = 0;
        int counterEnd = matrix.length * matrix[0].length;
        int rowStart = 0;
        int rowEnd = matrix.length-1;
        int colStart = 0;
        int colEnd = matrix[0].length-1;
        while (counter < counterEnd){
            for (int row = rowStart; row <= rowEnd; row++){
                System.out.print(matrix[row][colStart]+" ");
                counter++;
            }
            colStart++;

            for (int col = colStart; col <= colEnd; col++){
                System.out.print(matrix[rowEnd][col]+" ");
                counter++;
            }
            rowEnd--;

            for (int row = rowEnd; row >= rowStart; row--){
                System.out.print(matrix[row][colEnd]+" ");
                counter++;
            }
            colEnd--;

            for (int col = colEnd; col >= colStart; col--){
                System.out.print(matrix[rowStart][col]+" ");
                counter++;
            }
            rowStart++;
        }
    }

    public static void main(String[] args) {
        int [][]matrix = {
                { 1 , 2 , 3 , 4 , 5 },
                { 6 , 7 , 8 , 9 , 10 },
                { 11 , 12 , 13 , 14 , 15 },
                { 16 , 17 , 18 , 19 , 20 },
                { 21 , 22 , 23 , 24 , 25 },
                { 26 , 27 , 28 , 29 , 30 },
        };
        spiralPrint(matrix);
    }
}
