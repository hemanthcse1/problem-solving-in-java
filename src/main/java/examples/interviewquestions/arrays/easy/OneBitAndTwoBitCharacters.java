package examples.interviewquestions.arrays.easy;

public class OneBitAndTwoBitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;

        while (i < bits.length - 1) {
            if (bits[i] == 1) {
                i += 2;
            } else {
                i++;
            }
        }

        return i == bits.length - 1;
    }

    public static void main(String[] args) {
        OneBitAndTwoBitCharacters solver = new OneBitAndTwoBitCharacters();
        System.out.println(solver.isOneBitCharacter(new int[]{1, 0, 0}));
        System.out.println(solver.isOneBitCharacter(new int[]{1, 1, 1, 0}));
    }
}
