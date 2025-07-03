package examples.daily.july;

public class KthCharacterInStringGame {
    public static void main(String[] args) {
        KthCharacterInStringGame finder = new KthCharacterInStringGame();

        int k = 10;
        char result = finder.kthCharacter(k);

        System.out.println("The " + k + "-th character in the generated string is: " + result);
    }

    public char kthCharacter(int k) {
        return findK(k, 'a');
    }

    private char findK(int k, char base) {
        if (k == 1) return base;

        int len = 1;
        while (2 * len < k) {
            len *= 2;
        }

        if (k <= len) {
            return findK(k, base);
        } else {
            char nextBase = nextChar(base);
            return findK(k - len, nextBase);
        }
    }

    private char nextChar(char c) {
        return c == 'z' ? 'a' : (char) (c + 1);
    }
}
