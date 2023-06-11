package dsa.arrays.slidingwindow.dynamic;

import java.util.HashMap;

public class LongestSubstringNonRepeatingCharacter {

    public int longestSubstringAllUniqueCharacter(String str){
        int max = 0;
        int i =0;
        int j = 0;
        HashMap<Character,Integer> map = new HashMap();
        while(j < str.length() && i < str.length()){
            char c = str.charAt(j);
            map.put(c,map.getOrDefault(c,0)+1);
            int mapSize = map.size();
            int windowSize = (j-i)+1;
            if (mapSize > windowSize){
                j++;
            }else if (mapSize == windowSize){
                max = Math.max(max,windowSize);
                j++;
            }else if (mapSize < windowSize){
                while (mapSize < windowSize && i < j){
                    char ch = str.charAt(i);
                    if (map.containsKey(ch)){
                        map.put(ch,map.get(ch)-1);
                    }
                    if (map.containsKey(ch) && map.get(ch) == 0)
                        map.remove(ch);
                    i++;
                }
                j++;
            }

        }

        return max;
    }

}
