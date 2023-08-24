package dsa.dp.reboot;

public class Fibonacci {

    public static void main(String[] args) {

        int no = (int) Math.pow(10,5);
        int total = fib(no,new int[no+1]);
        System.out.println(total);

    }
    public static int fib(int no,int[] memory){
        if (no == 1 || no == 0)
            return no;
        if (memory[no] != 0)
            return memory[no];

        int fnm1 = fib(no-1,memory);
        int fnm2 = fib(no-2,memory);
        memory[no] = fnm1 + fnm2;
        return memory[no];
    }
}
