package examples.interviewquestions.bitmaps.medium;

public class MinimumFlipsOR {

    public int minFlips(int a, int b, int c) {
        int flips = 0;

        for(int i = 0; i < 32; ++i){
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;
            int bitC = (c >> i) & 1;

            if(bitC == 1){
                if(bitA == 0 && bitB == 0){
                    flips += 1;
                }
            }
            else{
                flips += bitA + bitB;
            }
        }

        return flips;
    }

    public static void main(String[] args) {
        MinimumFlipsOR mfo = new MinimumFlipsOR();

        int a1 = 2, b1 = 6, c1 = 5;
        System.out.println("Minimum Flips (Example 1): " + mfo.minFlips(a1, b1, c1));


        int a2 = 4, b2 = 2, c2 = 7;
        System.out.println("Minimum Flips (Example 2): " + mfo.minFlips(a2, b2, c2));


        int a3 = 1, b3 = 2, c3 = 3;
        System.out.println("Minimum Flips (Example 3): " + mfo.minFlips(a3, b3, c3));
    }
}
