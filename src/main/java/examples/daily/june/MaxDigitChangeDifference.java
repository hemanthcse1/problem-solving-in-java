package examples.daily.june;

public class MaxDigitChangeDifference {

    public int maxDiff(int num) {
        String numStr = String.valueOf(num);
        int max = getMax(numStr);
        int min = getMin(numStr);
        return max - min;
    }

    private int getMax(String numStr) {
        for (char c : numStr.toCharArray()) {
            if (c != '9') {
                return Integer.parseInt(numStr.replace(c, '9'));
            }
        }
        return Integer.parseInt(numStr);
    }

    private int getMin(String numStr) {
        char first = numStr.charAt(0);
        if (first != '1') {
            return Integer.parseInt(numStr.replace(first, '1'));
        }
        for (int i = 1; i < numStr.length(); i++) {
            char c = numStr.charAt(i);
            if (c != '0' && c != '1') {
                return Integer.parseInt(numStr.replace(c, '0'));
            }
        }
        return Integer.parseInt(numStr);
    }

    public static void main(String[] args) {
        MaxDigitChangeDifference solution = new MaxDigitChangeDifference();
        System.out.println(solution.maxDiff(555)); //  888
        System.out.println(solution.maxDiff(9));   //  8
    }
}
