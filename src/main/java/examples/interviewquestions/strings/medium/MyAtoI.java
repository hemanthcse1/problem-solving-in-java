package examples.interviewquestions.strings.medium;

public class MyAtoI {

    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int i = 0, sign = 1, result = 0;
        int n = s.length();
        int INT_MAX = Integer.MAX_VALUE;
        int INT_MIN = Integer.MIN_VALUE;

        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            if (result > (INT_MAX - digit) / 10) {
                return (sign == 1) ? INT_MAX : INT_MIN;
            }

            result = result * 10 + digit;
            i++;
        }
        return result * sign;
    }

    public static void main(String[] args) {
        MyAtoI myAtoI = new MyAtoI();


        System.out.println(myAtoI.myAtoi("42"));
        System.out.println(myAtoI.myAtoi("   -42"));
        System.out.println(myAtoI.myAtoi("1337c0d3"));
        System.out.println(myAtoI.myAtoi("0-1"));
        System.out.println(myAtoI.myAtoi("words and 987"));
    }
}
