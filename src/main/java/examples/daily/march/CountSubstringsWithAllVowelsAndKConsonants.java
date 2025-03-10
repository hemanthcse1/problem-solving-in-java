package examples.daily.march;

import java.util.*;

public class CountSubstringsWithAllVowelsAndKConsonants {

    public long countSubstringsAllVowelsKConsonants(String word, int k) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        int n = word.length();
        int[] p = new int[n+1];
        for (int i = 0; i < n; i++) {
            p[i+1] = p[i] + (vowels.contains(word.charAt(i)) ? 0 : 1);
        }
        Map<Integer, List<Integer>> positions = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            positions.computeIfAbsent(p[i], x -> new ArrayList<>()).add(i);
        }
        int[] lastOcc = new int[5];
        Arrays.fill(lastOcc, -1);
        long ans = 0;
        for (int j = 0; j < n; j++) {
            char c = word.charAt(j);
            if (c == 'a') lastOcc[0] = j;
            else if (c == 'e') lastOcc[1] = j;
            else if (c == 'i') lastOcc[2] = j;
            else if (c == 'o') lastOcc[3] = j;
            else if (c == 'u') lastOcc[4] = j;
            for (int x : lastOcc) if (x == -1) { c = 0; break; }
            if (c == 0) continue;
            int L = Integer.MAX_VALUE;
            for (int x : lastOcc) L = Math.min(L, x);
            int need = p[j+1] - k;
            if (need < 0 || need > n) continue;
            List<Integer> idxList = positions.getOrDefault(need, Collections.emptyList());
            int pos = Collections.binarySearch(idxList, L+1);
            if (pos < 0) pos = -pos - 1;
            ans += pos;
        }
        return ans;
    }

    public static void main(String[] args) {
        CountSubstringsWithAllVowelsAndKConsonants solver = new CountSubstringsWithAllVowelsAndKConsonants();
        System.out.println(solver.countSubstringsAllVowelsKConsonants("aeioqq", 1));
        System.out.println(solver.countSubstringsAllVowelsKConsonants("aeiou", 0));
        System.out.println(solver.countSubstringsAllVowelsKConsonants("ieaouqqieaouqq", 1));
    }
}
