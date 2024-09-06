package examples.interviewquestions.arrays.easy;

public class AlternatingGroups {
    public static int countAlternatingGroups(int[] colors) {
        int n = colors.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int prev = (i - 1 + n) % n;
            int next = (i + 1) % n;

            if (colors[prev] != colors[i] && colors[i] != colors[next]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] colors = {0, 1, 0, 1, 1, 0};
        int result = countAlternatingGroups(colors);
        System.out.println("Number of alternating groups: " + result);
    }
}
