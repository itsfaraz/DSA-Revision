package roadmap.dsa.backtracking;

public class QueenCombination {

    public static void main(String[] args) {
        new QueenCombination().queenCombinationBoxRespect(new boolean[4],0,2,0,"");
        System.out.println();
        new QueenCombination().queenCombinationQueenRespect(new boolean[4],0,2,0,"");
    }

    public void queenCombinationQueenRespect(boolean[] boxes,int pQueen,int noQueen,int vidx,String ans){
        if (pQueen == noQueen){
            System.out.println(ans);
            return;
        }

        if (vidx == boxes.length)
            return;

        for (int idx = vidx; idx < boxes.length; idx++){
            queenCombinationQueenRespect(boxes, pQueen+1, noQueen, idx+1, ans+"q"+pQueen+"b"+idx);
        }

    }

    public void queenCombinationBoxRespect(boolean []boxes,int pQueen,int noQueen,int vidx,String ans){

        if (pQueen == noQueen){
            System.out.println(ans);
            return;
        }

        if (vidx == boxes.length)
            return;

        if (!boxes[vidx]){
            boxes[vidx] = true;
            queenCombinationBoxRespect(boxes,pQueen+1,noQueen,vidx+1,ans+"q"+pQueen+"b"+vidx);
            boxes[vidx] = false;
        }

        queenCombinationBoxRespect(boxes,pQueen,noQueen,vidx+1,ans);
    }
}
