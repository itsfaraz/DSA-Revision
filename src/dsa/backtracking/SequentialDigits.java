package dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {

    // https://leetcode.com/problems/sequential-digits/

    public static void main(String[] args) {
        sequentialDigit(0,0,123);
        sequentialDigit(0,0,1234);
    }

    public List<Integer> sequentialDigits(int low, int high) {

        return new ArrayList<>();
    }

    public static void sequentialDigit(int low,int high,int current){
        int lastDigit = current%10;
        int newCurrent = (current * 10)+lastDigit+1;
        System.out.println(newCurrent);
    }
}
