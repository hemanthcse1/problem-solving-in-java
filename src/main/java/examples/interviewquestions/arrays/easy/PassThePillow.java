package examples.interviewquestions.arrays.easy;

public class PassThePillow {

    public int passThePillow(int n, int time) {
        int position = 1;
        boolean forward = true;

        while (time > 0) {
            if (forward) {
                if (position < n) {
                    position++;
                } else {
                    forward = false;
                    position--;
                }
            } else {
                if (position > 1) {
                    position--;
                } else {
                    forward = true;
                    position++;
                }
            }
            time--;
        }
        return position;
    }

    public static void main(String[] args) {
        PassThePillow solution = new PassThePillow();
        System.out.println(solution.passThePillow(4, 5));
        System.out.println(solution.passThePillow(3, 2));
    }
}
