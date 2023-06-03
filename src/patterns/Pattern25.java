package patterns;

public class Pattern25 implements Pattern{

    /*
           n = 5

                      1
                    2 3 4
                  5 6 7 8 9
              10 11 12 13 14 15 16
           17 18 19 20 21 22 23 24 25
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
               System.out.print("\t");
           }

           for(int col = 0; col < colStar; col++){
               System.out.print(resultData+"\t");
               resultData += 1;
           }

           System.out.println();
           row += 1;
           colStar += 2;
           colSpace -= 1;
       }

    }
}
