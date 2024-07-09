package roadmap.dsa.patterns;

public class Pattern28 implements Pattern{

    /*
          n = 5

                  1
                2 3 2
              3 4 5 4 3
            4 5 6 7 6 5 4
          5 6 7 8 9 8 7 6 5
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
           int printData = resultData;
           for(int col = 0; col < colSpace; col++){
               System.out.print("\t");
           }

           for(int col = 0; col < colStar; col++){
               System.out.print(printData+"\t");
               if (col < colStar/2){
                   printData += 1;
               }else{
                   printData -= 1;
               }
           }

           System.out.println();
           row += 1;
           colStar += 2;
           colSpace -= 1;
           resultData += 1;
       }

    }
}
