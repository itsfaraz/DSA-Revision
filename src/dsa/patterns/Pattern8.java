package dsa.patterns;

public class Pattern8 implements Pattern{


    /*
        n = 5
        *          *
           *     *
              *
           *     *
        *          *

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
        while(row < size){

            for (int col = 0; col < size; col++){
                if (col == row || col == size-row-1){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
            row++;
        }
    }
}
