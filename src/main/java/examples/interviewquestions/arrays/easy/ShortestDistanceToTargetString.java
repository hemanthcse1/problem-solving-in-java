package examples.interviewquestions.arrays.easy;

public class ShortestDistanceToTargetString {

    public static int shortestDistance(String[] words, String target, int startIndex) {
        int n = words.length;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int clockwiseDistance = Math.abs(i - startIndex);
                int counterClockwiseDistance = n - clockwiseDistance;

                int distance = Math.min(clockwiseDistance, counterClockwiseDistance);

                minDistance = Math.min(minDistance, distance);
            }
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    public static void main(String[] args) {
        String[] words1 = {"hello", "i", "am", "leetcode", "hello"};
        String target1 = "hello";
        int startIndex1 = 1;
        System.out.println(shortestDistance(words1, target1, startIndex1));

        String[] words2 = {"a", "b", "leetcode"};
        String target2 = "leetcode";
        int startIndex2 = 0;
        System.out.println(shortestDistance(words2, target2, startIndex2));

        String[] words3 = {"i", "eat", "leetcode"};
        String target3 = "ate";
        int startIndex3 = 0;
        System.out.println(shortestDistance(words3, target3, startIndex3));
    }
}
