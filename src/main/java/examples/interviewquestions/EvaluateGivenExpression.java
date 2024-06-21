package examples.interviewquestions;

import java.util.Stack;

public class EvaluateGivenExpression {

    public static void main(String[] args){

        // String expression = "(a+b) * (a-c)";
        // String expression = "((a+b) * c";
        String expression = "(a+b)";
        System.out.println("is Expression valid -> "+isExpressionValid(expression));

    }

    public static boolean isExpressionValid(String expression){
        Stack<Character> exStack = new Stack<>();

        char[] exCharacters = expression.toCharArray();
        for (int i = 0; i< exCharacters.length; i++){
            char symbol = exCharacters[i];
            if (symbol == '(' || symbol == '{' || symbol == '['){
                exStack.push(symbol);
            }else if (symbol == ')' || symbol == '}' || symbol == ']'){
                exStack.pop();
            }
        }
        if (!exStack.isEmpty()){
            return false;
        }
        return true;
    }
}
