package examples.interviewquestions.strings.easy;

public class CountPrefixSuffixPairs {

    public static boolean isPrefixAndSuffix(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        if (len1 > len2) return false;

        boolean isPrefix = str2.substring(0, len1).equals(str1);
        boolean isSuffix = str2.substring(len2 - len1).equals(str1);

        return isPrefix && isSuffix;
    }

    public static int countPrefixSuffixPairs(String[] words) {
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String[] words1 = {"aba", "ababa", "abc", "abcd"};
        String[] words2 = {"a", "b", "c", "aa", "ab", "a"};
        String[] words3 = {"xyz", "xyzxyz", "x", "yz", "xyxyz"};

        System.out.println(countPrefixSuffixPairs(words1));
        System.out.println(countPrefixSuffixPairs(words2));
        System.out.println(countPrefixSuffixPairs(words3));
    }
}
