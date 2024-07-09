package roadmap.dsa.patterns;

public class Pattern29 implements Pattern{

    /*
          n = 5
                  1
                2 0 2
              3 0 0 0 3
            4 0 0 0 0 0 4
          5 0 0 0 0 0 0 0 5
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
               if (col == 0 || col == colStar-1)
                   System.out.print(resultData+"\t");
               else
                   System.out.print("0\t");

           }

           System.out.println();
           row += 1;
           colStar += 2;
           colSpace -= 1;
           resultData += 1;
       }

    }
}
