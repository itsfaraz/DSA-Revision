package dsa.leetcode.sheet.array;

public class TrailingZero {

    public static void main(String[] args) {
        int result = trailingZero(150);
        System.out.println(result);
    }

    /*
        Given a no calculate trailing zero in factorial of that no
     */

    public static int trailingZero(int no){
        int sum = 0;
        while (no != 0){
            sum += no/5;
            no = no/5;
        }
        return sum;
    }

}
