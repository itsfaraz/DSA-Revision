package roadmap.dsa.leetcode.arrays;

import java.util.HashMap;

public class ValidAnagram {

    public static void main(String[] args) {
        ValidAnagram anagram = new ValidAnagram();
        System.out.println(anagram.isAnagram("a","ab"));
    }

    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map = getFilledMap(s);
        for(int cIdx = 0; cIdx < t.length(); cIdx++){
            char c = t.charAt(cIdx);
            if(map.isEmpty()){
                return false;
            }
            if(map.containsKey(c)){
                int count = map.get(c)-1;
                if(count == 0){
                    map.remove(c);
                }else{
                    map.put(c,count);
                }
            }
        }
        if(map.size() == 0)
            return true;
        else return false;
    }

    private HashMap<Character,Integer> getFilledMap(String s){
        HashMap<Character,Integer> sMap = new HashMap();
        for(int cIdx = 0; cIdx < s.length(); cIdx++){
            sMap.put(s.charAt(cIdx),sMap.getOrDefault(s.charAt(cIdx),0)+1);
        }
        return sMap;
    }

}
