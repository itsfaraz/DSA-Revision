package dsa.patterns;

public class Pattern10 implements Pattern{


    /*
        n = 5
               * * * * * * * * *
                 * * * * * * *
                   * * * * *
                     * * *
                       *
    */

    /*
        For every pattern question we need just need to identify 3 steps
        1) No of rows
        2) Changes to be done in every row
        3) Changes to be done when we move from 1 row to another
     */

    @Override
    public void pattern(int size) {
        int row = 0;

        int colSpace = 0;
        int colStar = (size*2)-1;

        while(row < size){
            for (int col = 0; col < colSpace; col++){
                System.out.print("  ");
            }

            for (int col = 0; col < colStar; col++){
                System.out.print("* ");
            }

            System.out.println();
            row++;
            colSpace += 1;
            colStar -= 2;
        }
    }
}
