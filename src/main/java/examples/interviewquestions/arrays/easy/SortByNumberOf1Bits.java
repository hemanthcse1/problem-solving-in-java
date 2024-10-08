package examples.interviewquestions.arrays.easy;

import java.util.Arrays;

public class SortByNumberOf1Bits {
    public int[] sortByBits(int[] arr) {

        Integer[] array = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(array, (a, b) -> {
            int bitCountA = Integer.bitCount(a);
            int bitCountB = Integer.bitCount(b);
            if (bitCountA != bitCountB) {
                return bitCountA - bitCountB;
            } else {
                return a - b;
            }
        });

        return Arrays.stream(array).mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        SortByNumberOf1Bits solver = new SortByNumberOf1Bits();
        System.out.println(Arrays.toString(solver.sortByBits(new int[]{0,1,2,3,4,5,6,7,8})));
        System.out.println(Arrays.toString(solver.sortByBits(new int[]{1024,512,256,128,64,32,16,8,4,2,1})));
    }
}
