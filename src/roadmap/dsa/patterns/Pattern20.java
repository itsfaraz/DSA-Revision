package roadmap.dsa.patterns;

public class Pattern20 implements Pattern{

    /*
            n = 5

                   *
                *  *  *
             *  *  *  *  *
          *  *  *  *  *  *  *
             *  *  *  *  *
                *  *  *
                   *
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
       int colSpace = (size/2)+1;

       while(row < size){

           for(int col = 0; col < colSpace; col++){
               System.out.print("   ");
           }

           for(int col = 0; col < colStar; col++){
               if (col == 0 || col == colStar-1){
                   System.out.print("*  ");
               }else{
                   System.out.print("   ");
               }
           }
           System.out.println();
           row += 1;
           if (row < (size/2)+1){
               colSpace -= 1;
               colStar += 2;
           }else{
               colSpace += 1;
               colStar -= 2;
           }
       }

    }
}
