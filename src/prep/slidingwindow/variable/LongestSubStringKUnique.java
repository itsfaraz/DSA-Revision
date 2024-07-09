package prep.slidingwindow.variable;

import java.util.HashMap;

public class LongestSubStringKUnique {

    public int longestSubstringKUniqueCharBrute(String word,int k){
        HashMap<Character,Integer> map = new HashMap<>();
        int maxSum = Integer.MIN_VALUE;
        for (int idx = 0; idx < word.length(); idx++){
            int sum = 0;
            for (int iidx = idx; map.size() <= k; iidx++){
                char value = word.charAt(iidx);
                map.put(value,map.getOrDefault(value,0)+1);
                sum+=1;
            }
            // clean map
            // window size hit
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }
    public int longestSubstringKUniqueChar(String word,int k){
        HashMap<Character,Integer> map = new HashMap<>();
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        int i =0;
        int j =0;
        while (j < word.length()){
            char value = word.charAt(j);
            map.put(value,map.getOrDefault(value,0)+1);
            sum+=1;

            if (map.size() < k){
                j++;
            }else if(map.size() == k){
                maxSum = Math.max(sum,maxSum);
                j++;
            }else {
                while (map.size() > k){
                    char iValue = word.charAt(i);
                    map.put(iValue,map.get(iValue)-1);
                    if (map.containsKey(iValue) && map.get(iValue) == 0)
                        map.remove(iValue);
                    i++;
                    sum -= 1;
                }
                j++;
            }
        }
        return maxSum;
    }
}
