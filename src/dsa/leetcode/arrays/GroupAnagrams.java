package dsa.leetcode.arrays;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String []strs = {""};


        System.out.println(groupAnagrams.groupAnagrams(strs));
        System.out.println(groupAnagrams.groupAnagramsA2(strs));

    }


    // Optimized
    public List<List<String>> groupAnagramsA2(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (int idx = 0; idx < strs.length; idx++){
            String sorted = getSortedString(strs[idx]);
            if (map.containsKey(sorted)){
                List<String> list = map.get(sorted);
                list.add(strs[idx]);
                map.put(sorted,list);
            }else{
                List<String> list = new ArrayList<>();
                list.add(strs[idx]);
                map.put(sorted,list);
            }
        }

        List<List<String>> list = new ArrayList<>();
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            list.add(map.get(key));
        }

        return list;
    }

    private String getSortedString(String str){
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        StringBuilder sb = new StringBuilder();
        for (char c : charArray){
            sb.append(c);
        }
        return sb.toString();
    }

    // Approach 1
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        boolean []isDone = new boolean[strs.length];


        for (int idx = 0; idx < strs.length; idx++){
            if (strs[idx].isEmpty()){
                isDone[idx] = true;
                result.add(new ArrayList<>());
                continue;
            }
            if (isDone[idx])
                continue;
            ArrayList<String> tempList = new ArrayList<>();
            HashMap<Character,Integer> map = getFilledMap(strs[idx]);
            for (int next = 0; next < strs.length; next++){
                if (strs[next].isEmpty())
                    continue;
                if (isValid(strs[next],map)) {
                    tempList.add(strs[next]);
                    isDone[next] = true;
                }
            }
            result.add(tempList);
        }

        return result;
    }

    private boolean isValid(String s,HashMap<Character,Integer> map){
        if (s.length() == map.size()){
            for(int cidx = 0; cidx < s.length(); cidx++){
                char c = s.charAt(cidx);
                if (!map.containsKey(c))
                    return false;

            }
        }
        return true;
    }
    private HashMap<Character,Integer> getFilledMap(String s){
        HashMap<Character,Integer> sMap = new HashMap();
        for(int cIdx = 0; cIdx < s.length(); cIdx++){
            sMap.put(s.charAt(cIdx),sMap.getOrDefault(s.charAt(cIdx),0)+1);
        }
        return sMap;
    }


}
