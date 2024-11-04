package examples.interviewquestions.strings.medium;

import java.util.ArrayList;
import java.util.List;

public class CamelCaseMatching {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();
        for (String query : queries) {
            result.add(isMatch(query, pattern));
        }
        return result;
    }

    private boolean isMatch(String query, String pattern) {
        int patternIndex = 0;

        for (int i = 0; i < query.length(); i++) {
            char queryChar = query.charAt(i);

            if (patternIndex < pattern.length() && queryChar == pattern.charAt(patternIndex)) {
                patternIndex++;
            } else if (Character.isUpperCase(queryChar)) {
                return false;
            }
        }

        return patternIndex == pattern.length();
    }

    public static void main(String[] args) {
        CamelCaseMatching camelCase = new CamelCaseMatching();
        String[] queries1 = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        String pattern1 = "FB";
        System.out.println(camelCase.camelMatch(queries1, pattern1));

        String[] queries2 = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        String pattern2 = "FoBa";
        System.out.println(camelCase.camelMatch(queries2, pattern2));

    }
}
