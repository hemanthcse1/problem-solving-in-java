package examples.daily.july;

import java.util.HashSet;
import java.util.Set;

public class BitwiseORsOfSubarrays {

    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> prev = new HashSet<>();

        for (int num : arr) {
            Set<Integer> curr = new HashSet<>();
            curr.add(num);

            for (int val : prev) {
                curr.add(val | num);
            }

            result.addAll(curr);
            prev = curr;
        }

        return result.size();
    }

    public static void main(String[] args) {
        BitwiseORsOfSubarrays solver = new BitwiseORsOfSubarrays();
        System.out.println(solver.subarrayBitwiseORs(new int[]{1, 1, 2})); // Output: 3
        System.out.println(solver.subarrayBitwiseORs(new int[]{1, 2, 4})); // Output: 6
    }
}
