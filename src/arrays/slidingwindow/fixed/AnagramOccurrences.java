package arrays.slidingwindow.fixed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AnagramOccurrences {


    public List<Integer> countAnagramOccurrences(String input,String pattern){
        HashMap<Character,Integer> map = new HashMap<>();
        fillPattern(map,pattern);
        int count = map.size();
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(j < input.length()){
            char c = input.charAt(j);
            if (map.containsKey(c)){
                int value = map.get(c);
                map.put(c,value-1);
                if (value-1 == 0)
                    count--;
            }

            int windowSize = (j-i)+1;
            if (windowSize < pattern.length()){
                j++;
            }else if(windowSize == pattern.length()){
                if (count == 0) {
                    result.add(i);
                }
                char ic = input.charAt(i);
                if (map.containsKey(ic)) {
                    int value = map.get(ic);
                    map.put(ic, value+1);
                    if (value+1 != 0)
                        count++;
                }

                i++;
                j++;
            }
        }

        return result;
    }

    private boolean isAnagram(HashMap<Character,Integer> map){
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            char key = (Character) iterator.next();
            if (map.get(key) != 0)
                return false;
        }
        return true;
    }

    private void fillPattern(HashMap<Character, Integer> map, String pattern) {
        for(int idx = 0; idx < pattern.length(); idx++){
            char c = pattern.charAt(idx);
            int val = 1;
            if (map.containsKey(c)){
                val = map.get(c);
                val += 1;
            }
            map.put(c,val);
        }
    }


}
