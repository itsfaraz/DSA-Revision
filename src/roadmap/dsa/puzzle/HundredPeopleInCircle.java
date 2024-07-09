package roadmap.dsa.puzzle;


// 100 people in a circle with gun/sword
public class HundredPeopleInCircle {

    /*
        100 people standing in a circle in an order 1 to 100. No. 1 has a sword.
        He kills the next person (i.e. No. 2) and gives the sword to the next (i.e. No. 3).
        All people do the same until only 1 survives. Which number survives at the last?
        There are 100 people starting from 1 to 100.
     */


    public static void main(String[] args) {
        int range = 6;
        int skip = 3;
        int result = new HundredPeopleInCircle().findLastManStanding(range,skip,2);
        if (result == skip)
            System.out.println(1);
        else System.out.println(result);
    }


    public int findLastManStanding(int range,int skip,int k){
        int tillKillRange = getPowerOf(range,skip,k);
        int totalKilled = range-tillKillRange;
        return (totalKilled*2)+1;
    }

    private int getPowerOf(int range,int lowerBound,int power) {
        int middleMan = range;
        while(middleMan-- != lowerBound){
            double value = log(middleMan,power);
            if (Math.ceil(value) == Math.floor(value)){
                return middleMan;
            }
        }
        return middleMan;
    }

    private double log(int value,int power){
        return Math.log(value)/Math.log(power);
    }

}
