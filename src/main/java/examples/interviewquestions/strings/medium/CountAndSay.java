package examples.interviewquestions.strings.medium;

public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String prev = countAndSay(n - 1);

        StringBuilder result = new StringBuilder();

        int count = 1;
        char currentChar = prev.charAt(0);

        for (int i = 1; i < prev.length(); i++) {
            if (prev.charAt(i) == currentChar) {
                count++;
            } else {
                result.append(count).append(currentChar);
                count = 1;
                currentChar = prev.charAt(i);
            }
        }

        result.append(count).append(currentChar);

        return result.toString();
    }

    public static void main(String[] args) {
        CountAndSay solution = new CountAndSay();

        System.out.println(solution.countAndSay(1));
        System.out.println(solution.countAndSay(4));
        System.out.println(solution.countAndSay(5));
    }
}
