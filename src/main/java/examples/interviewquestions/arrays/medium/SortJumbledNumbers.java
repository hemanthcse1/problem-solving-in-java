package examples.interviewquestions.arrays.medium;

import java.util.Arrays;

public class SortJumbledNumbers {

    public int[] sortJumbled(int[] mapping, int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .sorted((a, b) -> {
                    long mappedA = getMappedValue(a, mapping);
                    long mappedB = getMappedValue(b, mapping);
                    if (mappedA == mappedB) {
                        return 0;
                    }
                    return Long.compare(mappedA, mappedB);
                })
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private long getMappedValue(int num, int[] mapping) {
        StringBuilder mapped = new StringBuilder();
        if (num == 0) {
            return mapping[0];
        }
        while (num > 0) {
            int digit = num % 10;
            mapped.append(mapping[digit]);
            num /= 10;
        }
        return Long.parseLong(mapped.reverse().toString());
    }

    public static void main(String[] args) {
        SortJumbledNumbers solution = new SortJumbledNumbers();
        int[] mapping1 = {8, 9, 4, 0, 2, 1, 3, 5, 7, 6};
        int[] nums1 = {991, 338, 38};
        System.out.println(Arrays.toString(solution.sortJumbled(mapping1, nums1)));

        int[] mapping2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] nums2 = {789, 456, 123};
        System.out.println(Arrays.toString(solution.sortJumbled(mapping2, nums2)));
    }
}
