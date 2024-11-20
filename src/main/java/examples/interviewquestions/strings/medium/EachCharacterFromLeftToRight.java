package examples.interviewquestions.strings.medium;

public class EachCharacterFromLeftToRight {

    public int takeCharacters(String s, int k) {
        if (k == 0) return 0;

        int[] count = new int[3];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        if (count[0] < k || count[1] < k || count[2] < k) return -1;

        int requiredA = count[0] - k;
        int requiredB = count[1] - k;
        int requiredC = count[2] - k;

        int[] window = new int[3];
        int maxWindowSize = 0, left = 0;

        for (int right = 0; right < s.length(); right++) {
            window[s.charAt(right) - 'a']++;
            while (window[0] > requiredA || window[1] > requiredB || window[2] > requiredC) {
                window[s.charAt(left) - 'a']--;
                left++;
            }
            maxWindowSize = Math.max(maxWindowSize, right - left + 1);
        }

        return s.length() - maxWindowSize;
    }

    public static void main(String[] args) {
        EachCharacterFromLeftToRight solution = new EachCharacterFromLeftToRight();

        String s1 = "aabaaaacaabc";
        int k1 = 2;
        System.out.println(solution.takeCharacters(s1, k1));

        String s2 = "a";
        int k2 = 1;
        System.out.println(solution.takeCharacters(s2, k2));
    }
}
