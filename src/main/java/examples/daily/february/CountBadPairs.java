package examples.daily.february;

import java.util.HashMap;

public class CountBadPairs {

    public static long badPairs(int[] nums){
        int n = nums.length;
        long totalPairs = (long)  n* (n-1)/2;

        HashMap<Integer,Integer> freqMap = new HashMap<>();
        int goodPairs = 0;

        for (int i = 0; i< n; i++){
            int key = i - nums[i];

            if (freqMap.containsKey(key)){
                goodPairs += freqMap.get(key);
            }

            freqMap.put(key, freqMap.getOrDefault(key,0)+1);
        }
        return totalPairs - goodPairs;
    }

    public static void main(String[] args){

        int[] nums = {4,1,3,3};
        System.out.println(badPairs(nums));

        int[] nums2 = {1,2,3,4,5};
        System.out.println(badPairs(nums2));
    }
}
