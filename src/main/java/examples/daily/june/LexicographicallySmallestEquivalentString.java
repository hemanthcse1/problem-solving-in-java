package examples.daily.june;

public class LexicographicallySmallestEquivalentString {
    private int[] parent = new int[26];

    public LexicographicallySmallestEquivalentString() {
        for (int i = 0; i < 26; i++) {
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
            if (rootX < rootY) {
                parent[rootY] = rootX;
            } else {
                parent[rootX] = rootY;
            }
        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        for (int i = 0; i < s1.length(); i++) {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        StringBuilder result = new StringBuilder();
        for (char ch : baseStr.toCharArray()) {
            char smallest = (char) (find(ch - 'a') + 'a');
            result.append(smallest);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        LexicographicallySmallestEquivalentString solver = new LexicographicallySmallestEquivalentString();
        String s1 = "parker", s2 = "morris", baseStr = "parser";
        System.out.println("Output: " + solver.smallestEquivalentString(s1, s2, baseStr));
    }
}
