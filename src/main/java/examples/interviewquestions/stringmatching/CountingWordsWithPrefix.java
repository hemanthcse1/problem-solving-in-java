package examples.interviewquestions.stringmatching;

public class CountingWordsWithPrefix {
    public int countWordsWithPrefix(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountingWordsWithPrefix solution = new CountingWordsWithPrefix();
        String[] words1 = {"apple", "ape", "apricot", "banana", "apex"};
        String pref1 = "ap";
        System.out.println(solution.countWordsWithPrefix(words1, pref1));

        String[] words2 = {"hello", "world", "helium", "hero", "hermit"};
        String pref2 = "he";
        System.out.println(solution.countWordsWithPrefix(words2, pref2));
    }
}
