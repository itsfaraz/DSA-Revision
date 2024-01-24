package revise.standard.array;

public class Subarray {
    public static int kadane(int []arr){
        int total = 0;
        int max = 0;
        for (int idx = 0; idx < arr.length;idx++){
            total = Math.max(total + arr[idx],arr[idx]);
            if (total > max) {
//                System.out.print(idx+" ");
                max = total;
            }
        }
//        System.out.println();
        return max;
    }

    public static int maximumCircular(int []arr){
        int kadane = kadane(arr);
        int total = total(arr);
        for (int idx =0;idx < arr.length;idx++){
            arr[idx] = -arr[idx];
        }
        return Math.max(total+kadane(arr),kadane);
    }

    public static int total(int []arr){
        int sum = 0;
        for (int idx = 0; idx < arr.length;idx++){
            sum += arr[idx];
        }
        return sum;
    }
    public static void main(String[] args) {
        int []arr = { 11, 10, -20, 5, -3, -5, 8, -13, 10};
        System.out.println(kadane(arr));
        System.out.println(maximumCircular(arr));
    }
}
