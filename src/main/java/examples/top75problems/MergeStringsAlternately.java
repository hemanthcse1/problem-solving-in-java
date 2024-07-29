package examples.top75problems;

public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder merged = new StringBuilder();
        int len1 = word1.length();
        int len2 = word2.length();
        int maxLen = Math.max(len1, len2);

        for (int i = 0; i < maxLen; i++) {
            if (i < len1) {
                merged.append(word1.charAt(i));
            }
            if (i < len2) {
                merged.append(word2.charAt(i));
            }
        }

        return merged.toString();
    }

    public static void main(String[] args) {
        MergeStringsAlternately solution = new MergeStringsAlternately();
        String word1 = "abc";
        String word2 = "pqr";
        System.out.println(solution.mergeAlternately(word1, word2));
    }
}
