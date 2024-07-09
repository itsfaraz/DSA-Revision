package roadmap.dsa.leetcode.sheet.array;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class MergeOverlappingIntervals {

    public static void sortIntervals(int[][] intervals){
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
    }

    public static void main(String[] args) {
        int [][]intervals = {
//                {1,3},
//                {2,6},
//                {8,10},
//                {15,18}

//                {6,8},{1,9},{2,4},{4,7},

                {1,4},{4,5}
        };
        for (int[] array: mergeIntervalsV2(intervals)) {
            System.out.println(Arrays.toString(array));
        }

    }

    // Brute Force Approach
    public static int[][] mergeIntervalsV1(int[][] intervals){
        List<Integer[]> list = new ArrayList<>();
        sortIntervals(intervals);

        for (int itemIdx = 0; itemIdx < intervals.length; itemIdx++){
            int start1 = intervals[itemIdx][0];
            int end1 = intervals[itemIdx][1];
            int innerIdx = itemIdx;
            for (int otherItemIdx = itemIdx+1; otherItemIdx < intervals.length; otherItemIdx++){
                int start2 = intervals[otherItemIdx][0];
                int end2 = intervals[otherItemIdx][1];
                if (end1 > start2){
                    start1 = Math.min(start1,start2);
                    end1 = Math.max(end1,end2);
                }else{
                    break;
                }
                innerIdx =  otherItemIdx;
            }
            itemIdx = innerIdx;
            list.add(new Integer[]{start1,end1});
        }


        int size = list.size();
        if (size%2==0)
            size -= 1;
        int [][]result = new int[size][2];
        int resultIdx = 0;

        for (int idx = 0; idx < size; idx++){
            Integer[] listItem = list.get(idx);
            result[resultIdx] = new int[]{listItem[0],listItem[1]};
            resultIdx++;
        }
        return result;
    }

    static class Pair implements Comparable<Pair>{
        int first;
        int second;

        Pair(int first,int second){
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(@NotNull Pair o) {
            if (this.first > o.first)
                return 1;
            else if (this.first < o.first)
                return -1;
            else return 0;
        }
    }

    // Optimize Approach
    public static int[][] mergeIntervalsV2(int[][] intervals){
        Arrays.sort(intervals,Comparator.comparingInt(interval -> interval[0]));
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(intervals[0][0],intervals[0][1]));
        for (int idx = 1; idx < intervals.length; idx++){
            Pair pair = stack.peek();
            Pair other = new Pair(intervals[idx][0],intervals[idx][1]);
            if (pair.second >= other.first){
                stack.pop();
                stack.push(new Pair(Math.min(pair.first, other.first),Math.max(pair.second, other.second)));
            }else{
                stack.push(other);
            }
        }
        int[][] result = new int[stack.size()][2];
        int resultIdx = 0;
        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            result[resultIdx] = new int[]{pair.first,pair.second};
        }
        Arrays.sort(result,Comparator.comparingInt(interval -> interval[0]));
        return result;
    }

    // Optimize Approach
    public static void mergeIntervalsV3(int[][] intervals){

    }

}
