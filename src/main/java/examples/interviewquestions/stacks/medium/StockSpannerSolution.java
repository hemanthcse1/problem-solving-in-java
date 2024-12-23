package examples.interviewquestions.stacks.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class StockSpannerSolution {

    static class StockSpanner {

        private Deque<int[]> stack;

        public StockSpanner() {
            stack = new ArrayDeque<>();
        }

        public int next(int price) {
            int span = 1;

            while (!stack.isEmpty() && price >= stack.peek()[0]) {
                span += stack.pop()[1];
            }

            stack.push(new int[]{price, span});
            return span;
        }
    }

    public static void main(String[] args){
        StockSpanner stockSpanner = new StockSpanner();


        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));


        StockSpanner stockSpanner2 = new StockSpanner();
        System.out.println(stockSpanner2.next(30));
        System.out.println(stockSpanner2.next(30));
        System.out.println(stockSpanner2.next(30));
        System.out.println(stockSpanner2.next(30));

        StockSpanner stockSpanner3 = new StockSpanner();
        System.out.println(stockSpanner3.next(10));
        System.out.println(stockSpanner3.next(20));
        System.out.println(stockSpanner3.next(30));
        System.out.println(stockSpanner3.next(25));
        System.out.println(stockSpanner3.next(35));
    }
}
