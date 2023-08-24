package dsa.leetcode.sheet.array;

public class Power {

    public static void main(String[] args) {
//        System.out.println(myPow(2,10));
        System.out.println(power(2,-4));
    }
    public static double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        double result = -1;
        if (n >= 0){
            result = 1;
        }

        for (int pow = 0; pow < Math.abs(n); pow++){
            if (n > 0){
                result *= x;
            }else{
                result /= x;
            }
        }
        return Math.abs(result);
    }

    public static double power(double x, int n){
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        double ans = 1;
        long nn = n;
        if (n < 0){
            nn = n*-1;
        }
        while (nn > 0){
            if (nn%2 == 0){
                nn = nn/2;
                x = x*x;
            }else{
                ans = ans * x;
                nn = nn-1;
            }
        }

        if (n < 0)
            return 1/ans;
        return ans;
    }
}
