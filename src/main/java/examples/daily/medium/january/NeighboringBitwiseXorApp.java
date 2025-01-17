package examples.daily.medium.january;

public class NeighboringBitwiseXorApp {

    public static void main(String[] args) {
        System.out.println(doesValidArrayExist(new int[]{1,1,0}));
        System.out.println(doesValidArrayExist(new int[]{1,1}));
        System.out.println(doesValidArrayExist(new int[]{1,0}));
        System.out.println(doesValidArrayExist(new int[]{0}));
        System.out.println(doesValidArrayExist(new int[]{1}));
    }

    public static boolean doesValidArrayExist(int[] derived) {
        return canForm(derived, 0) || canForm(derived, 1);
    }

    private static boolean canForm(int[] derived, int firstVal) {
        int n = derived.length;
        int[] original = new int[n];
        original[0] = firstVal;

        for (int i = 0; i < n - 1; i++) {
            original[i + 1] = derived[i] ^ original[i];
        }

        return derived[n - 1] == (original[n - 1] ^ original[0]);
    }
}
