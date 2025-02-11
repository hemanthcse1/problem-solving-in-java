package examples.interviewquestions.linkedlists.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AuthenticationManager {

    private final int timeToLive;
    private final Map<String, Integer> tokenMap;
    private final TreeMap<Integer, String> expiryMap;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.tokenMap = new HashMap<>();
        this.expiryMap = new TreeMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        int expiryTime = currentTime + timeToLive;
        tokenMap.put(tokenId, expiryTime);
        expiryMap.put(expiryTime, tokenId);
    }

    public void renew(String tokenId, int currentTime) {
        if (!tokenMap.containsKey(tokenId)) return;

        int expiryTime = tokenMap.get(tokenId);
        if (expiryTime <= currentTime) {
            tokenMap.remove(tokenId);
            expiryMap.remove(expiryTime);
            return;
        }

        expiryMap.remove(expiryTime);
        int newExpiryTime = currentTime + timeToLive;
        tokenMap.put(tokenId, newExpiryTime);
        expiryMap.put(newExpiryTime, tokenId);
    }

    public int countUnexpiredTokens(int currentTime) {
        while (!expiryMap.isEmpty() && expiryMap.firstKey() <= currentTime) {
            tokenMap.remove(expiryMap.pollFirstEntry().getValue());
        }
        return tokenMap.size();
    }

    public static void main(String[] args) {
        AuthenticationManager authenticationManager = new AuthenticationManager(5);

        authenticationManager.renew("aaa", 1);
        authenticationManager.generate("aaa", 2);
        System.out.println(authenticationManager.countUnexpiredTokens(6));
        authenticationManager.generate("bbb", 7);
        authenticationManager.renew("aaa", 8);
        authenticationManager.renew("bbb", 10);
        System.out.println(authenticationManager.countUnexpiredTokens(15));
    }
}
