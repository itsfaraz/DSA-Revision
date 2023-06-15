package dsa.basic;

public class Main {
    public static void main(String[] args) {
//        Basic basic = new Basic();
//        basic.takeInput(6);
//        basic.display();
//        System.out.println(basic.max());
//        System.out.println(basic.find(9));
//        System.out.println(basic.search(22));
//        System.out.println("Rotate 1");
//        basic.rotate(2);
//        basic.display();
//        basic.sort();
//        System.out.println("Rotate 2");
//        basic.rotateEnhanced(2);
//        basic.display();
//        basic.reverse();

        Array arr = new Array();
//        arr.subarrayPrint(new int[]{10,20,30,40});
//        arr.subarraySumPrint(new int[]{10,20,30,40});
//        System.out.println(arr.subarrayMaxSum(new int[]{10,20,30,40}));
//
//
//        System.out.println(arr.kadaneAlgorithm(new int[]{2,3,-6,1,2,3,-4,5,-10,6}));
//        arr.printMaximumSubarray(new int[]{2,3,-6,1,2,3,-4,5,-10,6});
//
//
//        int []input = {3,-1,2,-1};
//        System.out.println(arr.circularMaximumSubArraySum(input));

//
        int [][]matrix = {
                {10,20,30,40},
                {50,60,70,80},
                {90,100,110,120},
                {130,140,150,160}
        };
//        arr.waveDisplay(matrix);

        int [][]spiralMatrix = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25},
                {26,27,28,29,30},
        };
        arr.spiralDisplay(matrix);

    }
}
