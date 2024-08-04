package examples.interviewquestions.strings;

import java.util.HashMap;
import java.util.Map;

public class DecodeMessage {
    public static void main(String[] args) {
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        String decodedMessage = decodeMessage(key, message);
        System.out.println("Decoded Message: " + decodedMessage);
    }

    public static String decodeMessage(String key, String message) {
        Map<Character, Character> substitutionTable = new HashMap<>();
        char currentChar = 'a';

        for (char ch : key.toCharArray()) {
            if (ch != ' ' && !substitutionTable.containsKey(ch)) {
                substitutionTable.put(ch, currentChar);
                currentChar++;
            }
        }

        StringBuilder decodedMessage = new StringBuilder();
        for (char ch : message.toCharArray()) {
            if (ch == ' ') {
                decodedMessage.append(ch);
            } else {
                decodedMessage.append(substitutionTable.get(ch));
            }
        }

        return decodedMessage.toString();
    }
}
