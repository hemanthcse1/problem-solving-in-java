package examples.daily.july;

public class RemoveTripleConsecutiveCharacters {

    public static void main(String[] args) {
        RemoveTripleConsecutiveCharacters solution = new RemoveTripleConsecutiveCharacters();
        String input = "aaabaaaa";
        String output = solution.makeFancyString(input);
        System.out.println("Output: " + output);
    }

    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (i >= 2 && s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i - 2)) {
                continue;
            }
            result.append(s.charAt(i));
        }

        return result.toString();
    }
}
