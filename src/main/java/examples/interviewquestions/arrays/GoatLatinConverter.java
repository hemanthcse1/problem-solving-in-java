package examples.interviewquestions.arrays;

public class GoatLatinConverter {
    public static String toGoatLatin(String sentence) {
        String vowels = "aeiouAEIOU";
        String[] words = sentence.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder goatWord = new StringBuilder();

            if (vowels.indexOf(word.charAt(0)) != -1) {
                goatWord.append(word).append("ma");
            } else {
                goatWord.append(word.substring(1)).append(word.charAt(0)).append("ma");
            }

            for (int j = 0; j <= i; j++) {
                goatWord.append("a");
            }

            if (i != 0) {
                result.append(" ");
            }
            result.append(goatWord);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String sentence = "I speak Goat Latin";
        String goatLatin = toGoatLatin(sentence);
        System.out.println(goatLatin);
    }
}
