package roadmap.revise.intervals;

import java.util.ArrayList;

public class InsertIntervals {

    public static void main(String[] args) {
       int [][]input= {{1,2},{3,5},{6,7},{8,10},{12,16}};
       int []k =  {4,8};
       insertIntervals(input,k);
    }

    public static void insertIntervals(int [][]intervals,int []newInterval){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int row = 0; row < intervals.length; row++){
            int startIndex = 0;
            int endIndex = intervals[row].length;
            while (startIndex < intervals[row].length){
                int s1 = intervals[startIndex][0];
                int e1 = intervals[startIndex][1];

                int si = newInterval[0];
                int ei = newInterval[1];


                while (e1 < si){
                    newInterval[0] = Math.min(s1,si);
                    newInterval[1] = Math.max(e1,ei);
                    startIndex++;
                }


                while (startIndex < endIndex && s1 <= ei){
                    newInterval[0] = Math.min(s1,si);
                    newInterval[1] = Math.max(e1,ei);
                    startIndex++;
                }

                add(si,ei,result);
                while (startIndex < endIndex){
                    add(s1,e1,result);
                    startIndex++;
                }
            }
            System.out.println(result);
        }
    }

    private static void add(int start,int end,ArrayList<ArrayList<Integer>> result){
//        List<Integer> temp = new ArrayList<>();
//        temp.add(start);
//        temp.add(end);
//        result.add(temp);
    }
}
