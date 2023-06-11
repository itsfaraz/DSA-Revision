package dsa.arrays.binarysearch;

public class Main {

    public static void main(String[] args) {
        // Binary Search Problems

        BinarySearch bSearch = new BinarySearch();
        int ele = 4;
        int []arr = {1,2,3,4,5,6,7,8,9,10};
        int resultIdx = bSearch.bSearch(arr,ele);
        System.out.println("BinarySearch :: Element "+ele+" found at index "+resultIdx);

        System.out.println("----------------------------------------------------------");

        // Binary Search on Reverse Sorted Array
        ele = 4;
        arr = new int[]{20, 17, 15, 14, 13, 12, 10, 9, 8, 4};
        DescendingSortedArray bSearch1 = new DescendingSortedArray();
        resultIdx = bSearch1.binarySearch(arr,ele);
        System.out.println("DescendingSortedArray :: Element "+ele+" found at index "+resultIdx);

        System.out.println("----------------------------------------------------------");

        // Order Agnostic Binary Search
        int searchEle = 14;
        int arr1[] = new int[]{10,14,20,21,29,34,66,90}; // 14 is on 1st index
        int arr2[] = new int[]{90,66,34,29,21,20,14,10}; // 14 is on 6th index
        OrderAgnosticBinarySearch agnosticBinarySearch = new OrderAgnosticBinarySearch();
        resultIdx = agnosticBinarySearch.binarySearch(arr2,searchEle);
        System.out.println("OrderAgnosticBinarySearch :: Order Agnostic Binary Search Idx Found at :- "+resultIdx);

        System.out.println("----------------------------------------------------------");

        // First Occurrence in an Array

        searchEle = 10;
        arr = new int[]{2,4,10,10,10,18,20};
        resultIdx = new FirstOccurrenceSearch().firstOccurrence(arr,searchEle);
        System.out.println("FirstOccurrenceSearch :: First Occurrence of an element "+searchEle+" is found at index "+resultIdx);

        System.out.println("----------------------------------------------------------");

        resultIdx = new LastOccurrenceSearch().lastOccurrence(arr,searchEle);
        System.out.println("LastOccurrenceSearch :: Last Occurrence of an element "+searchEle+" is found at index "+resultIdx);

        System.out.println("----------------------------------------------------------");

        // Count of an element in sorted array
        int resultCount = new CountElement().countOccurrences(arr,searchEle);
        System.out.println("CountElement :: Element "+searchEle+" is present "+resultCount+" times");

        System.out.println("----------------------------------------------------------");

        // Number of times is a sorted array rotated
        arr = new int[]{11,12,15,18,2,5,6,8};
        int rotationCount = new ArrayRotatedCount().rotationCount(arr);
        System.out.println("ArrayRotatedCount :: Array is rotated "+rotationCount+" times");

        System.out.println("----------------------------------------------------------");

        // Search in sorted rotated array
        ele = 8;
        int searchIndex = new SearchRotatedSortedArray().search(arr,ele);
        System.out.println("SearchRotatedSortedArray :: Index found at position "+searchIndex);

        System.out.println("----------------------------------------------------------");

        // Search in nearly sorted array
        arr = new int[]{5,10,30,20,40};
        ele = 20;
        searchIndex = new SearchNearlySortedArray().search(arr,ele);
        System.out.println("SearchNearlySortedArray :: Index found at position "+searchIndex);


        System.out.println("----------------------------------------------------------");

        // Search the floor of an element
        arr = new int[]{1,2,3,4,8,10,10,12,19};
        ele = 5;
        searchIndex = new SearchFloor().search(arr,ele);
        System.out.println("SearchFloor :: Index found at position "+searchIndex);

        System.out.println("----------------------------------------------------------");

        // Search the ceil of an element
        arr = new int[]{5, 9, 12, 14, 20, 25, 35};
        ele = 6;
        searchIndex = new SearchCeil().search(arr,ele);
        System.out.println("SearchCeil :: Index found at position "+searchIndex);



        System.out.println("----------------------------------------------------------");

        // Search the next character
        char [] charArray = new char[]{'a','c','f','h'};
        char key = 'f';
        char resultKey = new NextAlphabet().nextCharacter(charArray,key);
        System.out.println("NextAlphabet :: Next Character found : "+resultKey);



        System.out.println("----------------------------------------------------------");

        // Search in infinite binary sorted array
        arr = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,}; // infinite
        ele = 1;
        searchIndex = new BinarySortedInfiniteArray().searchElement(arr,ele);
        System.out.println("BinarySortedInfiniteArray :: Element found at position : "+searchIndex);



        System.out.println("----------------------------------------------------------");

        // Search minimum difference in a sorted array
        arr = new int[]{2, 5, 8, 10, 12, 16};
        arr = new int[]{4,6,10};
        key = 6;
        key = 7;
        int searchElement = new MinimumDifference().minimumDifferenceElement(arr,key);
        System.out.println("MinimumDifference :: Minimum difference element : "+searchElement);

        System.out.println("----------------------------------------------------------");

        // Find peak element in an unsorted array
        arr = new int[]{5, 10, 20, 15};
        searchIndex = new PeakElement().searchPeak(arr);
        System.out.println("PeakElement :: Peak element found at position: "+searchIndex);


        System.out.println("----------------------------------------------------------");

        // Find element in an bitonic array
        arr = new int[]{1,3,8,12,4,2};
        ele = 4;
        searchIndex = new SearchBitonicArray().search(arr,ele);
        System.out.println("SearchBitonicArray :: Element found at position: "+searchIndex);


        System.out.println("----------------------------------------------------------");
        // Search element in matrix
        int [][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };
        ele = 29;
        MatrixSearch.Pair result = new MatrixSearch().search(matrix,ele);
        System.out.println("MatrixSearch :: Element found at row "+result.first+" and column "+result.second);
    }

}
