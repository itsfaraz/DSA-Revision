package dsa.backtracking;

public class LexicographicalPrint {

    public static void main(String[] args) {
//        printLexico(12,0);
        palindromePartitioning("nitin","",0);
    }

    public static void printLexico(int no,int curr){

        if (curr >= no)
            return;
        System.out.println(curr);
        int idx = 0;
        if (curr == 0)
            idx = 1;
        for ( ;idx <= 9; idx++){
            printLexico(no,(curr*10)+idx);
        }
    }

    public static void palindromePartitioning(String input,String ans,int vidx){
        if (input.isEmpty())
            return;
        for (int idx = vidx; idx < input.length(); idx++){
            String inputAnswer = input.substring(0,idx+1);
            String inputQues = input.substring(inputAnswer.length(),input.length());
            System.out.println((ans+inputAnswer)+" ");
            palindromePartitioning(inputQues,(ans+inputAnswer),idx+1);
        }
    }

}
