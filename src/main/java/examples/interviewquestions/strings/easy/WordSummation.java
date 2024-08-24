package examples.interviewquestions.strings.easy;

public class WordSummation {
    public static void main(String[] args) {
        String firstWord = "acb";
        String secondWord = "cba";
        String targetWord = "cdb";

        System.out.println(isSumEqual(firstWord, secondWord, targetWord));
    }

    public static boolean isSumEqual(String firstWord, String secondWord,
                                     String targetWord) {
        int firstValue = convertToNumber(firstWord);
        int secondValue = convertToNumber(secondWord);
        int targetValue = convertToNumber(targetWord);

        return (firstValue + secondValue) == targetValue;
    }

    private static int convertToNumber(String word) {
        StringBuilder number = new StringBuilder();

        for (char c : word.toCharArray()) {
            number.append(c - 'a');
        }

        return Integer.parseInt(number.toString());
    }
}
