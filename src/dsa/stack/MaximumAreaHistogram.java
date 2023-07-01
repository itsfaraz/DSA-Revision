package dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class MaximumAreaHistogram {

    // 0 1 2 3 4 5 6
    // 6 2 5 4 5 1 6


    public static void main(String[] args) {

        int []buildings = {2,4};
        System.out.println(maxArea(buildings));
        System.out.println(new MaximumAreaHistogram().maxAreaV2(buildings));
    }

    // brute force approach O(n^2)
    public static int maxArea(int []buildings){
        if (buildings.length == 1)
            return buildings[0];
        if (buildings.length == 2){
            if (buildings[0] > buildings[1])
                return buildings[0];
            else return buildings[1];
        }

        int max = Integer.MIN_VALUE;
        for (int hIdx = 0; hIdx < buildings.length; hIdx++){
            int count = 0;
            for (int widthIdx = 0; widthIdx < buildings.length; widthIdx++){
                count++;
                if (buildings[widthIdx] < buildings[hIdx]){
                    max = Math.max(max,(count-1)*buildings[hIdx]);
                    count = 0;
                }
            }
        }
        return max;
    }

    public int maxAreaV2(int []buildings){
        int n = buildings.length;
        int []nsl = getNearestSmaller(true, buildings,-1);
        int []nsr = getNearestSmaller(false,buildings,n);
        int maxArea = Integer.MIN_VALUE;
        for (int idx = 0; idx < n; idx++){
            maxArea = Math.max(maxArea,((nsr[idx]-nsl[idx])-1)*buildings[idx]);
        }

        return maxArea;
    }

    private class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    public int[] getNearestSmaller(boolean isLeft,int []buildings,int psuedoIndex){
        Stack<Pair> stack = new Stack<>();
        int []result = new int[buildings.length];

        if (isLeft){
            int startIndex = 0;
            int endIndex = buildings.length-1;
            while(startIndex <= endIndex){
                if (stack.isEmpty()){

                    result[startIndex] = psuedoIndex;
                    stack.push(new Pair(buildings[startIndex],startIndex));
                    startIndex++;
                }else if (stack.peek().first < buildings[startIndex]){
                    result[startIndex] = stack.peek().second;
                    stack.push(new Pair(buildings[startIndex],startIndex));
                    startIndex++;
                }else if (stack.peek().first >= buildings[startIndex]){
                    stack.pop();
                }
            }
        }else{
            int vidx = buildings.length-1;
            while (vidx >= 0){
                if (stack.isEmpty()){
                    result[vidx] = psuedoIndex;
                    stack.push(new Pair(buildings[vidx],vidx));
                    vidx--;
                } else if (stack.peek().first < buildings[vidx]) {
                    result[vidx] = stack.peek().second;
                    stack.push(new Pair(buildings[vidx],vidx));
                    vidx--;
                }else if (stack.peek().first >= buildings[vidx]){
                    stack.pop();
                }
            }
        }

        return result;
    }
}
