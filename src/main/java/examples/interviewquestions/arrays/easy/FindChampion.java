package examples.interviewquestions.arrays.easy;

public class FindChampion {
    public int findChampion(int[][] grid) {
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            boolean potentialChampion = true;
            for (int j = 0; j < n; j++) {
                if (i != j && grid[i][j] == 0) {
                    potentialChampion = false;
                    break;
                }
            }
            if (potentialChampion) {
                boolean isChampion = true;
                for (int k = 0; k < n; k++) {
                    if (i != k && grid[k][i] == 1) {
                        isChampion = false;
                        break;
                    }
                }
                if (isChampion) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FindChampion solution = new FindChampion();
        System.out.println(solution.findChampion(new int[][]{{0, 1}, {0, 0}}));
        System.out.println(solution.findChampion(new int[][]{{0, 0, 1}, {1, 0, 1}, {0, 0, 0}}));
    }
}
