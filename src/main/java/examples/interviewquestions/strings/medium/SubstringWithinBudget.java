package examples.interviewquestions.strings.medium;

public class SubstringWithinBudget {
    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0, right = 0;
        int currentCost = 0;
        int maxLength = 0;

        while (right < s.length()) {
            currentCost += Math.abs(s.charAt(right) - t.charAt(right));

            while (currentCost > maxCost) {
                currentCost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        SubstringWithinBudget withinBudget = new SubstringWithinBudget();
        System.out.println(withinBudget.equalSubstring("abcd", "bcdf", 3));
        System.out.println(withinBudget.equalSubstring("abcd", "cdef", 3));
        System.out.println(withinBudget.equalSubstring("abcd", "acde", 0));
    }
}
