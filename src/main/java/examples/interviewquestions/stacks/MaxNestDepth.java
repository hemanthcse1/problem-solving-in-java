package examples.interviewquestions.stacks;

import java.util.Stack;

public class MaxNestDepth {

    public static void main(String[] args) {
        // String s = "(1+(2*3)+((8)/4))+1";
        String s = "(1)+((2))+(((3)))";

        System.out.println(maximumNestedDepthOfParentheses(s));

    }

    public static int maximumNestedDepthOfParentheses(String s){
        int maxDepth = 0;
        Stack<Character> parenthesesStack = new Stack<>();

        for (char ch : s.toCharArray()){
            if (ch == '('){
                parenthesesStack.push(ch);
                maxDepth = Math.max(parenthesesStack.size(),maxDepth);
            }else if (ch == ')'){
                parenthesesStack.pop();
            }
        }
        return maxDepth;
    }
}
