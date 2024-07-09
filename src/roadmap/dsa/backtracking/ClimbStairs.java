package roadmap.dsa.backtracking;

public class ClimbStairs {

    public static void main(String[] args) {
        int result = new ClimbStairs().climb(5,3,"");
        System.out.println("----------------------------------------");
        System.out.println(result);
    }
    public static int count = 0;

    public int climb(int no,int stairSkip,String ans){
        if (no == 0){
            ClimbStairs.count++;
            System.out.println(ans);
            return 1;
        }
        if (no < 0)
            return 0;

        int resultCount = 0;
        for (int stairIdx = 1; stairIdx <= stairSkip; stairIdx++){
            resultCount += climb(no-stairIdx,stairSkip,ans+""+stairIdx);
        }
        return resultCount;
    }

}
