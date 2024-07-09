package roadmap.dsa.dp.string;

import java.util.Arrays;

public class LCS {

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
//        System.out.println(lcsV1(s1,s2,0,0));
        int [][]storage = new int[s1.length()][s2.length()];
        fillIntialValue(storage);
        System.out.println(lcsV2(s1,s2,0,0,storage));
        System.out.println(lcsV3(s1,s2));
    }

    private static void fillIntialValue(int[][] storage) {
        for (int row = 0; row < storage.length; row++){
            Arrays.fill(storage[row],-1);
        }
    }

    static int lcsV1(String s1,String s2,int vidx1,int vidx2){
        if (vidx1 == s1.length() || vidx2 == s2.length()){
            return 0;
        }
        int ans = 0;
        if (s1.charAt(vidx1) == s2.charAt(vidx2)){
            ans += lcsV1(s1,s2,vidx1+1,vidx2+1)+1;
        }else{
            int value1 = lcsV1(s1,s2,vidx1,vidx2+1);
            int value2 = lcsV1(s1,s2,vidx1+1,vidx2);
            ans += Math.max(value1,value2);
        }
        return ans;
    }

    static int lcsV2(String s1,String s2,int vidx1,int vidx2,int [][]storage){
        if (vidx1 == s1.length() || vidx2 == s2.length()){
            return 0;
        }

        if (storage[vidx1][vidx2] != -1){
            return storage[vidx1][vidx2];
        }

        int ans = 0;
        if (s1.charAt(vidx1) == s2.charAt(vidx2)){
            ans += lcsV2(s1,s2,vidx1+1,vidx2+1,storage)+1;
        }else{
            int value1 = lcsV2(s1,s2,vidx1,vidx2+1,storage);
            int value2 = lcsV2(s1,s2,vidx1+1,vidx2,storage);
            ans += Math.max(value1,value2);
        }
        storage[vidx1][vidx2] = ans;
        return ans;
    }
    static int lcsV3(String s1,String s2){
        int [][]storage = new int[s1.length()+1][s2.length()+1];

        for (int rowIdx = storage.length-2;rowIdx >= 0; rowIdx--){
            for (int colIdx = storage[0].length-2;colIdx >= 0; colIdx--){
                if (s1.charAt(rowIdx) == s2.charAt(colIdx)){
                    storage[rowIdx][colIdx] = storage[rowIdx+1][colIdx+1] + 1;
                }else{
                    int value1 = storage[rowIdx][colIdx+1]; // left
                    int value2 = storage[rowIdx+1][colIdx]; // right
                    storage[rowIdx][colIdx] += Math.max(value1,value2);
                }
            }
        }
        printStorage(storage);
        return storage[0][0];
    }

    static void printStorage(int [][]storage){
        for (int row = 0; row < storage.length;row++){
            System.out.println(Arrays.toString(storage[row]));
        }
    }


}
