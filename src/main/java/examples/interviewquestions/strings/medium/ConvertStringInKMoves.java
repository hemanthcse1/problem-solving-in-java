package examples.interviewquestions.strings.medium;

public class ConvertStringInKMoves {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] shiftCounts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int shift = (t.charAt(i) - s.charAt(i) + 26) % 26;
            if (shift > 0) {
                shiftCounts[shift]++;
            }
        }

        for (int shift = 1; shift < 26; shift++) {
            int maxMovesNeeded = shift + (shiftCounts[shift] - 1) * 26;
            if (maxMovesNeeded > k) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ConvertStringInKMoves kMoves = new ConvertStringInKMoves();
        System.out.println(kMoves.canConvertString("input", "ouput", 9));
        System.out.println(kMoves.canConvertString("abc", "bcd", 10));
        System.out.println(kMoves.canConvertString("aab", "bbb", 27));
    }
}
