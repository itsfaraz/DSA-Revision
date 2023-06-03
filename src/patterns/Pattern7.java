package patterns;

public class Pattern7 implements Pattern{

    /*
            n = 5
            * * * * *
            *       *
            *       *
            *       *
            * * * * *
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
        int srow = size-2;

        while (row < size){
            System.out.print("* ");
            for(int rspace = 0; rspace < srow; rspace++){
                if (row == 0 || row == size-1){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.print("* ");

            System.out.println();
            row += 1;
        }


    }
}
