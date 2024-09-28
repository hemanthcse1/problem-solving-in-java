package examples.interviewquestions.arrays.easy;

public class TypeOfTriangle {
    public String typeOfTriangle(int[] nums) {
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

    public static void main(String[] args) {
        TypeOfTriangle sol = new TypeOfTriangle();

        System.out.println(sol.typeOfTriangle(new int[]{3, 3, 3}));
        System.out.println(sol.typeOfTriangle(new int[]{3, 4, 5}));
        System.out.println(sol.typeOfTriangle(new int[]{2, 2, 5}));
    }
}
