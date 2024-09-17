package examples.interviewquestions.arrays.easy;

public class SmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (letters[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return letters[left % letters.length];
    }

    public static void main(String[] args) {
        SmallestLetterGreaterThanTarget solution = new SmallestLetterGreaterThanTarget();

        char[] letters1 = {'c', 'f', 'j'};
        char target1 = 'a';
        System.out.println("Test case 1 output: " + solution.nextGreatestLetter(letters1, target1));

        char[] letters2 = {'c', 'f', 'j'};
        char target2 = 'c';
        System.out.println("Test case 2 output: " + solution.nextGreatestLetter(letters2, target2));

        char[] letters3 = {'x', 'x', 'y', 'y'};
        char target3 = 'z';
        System.out.println("Test case 3 output: " + solution.nextGreatestLetter(letters3, target3));
    }
}
