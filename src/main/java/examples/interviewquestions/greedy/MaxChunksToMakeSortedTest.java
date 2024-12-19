package examples.interviewquestions.greedy;

public class MaxChunksToMakeSortedTest {

    public static int maxChunksToSorted(int[] arr) {
        int chunks = 0;
        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if(max == i) {
                chunks++;
            }
        }
        return chunks;
    }

    public static void main(String[] args) {

        int[] arr1 = {4, 3, 2, 1, 0};
        int result1 = maxChunksToSorted(arr1);
        System.out.println(result1);

        int[] arr2 = {1, 0, 2, 3, 4};
        int result2 = maxChunksToSorted(arr2);
        System.out.println(result2);
    }
}
