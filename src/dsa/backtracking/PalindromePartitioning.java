package dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {

        allResult = new ArrayList<>();
        new PalindromePartitioning().palindromePartitioning("aab","");
        System.out.println(allResult);
    }

    private static List<List<String>> allResult;
    public void palindromePartitioning(String input,String ans){
        if (input.isEmpty()){
            System.out.println(ans);
            allResult.add(getStringList(ans));
            return;
        }

        for (int idx = 1; idx <= input.length(); idx++){
            String nextQuestion = input.substring(idx);
            String currentAns = input.substring(0,idx);
            if (isPalindrome(currentAns)) {
                palindromePartitioning(nextQuestion, ans + currentAns+" ");
            }
        }
    }

    private List<String> getStringList(String ans) {
        List<String> list = new ArrayList<>();
        for (int idx =0; idx <= ans.length();idx++){
            String result = "";
            while (true){
                if (idx >= ans.length())
                    break;
                if (ans.charAt(idx) != ' '){
                    result += ans.charAt(idx);
                }else{
                    list.add(result);
                    break;
                }
                idx++;
            }
        }
        return list;
    }


    private boolean isPalindrome(String currentAns) {
        int start = 0;
        int end = currentAns.length()-1;
        while (start <= end){
            if (currentAns.charAt(start) != currentAns.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

}
