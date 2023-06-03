package patterns;

/*
        n = 5
        *
        * *
        * * *
        * * * *
        * * * * *
*/

/*
    For every pattern question we just need to analyse 3 things
    1) No of rows
    2) Changes to be done in every row
    3) Changes to be done before moving from 1 row to another
 */

public class Pattern2 implements Pattern{

    @Override
    public void pattern(int size) {
        int row = 0;
        int col = 1;
        // no of rows
        while(row < size){
            // changes to be done
            for(int scol = 0; scol < col; scol++){
                System.out.print("* ");
            }
            System.out.println();
            // changes so that we can move forward
            row += 1;
            col += 1;
        }
    }
}
