package examples.daily.june;

public class DigitRemapMaxDifference {
    public int minMaxDifference(int num) {
        String numStr = String.valueOf(num);
        int max = getRemappedValue(numStr, true);
        int min = getRemappedValue(numStr, false);
        return max - min;
    }

    private int getRemappedValue(String numStr, boolean findMax) {
        for (char c : numStr.toCharArray()) {
            if ((findMax && c != '9') || (!findMax && c != '0')) {
                char target = findMax ? '9' : '0';
                String replaced = numStr.replace(c, target);
                return Integer.parseInt(replaced);
            }
        }
        return Integer.parseInt(numStr);
    }

    public static void main(String[] args) {
        DigitRemapMaxDifference solution = new DigitRemapMaxDifference();
        System.out.println(solution.minMaxDifference(11891)); // 99009
        System.out.println(solution.minMaxDifference(90));    // 99
    }
}
