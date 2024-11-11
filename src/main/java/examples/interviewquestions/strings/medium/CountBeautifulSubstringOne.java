package examples.interviewquestions.strings.medium;

public class CountBeautifulSubstringOne {
    public int countBeautifulSubstrings(String s, int k) {
        int beautifulCount = 0;

        for (int start = 0; start < s.length(); start++) {
            int vowels = 0;
            int consonants = 0;

            for (int end = start; end < s.length(); end++) {
                char c = s.charAt(end);
                if (isVowel(c)) {
                    vowels++;
                } else {
                    consonants++;
                }

                if (vowels == consonants && (vowels * consonants) % k == 0) {
                    beautifulCount++;
                }
            }
        }

        return beautifulCount;
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }

    public static void main(String[] args) {
        CountBeautifulSubstringOne solution = new CountBeautifulSubstringOne();
        System.out.println(solution.countBeautifulSubstrings("baeyh", 2));
        System.out.println(solution.countBeautifulSubstrings("abba", 1));
        System.out.println(solution.countBeautifulSubstrings("bcdf", 1));
    }
}
