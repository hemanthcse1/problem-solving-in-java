package examples.daily.february;

public class UniqueBinaryStringFinder {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {

            char flippedBit = (nums[i].charAt(i) == '0') ? '1' : '0';
            result.append(flippedBit);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        UniqueBinaryStringFinder finder = new UniqueBinaryStringFinder();

        String[] test1 = {"01", "10"};
        System.out.println(finder.findDifferentBinaryString(test1)); //  "11" or "00"

        String[] test2 = {"00", "01"};
        System.out.println(finder.findDifferentBinaryString(test2)); //  "11" or "10"

        String[] test3 = {"111", "011", "001"};
        System.out.println(finder.findDifferentBinaryString(test3)); //  "101" or another valid binary string
    }
}
