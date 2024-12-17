package examples.interviewquestions.matrixes.medium;

public class SpiralMatrixIV {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for(int[] row : matrix) {
            java.util.Arrays.fill(row, -1);
        }
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        while(top <= bottom && left <= right && head != null) {
            for(int j = left; j <= right && head != null; j++) {
                matrix[top][j] = head.val;
                head = head.next;
            }
            top++;
            for(int i = top; i <= bottom && head != null; i++) {
                matrix[i][right] = head.val;
                head = head.next;
            }
            right--;
            if(top <= bottom) {
                for(int j = right; j >= left && head != null; j--) {
                    matrix[bottom][j] = head.val;
                    head = head.next;
                }
                bottom--;
            }
            if(left <= right) {
                for(int i = bottom; i >= top && head != null; i--) {
                    matrix[i][left] = head.val;
                    head = head.next;
                }
                left++;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        SpiralMatrixIV solution = new SpiralMatrixIV();

        // Example 1
        int m1 = 3, n1 = 5;
        int[] list1 = {3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0};
        ListNode head1 = createLinkedList(list1);
        int[][] result1 = solution.spiralMatrix(m1, n1, head1);
        print2DArray(result1);

        // Example 2
        int m2 = 1, n2 = 4;
        int[] list2 = {0, 1, 2};
        ListNode head2 = createLinkedList(list2);
        int[][] result2 = solution.spiralMatrix(m2, n2, head2);
        print2DArray(result2);

        // Additional Example
        int m3 = 2, n3 = 3;
        int[] list3 = {1, 2, 3, 4, 5};
        ListNode head3 = createLinkedList(list3);
        int[][] result3 = solution.spiralMatrix(m3, n3, head3);
        print2DArray(result3);
    }

    public static ListNode createLinkedList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for(int num : arr) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }

    public static void print2DArray(int[][] array) {
        System.out.print("[");
        for(int i = 0; i < array.length; i++) {
            System.out.print("[");
            for(int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
                if(j < array[i].length - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            if(i < array.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
