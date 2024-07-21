package examples.interviewquestions.maths;

public class HarshadNumber {

    public static void main(String[] args) {

        int x = 18;
        System.out.println(isHarshadNumber(x));
    }

    private static int isHarshadNumber(int x){
        int sumOfDigits = sumOfDigits(x);
        if (x % sumOfDigits == 0){
            return sumOfDigits;
        }else {
            return -1;
        }
    }
    private static int sumOfDigits(int x){
        int sum = 0;
        while (x > 0){
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
