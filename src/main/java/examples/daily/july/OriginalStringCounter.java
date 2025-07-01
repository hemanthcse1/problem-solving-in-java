package examples.daily.july;

public class OriginalStringCounter {
    public int countPossibleOriginalStrings(String word) {
        int total = 1;
        int i = 0;
        while (i < word.length()) {
            int j = i;
            while (j < word.length() && word.charAt(j) == word.charAt(i)) {
                j++;
            }
            int groupLength = j - i;
            if (groupLength >= 2) {
                total += (groupLength - 1);
            }
            i = j;
        }
        return total;
    }

    public static void main(String[] args) {
        OriginalStringCounter counter = new OriginalStringCounter();
        System.out.println(counter.countPossibleOriginalStrings("abbcccc")); // 5
        System.out.println(counter.countPossibleOriginalStrings("abcd"));    // 1
        System.out.println(counter.countPossibleOriginalStrings("aaaa"));    // 4
    }
}
