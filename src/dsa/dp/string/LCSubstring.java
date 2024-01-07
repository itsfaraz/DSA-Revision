package dsa.dp.string;

import java.util.Arrays;

public class LCSubstring {
    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "acdghr";
        System.out.println(lcsV1(s1,s2,0,0,0));
        int [][]storage = new int[s1.length()][s2.length()];
        fillIntialValue(storage);
        System.out.println(lcsV2(s1,s2,0,0,0,storage));
        printStorage(storage);
    }
    static int lcsV1(String s1,String s2,int vidx1,int vidx2,int count){
        if (vidx1 == s1.length() || vidx2 == s2.length()){
            return count;
        }
        int ans = 0;
        if (s1.charAt(vidx1) == s2.charAt(vidx2)){
            count = lcsV1(s1,s2,vidx1+1,vidx2+1,count+1);
        }else{
            int value1 = lcsV1(s1,s2,vidx1,vidx2+1,0);
            int value2 = lcsV1(s1,s2,vidx1+1,vidx2,0);
            ans = Math.max(value1,value2) ;
        }
        return Math.max(ans,count);
    }

    private static void fillIntialValue(int[][] storage) {
        for (int row = 0; row < storage.length; row++){
            Arrays.fill(storage[row],-1);
        }
    }

    static int lcsV2(String s1,String s2,int vidx1,int vidx2,int count,int [][]storage){
        if (vidx1 == s1.length() || vidx2 == s2.length()){
            return count;
        }
        if (storage[vidx1][vidx2] != -1)
            return Math.max(storage[vidx1][vidx2],count);
        int ans = 0;
        if (s1.charAt(vidx1) == s2.charAt(vidx2)){
            count = lcsV2(s1,s2,vidx1+1,vidx2+1,count+1,storage);
        }else{
            int value1 = lcsV2(s1,s2,vidx1,vidx2+1,0,storage);
            int value2 = lcsV2(s1,s2,vidx1+1,vidx2,0,storage);
            ans = Math.max(value1,value2) ;
        }
        storage[vidx1][vidx2] = Math.max(ans,count);
        return storage[vidx1][vidx2];
    }

    static void printStorage(int [][]storage){
        for (int row = 0; row < storage.length;row++){
            System.out.println(Arrays.toString(storage[row]));
        }
    }
}
