package examples.interviewquestions.strings.medium;

import java.util.HashSet;
import java.util.Set;

public class ReportSpamMessage {

    public boolean isSpam(String[] message, String[] bannedWords) {
        Set<String> bannedSet = new HashSet<>();
        for (String word : bannedWords) {
            bannedSet.add(word);
        }

        int matchCount = 0;
        for (String word : message) {
            if (bannedSet.contains(word)) {
                matchCount++;
                if (matchCount >= 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ReportSpamMessage detector = new ReportSpamMessage();

        String[] message1 = {"hello", "world", "leetcode"};
        String[] bannedWords1 = {"world", "hello"};
        System.out.println(detector.isSpam(message1, bannedWords1));

        String[] message2 = {"hello", "programming", "fun"};
        String[] bannedWords2 = {"world", "programming", "leetcode"};
        System.out.println(detector.isSpam(message2, bannedWords2));
    }
}
