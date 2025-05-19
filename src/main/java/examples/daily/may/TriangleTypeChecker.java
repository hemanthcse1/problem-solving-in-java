package examples.daily.may;

public class TriangleTypeChecker {

    public static void main(String[] args) {
        TriangleTypeChecker triangleTypeChecker = new TriangleTypeChecker();

        int[] triangle1 = {3, 3, 3};      // equilateral
        int[] triangle2 = {3, 4, 4};      // isosceles
        int[] triangle3 = {3, 4, 5};      // scalene
        int[] triangle4 = {1, 2, 3};      // none

        System.out.println("Triangle1: " + triangleTypeChecker.triangleType(triangle1));
        System.out.println("Triangle2: " + triangleTypeChecker.triangleType(triangle2));
        System.out.println("Triangle3: " + triangleTypeChecker.triangleType(triangle3));
        System.out.println("Triangle4: " + triangleTypeChecker.triangleType(triangle4));
    }

    public String triangleType(int[] nums) {
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];

        if (a + b <= c || a + c <= b || b + c <= a) {
            return "none";
        }

        if (a == b && b == c) {
            return "equilateral";
        } else if (a == b || b == c || a == c) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }
}
