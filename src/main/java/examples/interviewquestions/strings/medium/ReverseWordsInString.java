package examples.interviewquestions.strings.medium;

public class ReverseWordsInString {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");

        int left = 0, right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }

        return String.join(" ", words);
    }

    public static void main(String[] args) {
        ReverseWordsInString solution = new ReverseWordsInString();

        System.out.println("Result for 'the sky is blue': '" + solution.reverseWords("the sky is blue") + "'");
        System.out.println("Result for '  hello world  ': '" + solution.reverseWords("  hello world  ") + "'");
        System.out.println("Result for 'a good   example': '" + solution.reverseWords("a good   example") + "'");
    }
}
