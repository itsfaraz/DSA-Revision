package roadmap.dsa.leetcode.strings;

import java.util.HashMap;

public class LongestSubstring {

    public static void main(String[] args) {

        String str = "eeydgwdykpv";
        System.out.println(lengthOfLongestSubstring(str));

    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = 0;

        while (i < s.length() && j < s.length()){
            char c = s.charAt(j);
            map.put(c,map.getOrDefault(c,0)+1);
            if ((j-i)+1 < map.size()){
                j++;
            }else if ((j-i)+1 == map.size()){
                max = Math.max(max,map.size());
                j++;
            } else{
                while ((j-i)+1 > map.size() && i < j){
                    char ch = s.charAt(i);
                    if (map.containsKey(ch)){
                        map.put(ch,map.get(ch)-1);
                        if (map.get(ch) == 0){
                            map.remove(ch);
                        }
                    }
                    i++;
                }
                j++;
            }

        }
        return max;
    }
}
