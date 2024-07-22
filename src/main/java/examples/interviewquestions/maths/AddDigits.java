package examples.interviewquestions.maths;

public class AddDigits {

    public static void main(String[] args) {
        int num = 38;

        System.out.println("Result -> "+addDigits(num));
    }

    private static int addDigits(int num){
        if (num == 0){
            return 0;
        }else {
            return 1 + (num -1) % 9;
        }
    }
}
