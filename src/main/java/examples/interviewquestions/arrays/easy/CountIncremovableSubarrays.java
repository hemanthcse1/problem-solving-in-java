package examples.interviewquestions.arrays.easy;

public class CountIncremovableSubarrays {
    public int countIncremovableSubarrays(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                boolean valid = true;

                if (i > 0 && j < n - 1 && nums[i - 1] >= nums[j + 1]) {
                    valid = false;
                }

                if (i > 1) {
                    for (int k = 1; k < i; k++) {
                        if (nums[k - 1] >= nums[k]) {
                            valid = false;
                            break;
                        }
                    }
                }

                if (j < n - 1) {
                    for (int k = j + 2; k < n; k++) {
                        if (nums[k - 1] >= nums[k]) {
                            valid = false;
                            break;
                        }
                    }
                }

                if (valid) count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountIncremovableSubarrays solution = new CountIncremovableSubarrays();
        System.out.println(solution.countIncremovableSubarrays(new int[]{1,2,3,4}));
        System.out.println(solution.countIncremovableSubarrays(new int[]{6,5,7,8}));
        System.out.println(solution.countIncremovableSubarrays(new int[]{8,7,6,6}));
    }
}
