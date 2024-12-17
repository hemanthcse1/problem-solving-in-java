package examples.interviewquestions.arrays.medium;

public class FindStudentReplaceChalk {

    public static void main(String[] args) {
        int[] chalk1 = {5, 1, 5};
        long k1 = 22;
        int result1 = findReplaceStudent(chalk1, k1);
        System.out.println(result1);

        int[] chalk2 = {3, 4, 1, 2};
        long k2 = 25;
        int result2 = findReplaceStudent(chalk2, k2);
        System.out.println(result2);

        int[] chalk3 = {1, 2};
        long k3 = 3;
        int result3 = findReplaceStudent(chalk3, k3);
        System.out.println(result3);
    }

    public static int findReplaceStudent(int[] chalk, long k) {
        long total = 0;
        for (int c : chalk) {
            total += c;
        }
        k %= total;
        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i]) {
                return i;
            }
            k -= chalk[i];
        }
        return -1;
    }
}
