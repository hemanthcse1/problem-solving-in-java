package examples.interviewquestions.strings.medium;

public class MaximumValueAfterInsertion {
    public String maxValue(String n, int x) {
        StringBuilder result = new StringBuilder();
        char xChar = (char) (x + '0');

        if (n.charAt(0) == '-') {
            result.append('-');
            int i = 1;
            while (i < n.length() && n.charAt(i) <= xChar) {
                result.append(n.charAt(i));
                i++;
            }
            result.append(xChar);
            result.append(n.substring(i));
        } else {
            int i = 0;
            while (i < n.length() && n.charAt(i) >= xChar) {
                result.append(n.charAt(i));
                i++;
            }
            result.append(xChar);
            result.append(n.substring(i));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        MaximumValueAfterInsertion solution = new MaximumValueAfterInsertion();

        System.out.println(solution.maxValue("99", 9));   // Output: "999"
        System.out.println(solution.maxValue("-13", 2));  // Output: "-123"
        System.out.println(solution.maxValue("73", 6));   // Output: "763"
        System.out.println(solution.maxValue("-55", 2));  // Output: "-255"
    }
}
