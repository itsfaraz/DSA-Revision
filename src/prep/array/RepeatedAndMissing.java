package prep.array;

import java.util.Scanner;

public class RepeatedAndMissing {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int arraySize = sc.nextInt();
        printRepeatedAndMissingNumber(arraySize,sc);
    }

    private static void printRepeatedAndMissingNumber(int size,Scanner sc){
        int []arr = takeInput(size,sc);
        int repeatingNo = -1;
        for(int idx = 0; idx < size; idx++){
            int no = Math.abs(arr[idx]);
            if(arr[no-1] > 0){
                arr[no-1] = -arr[no-1];
            }else{
                repeatingNo = no;
            }
        }
        int missingNo = -1;
        for(int idx = 0; idx < size; idx++){
            if(arr[idx] > 0){
                missingNo = idx;
            }
        }
        missingNo +=1;
        System.out.print(missingNo+","+repeatingNo);
    }

    private static int[] takeInput(int size,Scanner sc){
        int []arr = new int[size];
        for(int idx = 0; idx < size; idx++){
            arr[idx] = sc.nextInt();
        }
        return arr;
    }

}
