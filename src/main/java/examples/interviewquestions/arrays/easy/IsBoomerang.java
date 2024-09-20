package examples.interviewquestions.arrays.easy;

public class IsBoomerang {
    public boolean isBoomerang(int[][] points) {
        int[] p1 = points[0];
        int[] p2 = points[1];
        int[] p3 = points[2];

        if ((p1[0] == p2[0] && p1[1] == p2[1]) ||
                (p2[0] == p3[0] && p2[1] == p3[1]) ||
                (p1[0] == p3[0] && p1[1] == p3[1])) {
            return false;
        }

        return (p2[1] - p1[1]) * (p3[0] - p2[0]) != (p2[0] - p1[0]) * (p3[1] - p2[1]);
    }

    public static void main(String[] args) {
        IsBoomerang solution = new IsBoomerang();
        int[][] points1 = {{1, 1}, {2, 3}, {3, 2}};
        System.out.println(solution.isBoomerang(points1));

        int[][] points2 = {{1, 1}, {2, 2}, {3, 3}};
        System.out.println(solution.isBoomerang(points2));
    }
}
