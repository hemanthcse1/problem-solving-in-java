package examples.interviewquestions.stacks.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class AsteroidCollisionSolution {

    public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int asteroid : asteroids){
            boolean destroyed = false;
            while(!stack.isEmpty() && asteroid < 0 && stack.peek() > 0){
                int top = stack.peek();
                if(top < -asteroid){
                    stack.pop();
                    continue;
                }
                else if(top == -asteroid){
                    stack.pop();
                }
                destroyed = true;
                break;
            }
            if(!destroyed){
                stack.push(asteroid);
            }
        }
        int[] result = new int[stack.size()];
        for(int i = result.length-1; i >=0; i--){
            result[i] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {

        int[] asteroids1 = {5,10,-5};
        System.out.println(Arrays.toString(asteroidCollision(asteroids1)));


        int[] asteroids2 = {8,-8};
        System.out.println(Arrays.toString(asteroidCollision(asteroids2)));
    }
}
