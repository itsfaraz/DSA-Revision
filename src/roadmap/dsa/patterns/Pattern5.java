package roadmap.dsa.patterns;

public class Pattern5 implements Pattern{

    /*
            n = 5
            * * * * *
              * * * *
                * * *
                  * *
                    *
    */

    /*
        For every pattern question we just need to analyse 3 steps
        1) No of rows
        2) Changes to be done in every row
        3) Changes to be done when we move from 1 row to another
    */

    @Override
    public void pattern(int size) {
        int row = 0;
        int col = size;
        int srow = 0;

        while (row < size){

            for(int rspace = 0; rspace < srow; rspace++){
                System.out.print("  ");
            }

            for(int scol = 0; scol < col; scol++){
                System.out.print("* ");
            }

            System.out.println();
            row += 1;
            col -= 1;
            srow += 1;
        }


    }
}
