package examples.interviewquestions.strings.easy;

public class CountSubstringsKConstraint {

    public int countSubstrings(String s, int k) {
        return countSubstringsWithK(s, k, '0') + countSubstringsWithK(s, k, '1');
    }

    private int countSubstringsWithK(String s, int k, char target) {
        int n = s.length();
        int count = 0;
        int left = 0;
        int targetCount = 0;

        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == target) {
                targetCount++;
            }

            while (targetCount > k) {
                if (s.charAt(left) == target) {
                    targetCount--;
                }
                left++;
            }
            count += right - left + 1;
        }

        return count;
    }

    public static void main(String[] args) {
        CountSubstringsKConstraint solution = new CountSubstringsKConstraint();

        System.out.println(solution.countSubstrings("001101", 1));
        System.out.println(solution.countSubstrings("10101", 2));
        System.out.println(solution.countSubstrings("1111", 2));
    }
}
