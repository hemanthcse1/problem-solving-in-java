package examples.interviewquestions.slidingwindow.medium;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {

    public  static int maxVowels(String s, int k) {
        int maxVowels = 0;
        int currentVowels = 0;
        for(int i = 0; i < s.length(); i++) {
            if(isVowel(s.charAt(i))) {
                currentVowels++;
            }
            if(i >= k && isVowel(s.charAt(i - k))) {
                currentVowels--;
            }
            maxVowels = Math.max(maxVowels, currentVowels);
        }
        return maxVowels;
    }

    private static boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        String s1 = "abciiidef";
        int k1 = 3;
        int result1 = maxVowels(s1, k1);
        System.out.println(result1);


        String s2 = "aeiou";
        int k2 = 2;
        int result2 = maxVowels(s2, k2);
        System.out.println(result2);

    }
}
