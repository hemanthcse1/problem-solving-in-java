package examples.interviewquestions.bitmaps.easy;

public class ReverseBits {

    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {

            result <<= 1;

            result |= (n & 1);

            n >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseBits rb = new ReverseBits();

        int input1 = 0b00000010100101000001111010011100;
        System.out.println(rb.reverseBits(input1));


        int input2 = 0b11111111111111111111111111111101;
        System.out.println(rb.reverseBits(input2));
    }
}
