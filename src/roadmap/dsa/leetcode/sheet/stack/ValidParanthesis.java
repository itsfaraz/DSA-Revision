package roadmap.dsa.leetcode.sheet.stack;

import java.util.HashMap;
import java.util.Stack;

public class ValidParanthesis {
    public static void main(String[] args) {
        String input = "([]";
        System.out.println(isValid(input));
        System.out.println(isValidSO(input));
    }

    public static boolean isValid(String input){
        Stack<Character> stack = new Stack<>();
        for (int idx = 0; idx < input.length(); idx++){
            char c = input.charAt(idx);
            boolean isOpening = (c == '(' || c == '[' || c == '{');
            if (isOpening){
                stack.push(c);
                continue;
            }
            if (stack.isEmpty())
                return false;
            char pop = stack.pop();
            switch (pop){
                case '(':
                    if (c != ')')
                        return false;
                    break;
                case '[':
                    if (c != ']')
                        return false;
                    break;
                case '{':
                    if (c != '}')
                        return false;
                    break;
                default:
                    break;
            }
        }
        return stack.isEmpty();
    }

    // Space Efficient
    public static boolean isValidSO(String input){
        HashMap<Character,Character> map = new HashMap<>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');
        int top = -1;
        int doubleCheckCount = 0;
        for (int curr = 0; curr < input.length(); curr++){
            char c = input.charAt(curr);
            if (!map.containsKey(c)){ // opening bracket
                doubleCheckCount++;
                continue;
            }

            top = getTop(input,curr-1,map);
            if (top == -1)
                return false;
            if (map.containsKey(c)){
                if (map.get(c) != input.charAt(top)){
                    return false;
                }
            }
            doubleCheckCount--;


        }
        if (!map.containsKey(input.charAt(input.length()-1)) && top != -1)
            return false;

        if (doubleCheckCount != 0)
            return false;
        return top != -1;
    }

    private static int getTop(String input, int index,HashMap<Character,Character> map) {
        int right = 0;
        while (index >= 0){
            if (map.containsKey(input.charAt(index))){
                right++;
            }else{
                right--;
            }
            if (right == -1)
                return index;
            index--;
        }
        return -1;
    }

}
