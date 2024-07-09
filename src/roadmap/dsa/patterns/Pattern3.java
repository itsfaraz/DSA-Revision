package roadmap.dsa.patterns;

/*
        n = 5
        * * * * *
        * * * *
        * * *
        * *
        *
*/

/*
    For every pattern question we just need to analyse 3 things
    1) No of rows
    2) Changes to be done in every row
    3) Changes to be done before moving from 1 row to another
 */

public class Pattern3 implements Pattern{

    @Override
    public void pattern(int size) {
        int row = 0;
        int col = size;
        while(row < size){
            for(int scol = 0; scol < col; scol++){
                System.out.print("* ");
            }
            System.out.println();
            row += 1;
            col -= 1;
        }
    }
}
