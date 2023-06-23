package dsa.dp;

public class Fibonacci {

    public static void main(String[] args) {
        int no = 12;

//        System.out.println(fibonacciRecursive(50));

        System.out.println("--------------------------------------");


        long []memory = new long[no+1];
//        System.out.println(fibonacciDp(no,memory));
        System.out.println(fibonacciBUDp(no));
        System.out.println(fibonacci(no));
    }


    public static int fibonacciRecursive(int no){
        if (no == 1 || no == 0)
            return no;
        return fibonacciRecursive(no-1)+fibonacciRecursive(no-2);
    }


    // Top Down (Memoization)
    public static long fibonacciDp(int no,long []memory){

        if (no == 1 || no == 0)
            return no;

        if (memory[no] != 0)
            return memory[no];

        long result = fibonacciDp(no-1,memory) + fibonacciDp(no-2,memory);
        memory[no] = result;
        return result;
    }

    public static long fibonacciBUDp(int no){
        int []storage = new int[no+1];
        storage[0] = 0;
        storage[1] = 1;

        for (int idx = 2; idx < storage.length; idx++){
            storage[idx] = storage[idx-1]+storage[idx-2];
        }
        return storage[no];
    }

    // Space efficient bottom up dp
    public static long fibonacci(int no){
        int prev = 0;
        int prev1 = 1;
        int curr = 0;
        for (int idx = 0; idx < no;idx++){
            curr = prev+prev1;
            prev1 = prev;
            prev = curr;
        }

        return curr;
    }


}
