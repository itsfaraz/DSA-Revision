package dsa.backtracking;

public class GenerateValidParantheses {

    public static void main(String[] args) {
        GenerateValidParantheses parantheses = new GenerateValidParantheses();
        int no = 2;
        parantheses.printParanthesis(no*2,"",0);
    }


    public void printParanthesis(int no,String ans,int count){
        if (no == 0) {
            if (count == 0)
                System.out.println(ans);
            return;
        }

        if (count == -1)
            return;

        printParanthesis(no-1,ans+"(",count+1);
        printParanthesis(no-1,ans+")",count-1);

    }

}
