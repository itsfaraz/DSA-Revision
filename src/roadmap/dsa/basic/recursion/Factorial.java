package roadmap.dsa.basic.recursion;

public class Factorial {

    public double factorial(int n){
        if (n == 0)
            return 1;

        return n*factorial(n-1);
    }

    public static void main(String[] args) {
        Double result = new Factorial().factorial(500);
        System.out.println(result);
    }
}
