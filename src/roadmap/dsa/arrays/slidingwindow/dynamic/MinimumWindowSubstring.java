package roadmap.dsa.arrays.slidingwindow.dynamic;

import java.util.HashMap;

public class MinimumWindowSubstring {

    /*
       Minimum Window Substring
       Given a string we have to find minimum window of substring t which was given, irrespective
       of duplicates character

       String str = "TOTMTAPTAT"
       String t = "TTA"

       Possible Answer Candidates

       Indexes          Window Size     Minimum Window
       index: 2 - 5     =  4         |
       index: 4 - 7     =  4         |      3
       index: 7 - 9     =  3         |



     */

    public void minimumSubstring(String str,String t){

        int i = 0;
        int j = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        fillMap(map,t);
        HashMap copyMap = new HashMap(map);
        int count = map.size();
        while (j < str.length()){
            char c = str.charAt(j);
            if (map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if (map.get(c) == 0)
                    count--;
            }

            if (count > 0){
                j++;
            }else if(count == 0){
                while (count == 0){
                    char ichar = str.charAt(i);
                    if (map.containsKey(ichar)){
                        map.put(ichar,map.get(ichar)+1);
                        if (map.get(ichar) > 0)
                            count++;
                    }
                    if (count > 0){
                        System.out.println("index: "+i+" - "+j);
                    }

                    if (i == j)
                        break;
                    i++;
                }
                j++;
            }

        }

    }

    private void fillMap(HashMap<Character, Integer> map, String t) {
        for(int idx = 0; idx < t.length(); idx++){
            char c = t.charAt(idx);
            map.put(c,map.getOrDefault(c,0)+1);
        }
    }

}
