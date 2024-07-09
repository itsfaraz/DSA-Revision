package roadmap.dsa.dp;

public class BoardPath {

    /*
        Given a board we have to find out no of ways to reach its end,
        Every time we have to throw dice and find out the way
        ex : [1,2,3]
        the end of the board is 3
        dice value could be 1-6

        input :
        3

        Explanation :
        111
        12
        21
        3

        output :
        4 (Total 4 ways to)
     */


    public static void main(String[] args) {

        int no = 200000;
        int count = 0;
//        count =  boardWaysA2(no,0,new int[no]);
        System.out.println(count);
        System.out.println("--------------------------------");
        count = boardWaysA3(no);
        System.out.println(count);
        System.out.println("--------------------------------");
        System.out.println(boardWaysA4(no));

    }


    // Recursive Approach
    public static int boardWaysA1(int no,int pointer){

        if (pointer == no)
            return 1;
        int count = 0;
        for (int idx = 1; idx <= 6; idx++){
            count += boardWaysA1(no,pointer+idx);
        }
        return count;
    }


    // Top Down (Memoization)
    public static int boardWaysA2(int no,int pointer,int []memory){
        if (pointer == no)
            return 1;


        if (memory[pointer] != 0)
            return memory[pointer];


        int count = 0;
        for (int idx = 1; idx <= 6; idx++){

            if (pointer+idx > no)
                continue;

            count += boardWaysA2(no,pointer+idx,memory);
        }
        memory[pointer] = count;
        return count;
    }

    // Bottom Up (Tabulation)
    public static int boardWaysA3(int no){
        int []storage = new int[no+7];

        for (int idx = storage.length-7; idx >= 1; idx--){

            boolean isAllCellsQualified = true;
            int tempCount = 0;
            for (int index = idx+1; index <= idx+6; index++){
                tempCount += storage[index];
                if (storage[index] == 0)
                    isAllCellsQualified = false;

            }

            if (!isAllCellsQualified)
                tempCount += 1;

            storage[idx] = tempCount;
        }
        return storage[1];
    }


    // Bottom Up (Space Efficient)
    public static int boardWaysA4(int no){
        int []memory = getPreFilledMemory();
        if(no < 7){
            return memory[no];
        }


        for (int count = 0; count < no-6;count++){
            int result = 0;
            for (int idx = memory.length-1; idx >= 1; idx--){
                result += memory[idx];
                memory[idx] = memory[idx-1];
            }
            result += memory[0];
            memory[0] = result;
        }

        return memory[0];
    }

    private static int[] getPreFilledMemory() {
        int []storage = new int[6];
        int sum = 1;
        storage[storage.length-1] = sum;
        for (int idx = storage.length-2; idx >= 0 ;idx--){
            sum += sum;
            storage[idx] = sum;
        }
        return storage;
    }


}
