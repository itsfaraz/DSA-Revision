package roadmap.dsa.backtracking;

public class StringPermutation {

    public static void main(String[] args) {
        generatePermutations("abcd","");
    }

    public static int count = 0;
    public static void generatePermutations(String str,String ans){

        if (str.isEmpty()){
            System.out.println(++count+") "+ans);
            return;
        }

        for (int charIdx = 0; charIdx < str.length(); charIdx++){
            char currentChar = str.charAt(charIdx);
            String quesFirst = "";
            if (charIdx > 0)
                quesFirst = str.substring(0,charIdx);
            String questSecond = "";
            if (charIdx+1 < str.length())
                questSecond = str.substring(charIdx+1,str.length());
            generatePermutations(quesFirst+questSecond,ans+currentChar);
        }

    }

}
