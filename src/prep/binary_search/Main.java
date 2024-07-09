package prep.binary_search;

import binary_search.*;
import binary_search.on_answers.KoKoEatingBanana;

public class Main {
    public static void main(String[] args) {
//        Search bSearch = new Search();
//        boolean result = bSearch.bSearch(new int[]{0,3,8,12,19,25,80},390);
//        System.out.println(result);

        int []arr = {2,4,10,10,10,18,20};
//        Occurence occurrence = new Occurence();
//        int searchResult = occurrence.firstOccurrence(arr,10);
//        System.out.println(searchResult);
//        searchResult = occurrence.lastOccurrence(arr,10);
//        System.out.println(searchResult);

//        arr =new int []{4,5,6,7,0,1,2};
//        arr =new int []{11,12,15,18,2,5,6,8};
//        System.out.println(new SortedRotatedArray().rotatedSortedList(arr));

//        arr = new int[]{1,1,2,3,3,4,4,8,8};
//        arr = new int[]{3,3,7,7,10,11,11};
//        int n = arr.length-1;
//        System.out.println(new SingleElement().singleElement(arr,0,n));



//        arr = new int[]{1,2,3,4,8,10,10,12,19,20,25,40};
//        FloorCiel floorCiel = new FloorCiel();
//        int target = 12;
//        System.out.println(floorCiel.findFloor(arr,target));
//        System.out.println(floorCiel.findCiel(arr,target));

//        int x = 96;
//        System.out.println(new SquareRoot().squareRootIterative(x));
//        System.out.println(new SquareRoot().squareRoot(x));


//        int []stalls = {6, 7,  9, 11, 13, 15};
//        int k = 4;
//        AggressiveCows aggressiveCows = new AggressiveCows();
//        int result = aggressiveCows.maximumDistanceCowS(stalls,k);
//        System.out.println(result);


        int []piles = {1000000000};
        int h = 2;
        int result = new KoKoEatingBanana().kokoEatBananaOptimized(piles,h);
        System.out.println(result);


    }
}