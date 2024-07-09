package prep.binary_search;

public class SquareRoot {

    public int squareRootIterative(int x){
        int result = 0;
        int increment = 1;
        int counter = 1;
        while (increment < x){
            increment = counter * counter;
            counter += 1;
            result += 1;

        }
        return result-1;
    }

    public int squareRoot(int x){
        int low = 0;
        int high = x;
        int result = Integer.MAX_VALUE;
        while (low <= high){
            int mid = low + (high - low)/2;
            int target = mid*mid;
            if (target <= x){
                result = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }

        }
        return result;
    }

}
