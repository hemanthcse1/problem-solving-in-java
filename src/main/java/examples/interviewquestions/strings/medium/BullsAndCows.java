package examples.interviewquestions.strings.medium;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int[] secretCount = new int[10];
        int[] guessCount = new int[10];

        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if (s == g) {
                bulls++;
            } else {
                secretCount[s - '0']++;
                guessCount[g - '0']++;
            }
        }

        for (int i = 0; i < 10; i++) {
            cows += Math.min(secretCount[i], guessCount[i]);
        }

        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        BullsAndCows solution = new BullsAndCows();
        String secret1 = "1807";
        String guess1 = "7810";
        System.out.println(solution.getHint(secret1, guess1));

        String secret2 = "1123";
        String guess2 = "0111";
        System.out.println(solution.getHint(secret2, guess2));
    }
}
