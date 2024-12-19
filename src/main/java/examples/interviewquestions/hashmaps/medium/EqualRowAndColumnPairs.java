package examples.interviewquestions.hashmaps.medium;

public class EqualRowAndColumnPairs {

    public static void main(String[] args) {

        int[][] grid1 = {
                {3,2,1},
                {1,7,6},
                {2,7,7}
        };
        System.out.println(equalPairs(grid1));

        int[][] grid2 = {
                {3,1,2,2},
                {1,4,4,5},
                {2,4,2,2},
                {2,4,2,2}
        };
        System.out.println(equalPairs(grid2));
    }

    public static int equalPairs(int[][] grid) {
        int n = grid.length;
        java.util.Map<String, Integer> rowPatterns = new java.util.HashMap<>();

        for (int i = 0; i < n; i++) {
            String pattern = toPattern(grid[i]);
            rowPatterns.put(pattern, rowPatterns.getOrDefault(pattern, 0) + 1);
        }

        int count = 0;
        for (int j = 0; j < n; j++) {
            int[] col = new int[n];
            for (int i = 0; i < n; i++) {
                col[i] = grid[i][j];
            }
            String pattern = toPattern(col);
            count += rowPatterns.getOrDefault(pattern, 0);
        }

        return count;
    }

    private static String toPattern(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append(",");
        }
        return sb.toString();
    }
}
