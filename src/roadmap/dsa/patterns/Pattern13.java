package roadmap.dsa.patterns;

public class Pattern13 implements Pattern{

    /*
            n = 5
            *
            * *
            * * *
            * * * *
            * * * * *
            * * * *
            * * *
            * *
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
        int scol = 1;
        while (row < (size*2)-1){
            for (int col = 0; col < scol; col++){
                System.out.print("*  ");
            }
            System.out.println();
            row += 1;
            if (row < size-1){
                scol += 1;
            }else{
                scol -= 1;
            }
        }
    }
}
