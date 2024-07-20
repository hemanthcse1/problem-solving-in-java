package examples.interviewquestions.maths;

public class MaximumAchievableNumber {
    public int findMaxAchievableNumber(int num, int t) {
        return num + 2 * t;
    }

    public static void main(String[] args) {
        MaximumAchievableNumber man = new MaximumAchievableNumber();
        int num = 3;
        int t = 2;
        int result = man.findMaxAchievableNumber(num, t);
        System.out.println("Maximum Achievable Number: " + result);
    }
}
