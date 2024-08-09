package examples.hashtables.easy;

public class RingsAndRods {
    public static int countRodsWithAllColors(String rings) {
        int[] rods = new int[10];
        for (int i = 0; i < rings.length(); i += 2) {
            char color = rings.charAt(i);
            int rod = rings.charAt(i + 1) - '0';
            if (color == 'R') {
                rods[rod] |= 1;
            } else if (color == 'G') {
                rods[rod] |= 2;
            } else if (color == 'B') {
                rods[rod] |= 4;
            }
        }
        int count = 0;
        for (int rod : rods) {
            if (rod == 7) {  // 7 in binary is 111,
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String rings = "B0R0G0R1G1B1R2G2B2";
        int result = countRodsWithAllColors(rings);
        System.out.println("Number of rods with all colors: " + result);
    }
}
