package examples.problems.hashmaps;

import java.util.HashMap;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (map.get(num) == 1) {
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SingleNumber sn = new SingleNumber();
        int[] nums = {2, 2, 1};
        int result = sn.singleNumber(nums);
        System.out.println(result);
    }
}
