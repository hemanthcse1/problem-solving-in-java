package examples.daily.february;

import java.util.HashMap;
import java.util.Map;

public class TupleWithSameProduct {

    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> productCount = new HashMap<>();
        int count = 0;


        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];


                if (productCount.containsKey(product)) {
                    count += 8 * productCount.get(product);
                }

                productCount.put(product, productCount.getOrDefault(product, 0) + 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        TupleWithSameProduct solution = new TupleWithSameProduct();
        System.out.println(solution.tupleSameProduct(new int[]{2,3,4,6})); //  8
        System.out.println(solution.tupleSameProduct(new int[]{1,2,4,5,10})); //  16
    }
}
