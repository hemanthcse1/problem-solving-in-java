package examples.interviewquestions.strings.easy;

public class CapitalizeTitle {
    public static String capitalizeTitle(String title) {
        String[] words = title.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.length() <= 2) {
                result.append(word.toLowerCase());
            } else {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase());
            }
            result.append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(capitalizeTitle("capiTalIze tHe titLe"));
        System.out.println(capitalizeTitle("First leTTeR of EACH Word"));
        System.out.println(capitalizeTitle("i lOve leetcode"));
    }
}
