package examples.daily;

import java.util.HashSet;
import java.util.Set;

public class MaximumNumberOfIntegers {

    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> bannedSet = new HashSet<>();
        for (int num : banned) {
            bannedSet.add(num);
        }

        int count = 0, currentSum = 0;

        for (int i = 1; i <= n; i++) {
            if (bannedSet.contains(i)) {
                continue;
            }
            if (currentSum + i > maxSum) {
                break;
            }
            currentSum += i;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        MaximumNumberOfIntegers solution = new MaximumNumberOfIntegers();

        int[] banned1 = {1, 6, 5};
        int n1 = 5, maxSum1 = 6;
        System.out.println(solution.maxCount(banned1, n1, maxSum1));

        int[] banned2 = {1, 2, 3, 4, 5, 6, 7};
        int n2 = 8, maxSum2 = 1;
        System.out.println(solution.maxCount(banned2, n2, maxSum2));
    }
}
