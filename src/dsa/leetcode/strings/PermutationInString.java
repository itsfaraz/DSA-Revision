package dsa.leetcode.strings;

import java.util.HashMap;

public class PermutationInString {

    public static void main(String[] args) {
        PermutationInString permutation = new PermutationInString();
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(permutation.checkInclusion(s1,s2));
    }


    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> map = getFilledMap(s1);

        int count = map.size();
        int left = 0;
        int right = 0;
        int n = s2.length();
        while (left < n && right < n){
            
        }
        return false;
    }

    private HashMap<Character, Integer> getFilledMap(String s1) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int idx = 0; idx < s1.length(); idx++){
            char key = s1.charAt(idx);
            map.put(key,map.getOrDefault(key,0)+1);
        }
        return map;
    }
}
