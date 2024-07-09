package roadmap.dsa.basic;

public class Strings {


    public static void main(String[] args) {
        Strings stringC = new Strings();
        System.out.println(stringC.isPalindrome("ffara"));

        System.out.println("Palindrome Substrings Count "+stringC.countPalindromicSubstrings("ffara"));
        System.out.println("Optimized Palindrome Substrings Count "+stringC.countPalindromicSubstringsV2("ffara"));
    }

    public int countPalindromicSubstrings(String string){
        int count = 0;
        for (int start =0; start < string.length();start++){
            for (int end = start; end < string.length();end++){
                String candidateString = getStringFromIdx(string,start,end);
                if (isPalindrome(candidateString))
                    count++;
            }
        }
        return count;
    }

    private String getStringFromIdx(String string, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int idx = start; idx <= end; idx++){
            sb.append(string.charAt(idx));
        }
        return sb.toString();
    }

    public boolean isPalindrome(String inputString){
        int start = 0;
        int end = inputString.length()-1;
        while(start < end){
            if (inputString.charAt(start) != inputString.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public int countPalindromicSubstringsV2(String string){
        if (string.isEmpty() || string.isBlank())
            return 0;

        int count = 0;
        for (int axis = 0; axis < string.length(); axis++){
            int orbit = 0;
            while (axis-orbit >= 0 && axis+orbit < string.length()){
                if (string.charAt(axis-orbit)==string.charAt(axis+orbit)){
                    count++;
                    orbit++;
                }else {
                    break;
                }
            }
        }


        for (double axis = 0.5; axis < string.length(); axis++){
            double orbit = 0.5;
            while (axis-orbit >= 0 && axis+orbit < string.length()){
                if (string.charAt((int)(axis-orbit))==string.charAt((int)(axis+orbit))){
                    count++;
                    orbit++;
                }else {
                    break;
                }
            }
        }

        return count;
    }


    public static void palindromePartitioning(String str){

    }


}
