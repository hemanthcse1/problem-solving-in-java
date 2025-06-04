package examples.daily.june;

public class LexicographicalSubstringSelector {

    public static void main(String[] args) {
        LexicographicalSubstringSelector distributor = new LexicographicalSubstringSelector();
        String result = distributor.answerString("applebanana", 3);
        System.out.println("Answer string: " + result);
    }

    public String answerString(String word, int numFriends) {
        if (numFriends == 1)
            return word;
        String s = lastSubstring(word);
        int sz = word.length() - numFriends + 1;
        return s.substring(0, Math.min(s.length(), sz));
    }

    private String lastSubstring(String s) {
        int i = 0, j = 1, k = 0;
        while (j + k < s.length()) {
            if (s.charAt(i + k) == s.charAt(j + k)) {
                k++;
            } else if (s.charAt(i + k) > s.charAt(j + k)) {
                j = j + k + 1;
                k = 0;
            } else {
                i = Math.max(i + k + 1, j);
                j = i + 1;
                k = 0;
            }
        }
        return s.substring(i);
    }
}
