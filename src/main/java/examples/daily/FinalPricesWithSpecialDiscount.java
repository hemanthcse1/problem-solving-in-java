package examples.daily;

public class FinalPricesWithSpecialDiscount {

    public static int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek() > prices[i]){
                stack.pop();
            }
            answer[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peek();
            stack.push(prices[i]);
        }
        return answer;
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if(i < array.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {

        int[] prices1 = {8, 4, 6, 2, 3};
        int[] result1 = finalPrices(prices1);
        printArray(result1);

        int[] prices2 = {1, 2, 3, 4, 5};
        int[] result2 = finalPrices(prices2);
        printArray(result2);

    }
}
