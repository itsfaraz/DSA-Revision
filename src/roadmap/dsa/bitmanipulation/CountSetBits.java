package roadmap.dsa.bitmanipulation;

public class CountSetBits {

    public static void main(String[] args) {
        System.out.println(countSetBits(999999999));
    }
    public static int countSetBits(int n) {
        int count = 0;
        int mask = n & (-n);
        while (n!=0){
            if ((n & mask) == 1){
                count++;
            }
            n >>>= 1;
        }
        return count;
    }
}
