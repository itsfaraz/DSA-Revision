package roadmap.dsa.dp;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
//        System.out.println(lcsA1("ABCDGHABDHFIGFGOUGFLUGLGFLF","FKHSHLKDHLKKHFAEDFHR",""));
//        System.out.println(lcsA1Optimize("ABCDGHABDHFIGFGOUGFLUGLGFLF","FKHSHLKDHLKKHFAEDFHR",0,0));

        String s1 = "abcd";
        String s2 = "agcfd";
        s1 = "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc";
        s2 = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
        s1 = "dsknf;ksflknskfnsknff;kdkfndnfkdnfkdfffsd";
        s2 = "prhwoidbfvlknldjgbljdbvjkbkkjvbzbvv";
        int [][] storage = new int[s1.length()][s2.length()];
        for (int rowIdx = 0; rowIdx < storage.length;rowIdx++){
            for (int colIdx = 0; colIdx < storage[0].length;colIdx++){
                storage[rowIdx][colIdx] = -1;
            }
        }
        System.out.println(lcsA2(s1,s2,0,0,storage));
        System.out.println(lcsA3(s1,s2));
    }

    public static int lcsA1(String s1,String s2,String ans){

        if (s1.isEmpty() || s2.isEmpty())
            return 0;

        int count = 0;
        char first = s1.charAt(0);
        char second = s2.charAt(0);
        if (first == second){
            count += lcsA1(s1.substring(1),s2.substring(1),ans+first);
            return count+1;
        }else{
            int result1 = lcsA1(s1,s2.substring(1),ans);
            int result2 = lcsA1(s1.substring(1),s2,ans);
            count += Math.max(result1,result2);
        }

        return count;
    }

    public static int lcsA1Optimize(String s1,String s2,int vidx1,int vidx2){

        if (vidx1 == s1.length() || vidx2 == s2.length())
            return 0;

        int count = 0;
        if (s1.charAt(vidx1) == s2.charAt(vidx2)){
            count = lcsA1Optimize(s1,s2,vidx1+1,vidx2+1);
            return count+1;
        }else{
            int result1 = lcsA1Optimize(s1,s2,vidx1,vidx2+1);
            int result2 = lcsA1Optimize(s1,s2,vidx1+1,vidx2);
            count = Math.max(result1,result2);
        }
        return count;
    }

    private static class Pair{
        int first ;
        int second;

        public Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }

    public static int lcsA2(String s1, String s2, int vidx1, int vidx2,int [][]storage){

        if (vidx1 == s1.length() || vidx2 == s2.length())
            return 0;


        if (storage[vidx1][vidx2] != -1){
            return storage[vidx1][vidx2];
        }

        int count = 0;
        if (s1.charAt(vidx1) == s2.charAt(vidx2)){
            count = lcsA2(s1,s2,vidx1+1,vidx2+1,storage);
            return count+1;
        }else{
            int result1 = lcsA2(s1,s2,vidx1,vidx2+1,storage);
            int result2 = lcsA2(s1,s2,vidx1+1,vidx2,storage);
            count = Math.max(result1,result2);
        }
        storage[vidx1][vidx2] = count;
        return count;
    }

    // Bottom Up (Tabulation)
    public static int lcsA3(String s1,String s2){
        int [][]storage = new int [s1.length()+1][s2.length()+1];

        for (int rowIdx = s1.length()-1; rowIdx >= 0; rowIdx--){
            for (int colIdx = s2.length()-1; colIdx >= 0; colIdx--){
                if (s1.charAt(rowIdx) == s2.charAt(colIdx)){
                    storage[rowIdx][colIdx] = storage[rowIdx+1][colIdx+1]+1;
                }else{
                    storage[rowIdx][colIdx] = Math.max(storage[rowIdx+1][colIdx],storage[rowIdx][colIdx+1]);
                }
            }
        }

        return storage[0][0];
    }

}
