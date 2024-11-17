package examples.interviewquestions.arrays.medium;

public class FindLatestGroup {

    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        if (m == n) return n;

        int[] length = new int[n + 2];
        int count = 0;
        int latestStep = -1;

        for (int step = 0; step < n; step++) {
            int pos = arr[step];
            int left = length[pos - 1];
            int right = length[pos + 1];

            if (left == m) count--;
            if (right == m) count--;

            int newLength = left + right + 1;
            length[pos] = newLength;
            length[pos - left] = newLength;
            length[pos + right] = newLength;

            if (newLength == m) count++;

            if (count > 0) latestStep = step + 1;
        }

        return latestStep;
    }

    public static void main(String[] args) {
        FindLatestGroup sol = new FindLatestGroup();
        System.out.println(sol.findLatestStep(new int[]{3, 5, 1, 2, 4}, 1));
        System.out.println(sol.findLatestStep(new int[]{3, 1, 5, 4, 2}, 2));
    }
}
