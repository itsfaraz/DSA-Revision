package roadmap.dsa.leetcode.strings;

import java.util.HashMap;

public class PermutationInString {

    public static void main(String[] args) {
        PermutationInString permutation = new PermutationInString();
        String s1 = "adc";
        String s2 = "dcda";
        System.out.println(permutation.checkInclusion(s1,s2));
    }


    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;
        HashMap<Character,Integer> map = getFilledMap(s1);
        int count = map.size();
        int left = 0;
        int right = 0;
        int n = s2.length();
        while (left < n && right < n){
            char ch = s2.charAt(right);
            if ((right - left)+1 < s1.length()){
                if (map.containsKey(ch)){
                    map.put(ch,map.get(ch)-1);
                    if (map.get(ch) == 0)
                        count--;
                    right++;
                }else{
                    char c = s2.charAt(left);
                    if (map.containsKey(c)){
                        map.put(c,map.get(c)+1);
                        if (map.get(c) == 1)
                            count+=1;
                    }
                    left++;
                    right++;
                }
            }else if ((right-left)+1 == s1.length()){
                if (map.containsKey(ch)){
                    map.put(ch,map.get(ch)-1);
                    if (map.get(ch) == 0)
                        count--;
                }else{
                    char c = s2.charAt(left);
                    if (map.containsKey(c)){
                        map.put(c,map.get(c)+1);
                        if (map.get(c) == 1)
                            count+=1;
                    }
                    left++;
                }
                right++;
            }else if ((right-left)+1 > s1.length()){
                char c = s2.charAt(left);
                if (map.containsKey(c)){
                    map.put(c,map.get(c)+1);
                    if (map.get(c) == 1)
                        count+=1;
                }
                left++;
            }

            if (count == 0)
                return true;
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
