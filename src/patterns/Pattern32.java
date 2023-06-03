package patterns;

public class Pattern32 implements Pattern{

    /*
            n = 5
            1
            2 * 2
            3 * 3 * 3
            4 * 4 * 4 * 4
            5 * 5 * 5 * 5 * 5
            4 * 4 * 4 * 4
            3 * 3 * 3
            2 * 2
            1

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
       int resultData = 1;
       while(row < (size*2)-1){

           for(int col = 0; col < colStar; col++){
               if (col%2 != 0)
                   System.out.print("*\t");
               else
                   System.out.print(resultData+"\t");
           }

           System.out.println();
           row += 1;
           if (row <= size-1){
               colStar += 2;
               resultData += 1;
           }else{
               colStar -= 2;
               resultData -= 1;
           }
       }

    }
}
