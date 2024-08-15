package examples.interviewquestions.strings.easy;

public class FindFirstPalindromicString {

    public static void main(String[] args) {
        String[] words = {"abc","car","ada","racecar","cool"};

        System.out.println("first palindromic string -> "+findFirstPalindromic(words));
    }

    public static String findFirstPalindromic(String[] words){
        for (String word: words){
            String reversedWord = new StringBuilder(word).reverse().toString();
            if (word.equals(reversedWord)) {
                return word;
            }

        }
        return "";
    }
}
