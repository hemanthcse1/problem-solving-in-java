package examples.interviewquestions.strings.medium;

public class AddSpacesToString {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder result = new StringBuilder();
        int spaceIndex = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (spaceIndex < spaces.length && i == spaces[spaceIndex]) {
                result.append(' ');
                spaceIndex++;
            }

            result.append(s.charAt(i));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        AddSpacesToString solution = new AddSpacesToString();

        System.out.println(solution.addSpaces("LeetcodeHelpsMeLearn", new int[]{8, 13, 15}));
        System.out.println(solution.addSpaces("icodeinpython", new int[]{1, 5, 7, 9}));
        System.out.println(solution.addSpaces("spacing", new int[]{0, 1, 2, 3, 4, 5, 6}));
    }
}
