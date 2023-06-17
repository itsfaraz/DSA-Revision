package dsa.backtracking;

public class LetterTilePossibilities {

    // https://leetcode.com/problems/letter-tile-possibilities/
    public static void main(String[] args) {
        new LetterTilePossibilities().countTilePossibilities("AAB");

    }

    public void countTilePossibilities(String tiles){

        int []frequency = new int[26];
        fillFrequency(frequency,tiles);

        countTilePossibilities(frequency,"");

    }

    public void countTilePossibilities(int []freq,String ans){

        if (!ans.isEmpty())
            System.out.println(ans);

        for (int idx = 0; idx < freq.length;idx++){
            if (freq[idx] != 0){
                freq[idx] = freq[idx]-1;
                countTilePossibilities(freq,ans+((char)('A'+idx)));
                freq[idx] = freq[idx]+1;
            }
        }
    }

    private void fillFrequency(int[] frequency, String tiles) {
        for(char character : tiles.toCharArray()){
            int idx = character-'A';
            int charCount = frequency[idx];
            frequency[idx] = charCount+1;
        }
    }

}
