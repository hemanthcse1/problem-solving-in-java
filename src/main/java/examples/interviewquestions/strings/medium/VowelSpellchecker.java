package examples.interviewquestions.strings.medium;

import java.util.*;

public class VowelSpellchecker {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactWords = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> caseInsensitiveMap = new HashMap<>();
        Map<String, String> vowelErrorMap = new HashMap<>();

        for (String word : wordlist) {
            caseInsensitiveMap.putIfAbsent(word.toLowerCase(), word);

            String vowelKey = toVowelErrorKey(word);
            vowelErrorMap.putIfAbsent(vowelKey, word);
        }

        String[] result = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];

            if (exactWords.contains(query)) {
                result[i] = query;
            } else if (caseInsensitiveMap.containsKey(query.toLowerCase())) {
                result[i] = caseInsensitiveMap.get(query.toLowerCase());
            } else if (vowelErrorMap.containsKey(toVowelErrorKey(query))) {
                result[i] = vowelErrorMap.get(toVowelErrorKey(query));
            } else {
                result[i] = "";
            }
        }

        return result;
    }

    private String toVowelErrorKey(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toLowerCase().toCharArray()) {
            if (isVowel(c)) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        VowelSpellchecker checker = new VowelSpellchecker();

        String[] wordlist = {"KiTe","kite","hare","Hare"};
        String[] queries = {"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"};

        System.out.println(Arrays.toString(checker.spellchecker(wordlist, queries)));
    }
}
