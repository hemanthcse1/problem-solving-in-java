package examples.daily.march;

public class AlternatingGroupsCounter {

    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        if (k > n) return 0;

        int[] validPairs = new int[2 * n];


        for (int i = 0; i < 2 * n - 1; i++) {
            validPairs[i] = (colors[i % n] != colors[(i + 1) % n]) ? 1 : 0;
        }


        int validCount = 0, result = 0;


        for (int i = 0; i < k - 1; i++) {
            validCount += validPairs[i];
        }


        for (int i = 0; i < n; i++) {
            if (validCount == k - 1) result++;

            validCount -= validPairs[i];
            validCount += validPairs[i + k - 1];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] colors = {0, 1, 0, 1, 0, 1};
        int k = 5;

        AlternatingGroupsCounter counter = new AlternatingGroupsCounter();
        int result = counter.numberOfAlternatingGroups(colors, k);

        System.out.println("Number of alternating groups: " + result);
    }
}
