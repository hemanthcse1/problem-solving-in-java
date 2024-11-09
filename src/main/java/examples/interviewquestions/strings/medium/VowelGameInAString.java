package examples.interviewquestions.strings.medium;

public class VowelGameInAString {
    public boolean canAliceWin(String s) {
        int vowelCount = 0;
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowelCount++;
            }
        }
        return vowelCount > 0;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        VowelGameInAString game = new VowelGameInAString();

        System.out.println(game.canAliceWin("leetcoder"));
        System.out.println(game.canAliceWin("bbcd"));
    }
}
