package patterns;

/*
        n = 5
        * * * * *
        * * * * *
        * * * * *
        * * * * *
        * * * * *
*/


/*
    For every pattern question we need to identify just 3 things
    1) No of rows
    2) Changes to be done in every row
    3) Changes to be done when we move from 1 row to another
 */



public class Pattern1 implements Pattern{

    @Override
    public void pattern(int size) {
        int row = 0;
        while(row < size){
            for (int col =0; col <= size; col++){
                System.out.print("* ");
            }
            System.out.println();
            row += 1;
        }
    }
}
