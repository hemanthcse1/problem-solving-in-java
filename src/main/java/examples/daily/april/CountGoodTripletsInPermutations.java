package examples.daily.april;

public class CountGoodTripletsInPermutations {

    public static void main(String[] args) {
        CountGoodTripletsInPermutations solution = new CountGoodTripletsInPermutations();
        int[] nums1 = {4, 0, 1, 3, 2};
        int[] nums2 = {4, 1, 0, 2, 3};
        long result = solution.goodTriplets(nums1, nums2);
        System.out.println("Number of good triplets: " + result);
    }

    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[nums2[i]] = i;
        }
        int[] mapped = new int[n];
        for (int i = 0; i < n; i++) {
            mapped[i] = pos[nums1[i]];
        }

        FenwickTree leftTree = new FenwickTree(n);
        FenwickTree rightTree = new FenwickTree(n);
        for (int i = 0; i < n; i++) {
            rightTree.update(mapped[i], 1);
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            rightTree.update(mapped[i], -1);
            long leftCount = leftTree.query(mapped[i] - 1);
            long rightCount = rightTree.query(n - 1) - rightTree.query(mapped[i]);
            result += leftCount * rightCount;
            leftTree.update(mapped[i], 1);
        }

        return result;
    }

    class FenwickTree {
        int[] tree;
        int size;

        FenwickTree(int n) {
            size = n;
            tree = new int[n + 1];
        }

        void update(int index, int delta) {
            index++;
            while (index <= size) {
                tree[index] += delta;
                index += index & -index;
            }
        }

        int query(int index) {
            index++;
            int sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= index & -index;
            }
            return sum;
        }
    }
}
