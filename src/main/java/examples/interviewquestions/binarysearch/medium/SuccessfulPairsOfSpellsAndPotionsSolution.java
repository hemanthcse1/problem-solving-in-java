package examples.interviewquestions.binarysearch.medium;

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotionsSolution {

    static class Solution {
        public int[] successfulPairs(int[] spells, int[] potions, long success) {
            Arrays.sort(potions);
            int m = potions.length;
            int[] result = new int[spells.length];

            for(int i = 0; i < spells.length; i++) {
                long spell = spells[i];
                if(spell == 0) {
                    result[i] = 0;
                    continue;
                }
                long required = (success + spell - 1) / spell;
                int index = lowerBound(potions, required);
                result[i] = m - index;
            }
            return result;
        }

        private int lowerBound(int[] arr, long target) {
            int left = 0, right = arr.length;
            while(left < right) {
                int mid = left + (right - left) / 2;
                if(arr[mid] < target) {
                    left = mid + 1;
                }
                else {
                    right = mid;
                }
            }
            return left;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();


        int[] spells1 = {5,1,3};
        int[] potions1 = {1,2,3,4,5};
        long success1 = 7;
        System.out.println(Arrays.toString(solution.successfulPairs(spells1, potions1, success1)));


        int[] spells2 = {3,1,2};
        int[] potions2 = {8,5,8};
        long success2 = 16;
        System.out.println(Arrays.toString(solution.successfulPairs(spells2, potions2, success2)));

    }
}
