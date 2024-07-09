package prep.binary_search.on_answers;

public class AggressiveCows {

    public int maximumDistanceCowS(int []arr,int k){

        int min = 0;
        int max = getMax(arr);
        int maxDistance = Integer.MIN_VALUE;
        for (int distance = min; distance <= max; distance++){
            if (canWePlaceCows(arr,distance,k)){
                maxDistance = Math.max(distance,maxDistance);
            }else break;
        }
        return maxDistance;
    }

    private int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (Integer value : arr){
            max = Math.max(value,max);
        }
        return max;
    }

    private boolean canWePlaceCows(int[] arr, int distance, int k) {
        int count = 1;
        int last = arr[0];
        for (int idx = 1; idx < arr.length; idx++){
            if (arr[idx] - distance >= last){
                count++;
            }
        }
        return count >= k;
    }

}
