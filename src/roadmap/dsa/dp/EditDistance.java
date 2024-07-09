package roadmap.dsa.dp;

public class EditDistance {

    public static void main(String[] args) {

        String s1 = "abcd";
        String s2 = "agcfd";

        System.out.println(editDistanceA1(s1,s2,0,0));
        int [][]storage = new int [s1.length()][s2.length()];
        fillArray(storage);
        System.out.println(editDistanceA2(s1,s2,0,0,storage));
        System.out.println(editDistanceA3(s1,s2));
    }

    public static void fillArray(int [][]array){
        for (int rowIdx = 0; rowIdx < array.length; rowIdx++){
            for(int colIdx = 0; colIdx < array[0].length; colIdx++){
                array[rowIdx][colIdx] = -1;
            }
        }
    }
    public static int editDistanceA1(String s1,String s2,int vidx1,int vidx2){

        if (vidx1 == s1.length() || vidx2 == s2.length())
            return Math.max(s1.length()-vidx1,s2.length()-vidx2);


        char c1 = s1.charAt(vidx1);
        char c2 = s2.charAt(vidx2);
        int finalResult = 0;
        if (c1 == c2){
            finalResult = editDistanceA1(s1,s2,vidx1+1,vidx2+1);
        }else{
//            insert
            int result1 = editDistanceA1(s1,s2,vidx1+1,vidx2);
//            delete
            int result2 = editDistanceA1(s1,s2,vidx1,vidx2+1);
//            replace
            int result3 = editDistanceA1(s1,s2,vidx1+1,vidx2+1);
            finalResult = Math.min(Math.min(result1,result2),result3)+1;
        }

        return finalResult;
    }


    public static int editDistanceA2(String s1,String s2,int vidx1,int vidx2,int [][]storage){

        if (vidx1 == s1.length() || vidx2 == s2.length())
            return Math.max(s1.length()-vidx1,s2.length()-vidx2);

        if (storage[vidx1][vidx2] != -1)
            return storage[vidx1][vidx2];


        char c1 = s1.charAt(vidx1);
        char c2 = s2.charAt(vidx2);
        int finalResult = 0;
        if (c1 == c2){
            finalResult = editDistanceA2(s1,s2,vidx1+1,vidx2+1,storage);
        }else{
//            insert
            int result1 = editDistanceA2(s1,s2,vidx1+1,vidx2,storage);
//            delete
            int result2 = editDistanceA2(s1,s2,vidx1,vidx2+1,storage);
//            replace
            int result3 = editDistanceA2(s1,s2,vidx1+1,vidx2+1,storage);
            finalResult = Math.min(Math.min(result1,result2),result3)+1;
        }

        storage[vidx1][vidx2] = finalResult;

        return finalResult;
    }


    // Bottom Up (Memoization)
    public static int editDistanceA3(String s1,String s2){
        int [][]storage = new int[s1.length()+1][s2.length()+1];
        prefilledArray(storage);
        for (int rowIdx = storage.length-2;rowIdx >= 0; rowIdx--){
            for (int colIdx = storage[0].length-2; colIdx >= 0; colIdx--){
                if (s1.charAt(rowIdx) == s2.charAt(colIdx)){
                    storage[rowIdx][colIdx] = storage[rowIdx+1][colIdx+1];
                }else{
//                    storage cell = minimum of insert,update & delete
                    int insert = storage[rowIdx+1][colIdx];
                    int delete = storage[rowIdx][colIdx+1];
                    int replace = storage[rowIdx+1][colIdx+1];
                    storage[rowIdx][colIdx] = Math.min(Math.min(insert,delete),replace)+1;
                }

            }
        }

        return storage[0][0];
    }

    private static void prefilledArray(int[][] storage) {
        for (int rowIdx = storage.length-1;rowIdx >= 0; rowIdx--){
            storage[rowIdx][storage[0].length-1] = storage.length-1 - rowIdx;
        }

        for (int colIdx = storage[0].length-1;colIdx >= 0; colIdx--){
            storage[storage.length-1][colIdx] = storage[0].length-1 - colIdx;
        }

    }

}
