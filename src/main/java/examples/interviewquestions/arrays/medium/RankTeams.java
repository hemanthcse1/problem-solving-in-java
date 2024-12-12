package examples.interviewquestions.arrays.medium;

import java.util.*;

public class RankTeams {

    public static String rankTeams(String[] votes) {
        int n = votes[0].length();
        Map<Character,int[]> map = new HashMap<>();
        for (char c : votes[0].toCharArray()) map.put(c, new int[n]);

        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                map.get(vote.charAt(i))[i]++;
            }
        }

        List<Character> teams = new ArrayList<>(map.keySet());
        Collections.sort(teams, (a, b) -> {
            int[] arrA = map.get(a), arrB = map.get(b);
            for (int i = 0; i < n; i++) {
                if (arrA[i] != arrB[i]) return arrB[i] - arrA[i];
            }
            return a - b;
        });

        StringBuilder sb = new StringBuilder();
        for (char c : teams) sb.append(c);
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] votes = {"ABC","ACB","ABC","ACB","ACB"};
        System.out.println(rankTeams(votes));
    }
}
