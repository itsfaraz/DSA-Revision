package patterns;

public class Pattern21 implements Pattern{

    /*
            n = 5

            *               *
            * *           * *
            * * *       * * *
            * * * *   * * * *
            * * * * * * * * *
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
       int colStar = 1;
       int colSpace = (size*2)-3;

       while(row < size){

           for(int col = 0; col < colStar; col++){
               System.out.print("*  ");
           }

           for(int col = 0; col < colSpace; col++){
               System.out.print("   ");
           }
           if (row == size-1)
               colStar = colStar-1;
           for(int col = 0; col < colStar; col++){
               System.out.print("*  ");
           }


           System.out.println();
           row += 1;
           colStar += 1;
           colSpace -= 2;

       }

    }
}
