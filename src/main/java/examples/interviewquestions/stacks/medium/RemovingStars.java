package examples.interviewquestions.stacks.medium;

public class RemovingStars {
    public String removeStars(String s) {
        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                result.deleteCharAt(result.length() - 1);
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        RemovingStars remover = new RemovingStars();

        String s = "leet**cod*e";
        String result = remover.removeStars(s);
        System.out.println(result);
    }
}
