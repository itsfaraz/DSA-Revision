package roadmap.dsa.leetcode.strings;

import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "dippitydip";
        int k = 4;
        System.out.println(characterReplacement(s,k));
    }
    public static int characterReplacement(String s, int k) {
        int i =0;
        int j =0;
        int max = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while (i < s.length() && j < s.length()){
            char c = s.charAt(j);
            map.put(c,map.getOrDefault(c,0)+1);
            int window = (j-i+1) - getMostFreqentCharacter(map);
            if (window <= k){
                max = Math.max(max,(j-i)+1);
                j++;
            }else{
                char ch = s.charAt(i);
                if (map.containsKey(ch)){
                    map.put(ch,map.get(ch)-1);
                    if (map.get(ch) == 0) {
                        map.remove(ch);
                    }
                }
                i++;
                j++;
            }

        }
        return max;
    }

    public static int getMostFreqentCharacter(HashMap<Character,Integer> map){
        int maxCount = 0;
        for (char key : map.keySet()){
            maxCount = Math.max(map.get(key),maxCount);
        }
        return maxCount;
    }


}
