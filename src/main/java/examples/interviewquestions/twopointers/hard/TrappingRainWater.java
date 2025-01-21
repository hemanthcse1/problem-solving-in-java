package examples.interviewquestions.twopointers.hard;

public class TrappingRainWater {
    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += (leftMax - height[left]);
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += (rightMax - height[right]);
                }
                right--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int[] h1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(h1));

        int[] h2 = {4,2,0,3,2,5};
        System.out.println(trap(h2));
    }
}
