package dsa.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {

    public static void main(String[] args) {

        int arr[] = {1,2,2};



        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        new SubsetII().subsetWithDuplicatesA1(arr,0,false,new ArrayList<>(),result);
        System.out.println(result);
        result.clear();
        
        new SubsetII().subsetWithDuplicatesA2(arr,0,false,new ArrayList<>(),result);
        System.out.println(result);
    }

    public void subsetWithDuplicatesA1(int []arr, int vidx, boolean isDuplicate, List<Integer> ans,List<List<Integer>> result){

        if (vidx == arr.length){
            result.add(new ArrayList<>(ans));
            return;
        }

        if (!isDuplicate){
            ans.add(arr[vidx]);
            subsetWithDuplicatesA1(arr,vidx+1,false,ans,result);
            ans.remove(ans.size()-1);
        }

        if (vidx > 0 && arr[vidx] == arr[vidx-1] || vidx < arr.length-1 && arr[vidx] == arr[vidx+1])
            isDuplicate = true;
        else isDuplicate = false;


        subsetWithDuplicatesA1(arr,vidx+1,isDuplicate,ans,result);

    }

    public void subsetWithDuplicatesA2(int []arr, int vidx, boolean isDuplicate, List<Integer> ans,List<List<Integer>> result){

        result.add(new ArrayList<>(ans));

        for (int idx = vidx;idx < arr.length; idx++){

            if (idx > vidx && arr[idx] == arr[idx-1])
                continue;

            ans.add(arr[idx]);
            subsetWithDuplicatesA2(arr,idx+1,isDuplicate,ans,result);
            ans.remove(ans.size()-1);

        }

    }

}
