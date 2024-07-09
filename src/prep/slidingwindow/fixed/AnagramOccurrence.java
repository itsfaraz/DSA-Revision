package prep.slidingwindow.fixed;

import java.util.HashMap;

public class AnagramOccurrence {

    public int anagramOccurrence(String input,String pattern){

        HashMap<Character,Integer> map = new HashMap<>();
        for (Character character : pattern.toCharArray()){
             map.put(character,map.getOrDefault(character,0)+1);
        }

        int count = map.size();
        int result = 0;
        int i = 0;
        int j = 0;
        while (j <= input.length() && i <= input.length() - pattern.length()){
            int condition = (j-i)+1;

            if (condition < pattern.length()+1){
                char jValue = input.charAt(j);
                if (map.containsKey(jValue)){
                    map.put(jValue,map.get(jValue)-1);
                    if (map.get(jValue) == 0)
                        count--;
                }
                j++;
            }else if (condition == pattern.length()+1){
                char iValue = input.charAt(i);
                if (count == 0)
                    result += 1;
                if (map.containsKey(iValue)){
                    map.put(iValue,map.get(iValue)+1);
                    if (map.get(iValue) != 0)
                        count++;
                }
                i++;
            }
        }

        return result;
    }

}
