package prep.binary_search.on_answers;

public class KoKoEatingBanana {

    public int kokoEatBanana(int []piles,int h){
        int range = getMax(piles);
        for (int rate = 1; rate <= range; rate++){
            if (canKoKoEatAll(piles,rate,h))
                return rate;
        }
        return -1;
    }

    public int kokoEatBananaOptimized(int []piles,int h){
        int low = 1;
        int high = getMax(piles);
        int minimumRate = Integer.MAX_VALUE;
        while (low <= high){
            int mid = low + ((high-low)/2);
            boolean eatable = canKoKoEatAll(piles,mid,h);
            if (eatable){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    private boolean canKoKoEatAll(int[] piles, int rate, int hour) {
        int sum = 0;
        for (int pile : piles){
            sum += Math.ceil((double) pile/ (double)rate);
        }
        return sum <= hour;
    }

    private int getMax(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles){
            max = Math.max(max,pile);
        }
        return max;
    }

}
