package examples.interviewquestions.maths.medium;

public class PowerFunction {

    public double myPow(double x, int n) {

        long exponent = n;
        if (exponent < 0) {
            x = 1 / x;
            exponent = -exponent;
        }

        double result = 1.0;
        while (exponent > 0) {

            if ((exponent & 1) == 1) {
                result *= x;
            }

            x *= x;
            exponent >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        PowerFunction pf = new PowerFunction();

        System.out.println(pf.myPow(2.0, 10));
        System.out.println(pf.myPow(2.1, 3));
        System.out.println(pf.myPow(2.0, -2));
        System.out.println(pf.myPow(-2.0, 3));
    }

}
