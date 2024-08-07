package examples.hashtables;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
    public static int distributeCandies(int[] candyType) {
        int maxCandiesAliceCanEat = candyType.length / 2;

        Set<Integer> uniqueCandyTypes = new HashSet<>();
        for (int candy : candyType) {
            uniqueCandyTypes.add(candy);
        }

        return Math.min(uniqueCandyTypes.size(), maxCandiesAliceCanEat);
    }

    public static void main(String[] args) {
        int[] candyType1 = {1, 1, 2, 2, 3, 3};
        System.out.println(distributeCandies(candyType1));

        int[] candyType2 = {1, 1, 2, 3};
        System.out.println(distributeCandies(candyType2));
    }
}
