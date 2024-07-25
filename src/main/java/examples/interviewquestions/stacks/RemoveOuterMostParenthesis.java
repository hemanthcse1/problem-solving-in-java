package examples.interviewquestions.stacks;

import java.util.Stack;

public class RemoveOuterMostParenthesis {

    public static void main(String[] args) {
        String s = "(()())(())";
        System.out.println("Result "+outerMostParentheses(s));
    }

    public static String outerMostParentheses(String s){
        StringBuilder result = new StringBuilder();
        Stack<Character> parenthesesStack = new Stack<>();

        for (char ch : s.toCharArray()){
            if (ch == '('){
                if (!parenthesesStack.isEmpty()){
                    result.append(ch);
                }
                parenthesesStack.push(ch);
            }else if (ch == ')'){
               parenthesesStack.pop();
               if (!parenthesesStack.isEmpty()){
                   result.append(ch);
               }
            }
        }
        return result.toString();
    }
}
