package dsa.patterns;

public class Pattern22 implements Pattern{

    /*
            n = 5

            * * * * * * * * *
            * * * *   * * * *
            * * *       * * *
            * *           * *
            *               *
     */

    /*
        To solve most of the pattern question we just need to identify 3 steps
        1) No of rows
        2) Changes to be done on every row
        3) Changes to be done before moving from 1 row to another
     */
    @Override
    public void pattern(int size) {
       int row = 0;
       int colStar = size;
       int colSpace = -1;

       while(row < size){

           for(int col = 0; col < colStar; col++){
               System.out.print("*  ");
           }

           for(int col = 0; col < colSpace; col++){
               System.out.print("   ");
           }

           int tempColStar = colStar;
           if (row == 0)
           {
               colStar = tempColStar-1;
           }
           for(int col = 0; col < colStar; col++){
               System.out.print("*  ");
           }
           if (row == 0)
           {
               colStar = tempColStar;
           }
           System.out.println();
           row += 1;
           colStar -= 1;
           colSpace += 2;

       }

    }
}
