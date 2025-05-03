package examples.daily.may;

public class MinimumDominoRotations {

    public static void main(String[] args) {
        MinimumDominoRotations minimumDominoRotations = new MinimumDominoRotations();

        int[] tops1 = {2, 1, 2, 4, 2, 2};
        int[] bottoms1 = {5, 2, 6, 2, 3, 2};
        System.out.println(minimumDominoRotations.minDominoRotations(tops1, bottoms1)); //  2

        int[] tops2 = {3, 5, 1, 2, 3};
        int[] bottoms2 = {3, 6, 3, 3, 4};
        System.out.println(minimumDominoRotations.minDominoRotations(tops2, bottoms2)); // -1
    }

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int rotations = check(tops[0], tops, bottoms);
        if (rotations != -1 || tops[0] == bottoms[0]) return rotations;
        return check(bottoms[0], tops, bottoms);
    }

    private int check(int x, int[] tops, int[] bottoms) {
        int rotationsTop = 0, rotationsBottom = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != x && bottoms[i] != x) return -1;
            else if (tops[i] != x) rotationsTop++;
            else if (bottoms[i] != x) rotationsBottom++;
        }
        return Math.min(rotationsTop, rotationsBottom);
    }

}
