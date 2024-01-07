package dsa.dp.string;

public class ShortestCommonSuperSequence {

    public static void main(String[] args) {
//        String s1 = "aaaaaaaa";
//        String s2 = "aaaaaaaa";
//        System.out.println(shortestCommonSupersequence(s1,s2));



        String sp1 = "bbbab";
        String sp2 = "babbb";
        System.out.println(lcs(sp1,sp2));
    }

    public static String shortestCommonSupersequence(String s1,String s2){
        String s3 = lcs(s1,s2);
//        System.out.println(s3);
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        StringBuffer sb = new StringBuffer();
        while (p1 < s1.length() && p2 < s2.length() && p3 < s3.length()){
            while (s1.charAt(p1) != s2.charAt(p2) && s1.charAt(p1) != s3.charAt(p3)){
                sb.append(s1.charAt(p1));
                p1++;
            }
            while (s2.charAt(p2) != s1.charAt(p1) && s2.charAt(p2) != s3.charAt(p3)){
                sb.append(s2.charAt(p2));
                p2++;
            }
            sb.append(s1.charAt(p1));
            p1++;
            p2++;
            p3++;
        }

        while (p1 < s1.length()){
            sb.append(s1.charAt(p1));
            p1++;
        }

        while (p2 < s2.length()){
            sb.append(s2.charAt(p2));
            p2++;
        }
        return sb.toString();
    }
    public static int lcsV1(String s1, String s2, int vidx1, int vidx2){
        if (vidx1 == 0 || vidx2 == 0)
            return 0;

        if (s1.charAt(vidx1-1) == s2.charAt(vidx2-1)){
            return lcsV1(s1,s2,vidx1-1,vidx2-1) + 1;
        }else {
            int value1 = lcsV1(s1,s2,vidx1,vidx2-1);
            int value2 = lcsV1(s1,s2,vidx1-1,vidx2);
            return Math.max(value1,value2);
        }
    }

    public static int lcsV2(String s1,String s2,int vidx1,int vidx2,int [][]storage){

        if (vidx1 == 0 || vidx2 == 0){
            return 0;
        }

        if (storage[vidx1-1][vidx2-1] != 0){
            return storage[vidx1-1][vidx2-1];
        }

        if (s1.charAt(vidx1-1) == s2.charAt(vidx2-1)){
            return lcsV2(s1,s2,vidx1-1,vidx2-1,storage)+1;
        }else{
            int value1 = lcsV2(s1,s2,vidx1,vidx2-1,storage);
            int value2 = lcsV2(s1,s2,vidx1-1,vidx2,storage);
            int result = Math.max(value1,value2);
            storage[vidx1][vidx2] = result;
            return result;
        }
    }

        public static String lcs(String s1,String s2){
            int n = s1.length();
            int m = s2.length();
            int [][]storage = new int[n+1][m+1];
            for (int rowIdx = 1; rowIdx < storage.length;rowIdx++){
                for (int colIdx = 1; colIdx < storage[0].length; colIdx++){
                    if (s1.charAt(rowIdx-1) == s2.charAt(colIdx-1)){
                        storage[rowIdx][colIdx] = (storage[rowIdx-1][colIdx-1])+1;
                    }else{
                        int value1 = storage[rowIdx][colIdx-1];
                        int value2 = storage[rowIdx-1][colIdx];
                        storage[rowIdx][colIdx] = Math.max(value1,value2);
                    }
                }
            }

            StringBuffer sb = new StringBuffer();
            int row = n;
            int col = m;
            while (row > 0 && col > 0){
                if (s1.charAt(row-1) == s2.charAt(col-1)){
                    sb.append(s1.charAt(row-1));
                    row -=1;
                    col -=1;
                }else{
                    if (storage[row][col-1] >= storage[row-1][col]){
                        col -=1;
                    }else{
                        row -=1;
                    }
                }
            }
            return sb.reverse().toString();
        }


}
