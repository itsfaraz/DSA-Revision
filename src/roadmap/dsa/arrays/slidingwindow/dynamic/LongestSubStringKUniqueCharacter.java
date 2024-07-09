package roadmap.dsa.arrays.slidingwindow.dynamic;

import java.util.HashMap;

public class LongestSubStringKUniqueCharacter {

    /*
        Longest Substring with k unique character
        given string
        str = a a b a c b e b e b e
        k = 3

        output = 7

        possible solutions :    size
        a a b a c              = 5
        a b a c                = 4
        b a c b                = 4
        a c b                  = 3
        c b e                  = 3
        c b e b e b e          = 7

        Longest substring = 7
     */

    public int longestKUniqueSubString(String strInput,int kUniqueCharacters){

        int i = 0;
        int j = 0;
        int max = 0;
        String longestSubStringMetaData = "";
        HashMap<Character,Integer> map = new HashMap<>();
        while(j < strInput.length() && i < strInput.length()){
            char c = strInput.charAt(j);
            map.put(c,map.getOrDefault(c,0)+1);
            if (map.size() < kUniqueCharacters){
                j++;
            }else if(map.size() == kUniqueCharacters){
                max = Math.max(j-i+1,max);
                j++;
            }else if (map.size() > kUniqueCharacters){
                while (map.size() > kUniqueCharacters && i >= 0){
                    char ch = strInput.charAt(i);
                    if (map.containsKey(ch)){
                        map.put(ch,map.get(ch)-1);
                    }
                    if(map.get(ch) == 0)
                        map.remove(ch);
                    i++;
                }
                j++;
            }
        }

        return max;
    }

}
