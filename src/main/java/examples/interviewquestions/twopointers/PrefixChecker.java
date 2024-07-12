package examples.interviewquestions.twopointers;

public class PrefixChecker {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWord)) {
                return i + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        PrefixChecker checker = new PrefixChecker();
        String sentence = "i love eating burger";
        String searchWord = "burg";
        int result = checker.isPrefixOfWord(sentence, searchWord);
        System.out.println("Result: " + result);
    }
}
