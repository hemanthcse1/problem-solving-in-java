package examples.interviewquestions.strings.medium;

public class StringCompressionTree {

    public String compress(String word) {
        StringBuilder comp = new StringBuilder();
        int n = word.length();
        int i = 0;

        while (i < n) {
            char currentChar = word.charAt(i);
            int count = 0;

            while (i < n && word.charAt(i) == currentChar && count < 9) {
                count++;
                i++;
            }

            comp.append(count).append(currentChar);
        }

        return comp.toString();
    }

    public static void main(String[] args) {
        StringCompressionTree solution = new StringCompressionTree();

        String word1 = "abcde";
        System.out.println(solution.compress(word1));

        String word2 = "aaaaaaaaaaaaaabb";
        System.out.println(solution.compress(word2));
    }
}
