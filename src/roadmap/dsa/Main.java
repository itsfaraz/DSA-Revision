package roadmap.dsa;

import java.util.ArrayList;

public class Main {
//    static{
//        System.out.println("My World");
//    }
    public static void main(String[] args) {
        String s1 = new String("Faraz");
        String s2 = "Faraz";
        System.out.println(s1+" "+s2);
//        System.out.println(isMatching(s1+"#",s2));
//       Test.testMethod();



    }

    public static boolean isMatching(String s1,String s2){
        ArrayList<String> words = getSplittedWords(s1); // O(N) + O(N) = O(N)
        for (int idx = 0; idx < words.size(); idx++){
            if (words.get(idx).equals(s2)){
                return true;
            }
        }
        return false;
    }

    public static ArrayList<String> getSplittedWords(String input){
        ArrayList<String> words = new ArrayList<>();
        String temp = ""; // O(N)
        for (char c : input.toCharArray()){
            if (c == ' ' || c == '#'){
                words.add(temp);
                temp = "";
            }
            if (c == ' '){
                continue;
            }
            temp += c;
        }
        return words;
    }
}
