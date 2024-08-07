package roadmap.dsa.patterns;

public class Pattern31 implements Pattern{

    /*
            n = 5
            5 4 3 2 *
            5 4 3 * 1
            5 4 * 2 1
            5 * 3 2 1
            * 4 3 2 1
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

       while(row < size){
           int resultData = size;
           for(int col = 0; col < colStar; col++){
               if (col == (colStar-row)-1)
                   System.out.print("*\t");
               else
                   System.out.print(resultData+"\t");
               resultData-=1;
           }

           System.out.println();
           row += 1;
       }

    }
}
