package examples.interviewquestions.arrays.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindRestaurant {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            indexMap.put(list1[i], i);
        }

        List<String> result = new ArrayList<>();
        int minIndexSum = Integer.MAX_VALUE;

        for (int j = 0; j < list2.length; j++) {
            String restaurant = list2[j];
            if (indexMap.containsKey(restaurant)) {
                int indexSum = j + indexMap.get(restaurant);

                if (indexSum < minIndexSum) {
                    result.clear();
                    result.add(restaurant);
                    minIndexSum = indexSum;
                } else if (indexSum == minIndexSum) {
                    result.add(restaurant);
                }
            }
        }

        return result.toArray(new String[result.size()]);
    }

    public static void main(String[] args) {
        FindRestaurant solution = new FindRestaurant();

        String[] list1_1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2_1 = {"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};
        String[] result1 = solution.findRestaurant(list1_1, list2_1);
        for (String res : result1) {
            System.out.println(res);
        }

        String[] list1_2 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2_2 = {"KFC","Shogun","Burger King"};
        String[] result2 = solution.findRestaurant(list1_2, list2_2);
        for (String res : result2) {
            System.out.println(res);

        }

        String[] list1_3 = {"happy","sad","good"};
        String[] list2_3 = {"sad","happy","good"};
        String[] result3 = solution.findRestaurant(list1_3, list2_3);
        for (String res : result3) {
            System.out.println(res);
        }
    }
}
