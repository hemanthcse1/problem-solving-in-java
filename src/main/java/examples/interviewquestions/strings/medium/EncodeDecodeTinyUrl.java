package examples.interviewquestions.strings.medium;

import java.util.HashMap;
import java.util.Random;

public class EncodeDecodeTinyUrl {
    private HashMap<String, String> urlMap;
    private HashMap<String, String> reverseMap;
    private static final String BASE_URL = "http://tinyurl.com/";
    private static final String CHAR_SET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private Random random;

    public EncodeDecodeTinyUrl() {
        urlMap = new HashMap<>();
        reverseMap = new HashMap<>();
        random = new Random();
    }

    public String encode(String longUrl) {
        if (reverseMap.containsKey(longUrl)) {
            return BASE_URL + reverseMap.get(longUrl);
        }

        String shortKey;
        do {
            shortKey = generateRandomKey();
        } while (urlMap.containsKey(shortKey));

        urlMap.put(shortKey, longUrl);
        reverseMap.put(longUrl, shortKey);
        return BASE_URL + shortKey;
    }

    public String decode(String shortUrl) {
        String shortKey = shortUrl.replace(BASE_URL, "");
        return urlMap.get(shortKey);
    }

    private String generateRandomKey() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(CHAR_SET.charAt(random.nextInt(CHAR_SET.length())));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        EncodeDecodeTinyUrl solution = new EncodeDecodeTinyUrl();

        String url = "https://leetcode.com/problems/design-tinyurl";
        String encoded = solution.encode(url);
        System.out.println("Encoded URL: " + encoded);

        String decoded = solution.decode(encoded);
        System.out.println("Decoded URL: " + decoded);
    }
}
