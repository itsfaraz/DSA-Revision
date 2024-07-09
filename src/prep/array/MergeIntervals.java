package prep.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeIntervals {

    public static void main(String[] args) {
//        int[][] intervals= {{1,3},{2,6},{8,10},{15,18}};
        int[][] intervals= { {6,8},{1,9}, {2,4}, {4,7} };
//        Stack<Integer[]> result = mergeIntervals(intervals);
//        for (Integer[] data : result){
//            System.out.println(Arrays.toString(data));
//        }
        mergeIntervalsOptimized(intervals);

    }

    public static Stack<Integer[]> mergeIntervals(int[][] intervals){
        Stack<Integer[]> stack = new Stack<>();
        for (int idx = 0; idx < intervals.length; idx++){
            int start = intervals[idx][0];
            int end = intervals[idx][1];
            if (stack.isEmpty()){
                stack.push(new Integer[]{start,end});
            }else{
                Integer[]pair = stack.peek();
                int oldStart = pair[0];
                int oldEnd = pair[1];
                if (start <= oldEnd){
                    oldStart = Math.min(oldStart,start);
                    oldEnd = Math.max(oldEnd,end);
                    stack.pop();
                    stack.push(new Integer[]{oldStart,oldEnd});
                }else {
                    stack.push(new Integer[]{start,end});
                }
            }
        }
        return stack;
    }

    public static void mergeIntervalsOptimized(int[][] intervals){
        int index = 0;
        Arrays.sort(intervals,Comparator.comparing(o -> o[0]));
        for (int idx = 1; idx < intervals.length; idx++){
            if (intervals[index][1] >= intervals[idx][0]){
                intervals[index][1] = Math.max(intervals[index][1],intervals[idx][0]);
            }else{
                index++;
                intervals[index][0] = intervals[idx][0];
                intervals[index][1] = intervals[idx][1];
            }
        }
        for (int idx =0; idx <= index; idx++){
            System.out.println(Arrays.toString(intervals[idx]));
        }
    }


}
