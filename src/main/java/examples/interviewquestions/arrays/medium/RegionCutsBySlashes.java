package examples.interviewquestions.arrays.medium;

public class RegionCutsBySlashes {

    private int[] parent;
    private int count;

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int size = 4 * n * n;
        initializeUnionFind(size);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int base = 4 * (i * n + j);
                char c = grid[i].charAt(j);

                if (c == '/') {
                    union(base + 0, base + 3);
                    union(base + 1, base + 2);
                } else if (c == '\\') {
                    union(base + 0, base + 1);
                    union(base + 2, base + 3);
                } else {
                    union(base + 0, base + 1);
                    union(base + 1, base + 2);
                    union(base + 2, base + 3);
                }

                if (i > 0) {
                    union(base + 0, 4 * ((i - 1) * n + j) + 2);
                }

                if (j > 0) {
                    union(base + 3, 4 * (i * n + j - 1) + 1);
                }
            }
        }

        return countDistinctRegions();
    }

    private void initializeUnionFind(int size) {
        parent = new int[size];
        count = size;
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootX] = rootY;
            count--;
        }
    }

    private int countDistinctRegions() {
        int distinctRegions = 0;
        for (int i = 0; i < parent.length; i++) {
            if (i == find(i)) {
                distinctRegions++;
            }
        }
        return distinctRegions;
    }

    public static void main(String[] args) {
        RegionCutsBySlashes solution = new RegionCutsBySlashes();

        String[] grid1 = {" /", "/ "};
        String[] grid2 = {" /", "  "};
        String[] grid3 = {"/\\", "\\/"};

        System.out.println("Test Case 1: " + solution.regionsBySlashes(grid1));
        System.out.println("Test Case 2: " + solution.regionsBySlashes(grid2));
        System.out.println("Test Case 3: " + solution.regionsBySlashes(grid3));
    }
}
