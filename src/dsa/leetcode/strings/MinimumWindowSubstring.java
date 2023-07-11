package dsa.leetcode.strings;

import java.util.HashMap;

public class MinimumWindowSubstring {

    public static void main(String[] args) {

        String s = "a";
        String t = "b";
        String result = minWindow(s,t);
        System.out.println(result);
    }

    public static String minWindow(String s, String t) {

        HashMap<Character,Integer> map = getFilledMap(t);
        int left = 0;
        int right = 0;
        int n = s.length();
        int counter = map.size(); // stores distinct value of map
        int min = Integer.MAX_VALUE;


        int minStartIdx = -1;
        int minEndIdx = -1;

        while (left < n && right < n){
            char ch = s.charAt(right);
            if (map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if (map.get(ch) == 0)
                    counter--;
            }

            if (counter > 0){
                right++;
            }else if (counter == 0){
                while (counter == 0){
                    int window = (right-left)+1;
                    if (window < min){
                        min = window;
                        minStartIdx = left;
                        minEndIdx = right;
                    }
                    char c = s.charAt(left);
                    if (map.containsKey(c)){
                        if (map.get(c) <= 0){
                            map.put(c,map.get(c)+1);
                        }
                        if (map.get(c) > 0){
                            counter++;
                        }
                        left++;
                    }else{
                        left++;
                    }
                }
                right++;
            }
        }
        if (minStartIdx == -1 && minEndIdx == -1){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int idx = minStartIdx; idx <= minEndIdx; idx++){
            sb.append(s.charAt(idx));
        }
        return sb.toString();
    }

    private static HashMap<Character, Integer> getFilledMap(String s1) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int idx = 0; idx < s1.length(); idx++){
            char key = s1.charAt(idx);
            map.put(key,map.getOrDefault(key,0)+1);
        }
        return map;
    }
}
