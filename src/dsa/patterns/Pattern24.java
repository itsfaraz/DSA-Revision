package dsa.patterns;

public class Pattern24 implements Pattern{

    /*
          n = 5

                  1
                2 2 2
              3 3 3 3 3
            4 4 4 4 4 4 4
          5 5 5 5 5 5 5 5 5
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
       int colSpace = size-1;
       int resultData = 1;

       while(row < size){

           for(int col = 0; col < colSpace; col++){
               System.out.print("   ");
           }

           for(int col = 0; col < colStar; col++){
               System.out.print(resultData+"  ");
           }

           System.out.println();
           row += 1;
           colStar += 2;
           colSpace -= 1;
           resultData += 1;
       }

    }
}
