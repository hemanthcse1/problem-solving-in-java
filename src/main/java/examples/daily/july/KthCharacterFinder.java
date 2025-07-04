package examples.daily.july;

import java.util.Scanner;

public class KthCharacterFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter k (position of character to find): ");
        long k = scanner.nextLong();

        System.out.print("Enter number of operations: ");
        int n = scanner.nextInt();

        int[] operations = new int[n];
        System.out.print("Enter " + n + " operation values: ");
        for (int i = 0; i < n; i++) {
            operations[i] = scanner.nextInt();
        }

        KthCharacterFinder kthCharacterFinder = new KthCharacterFinder();
        char result = kthCharacterFinder.kthCharacter(k, operations);

        System.out.println("The " + k + "th character is: " + result);
    }

    public char kthCharacter(long k, int[] operations) {
        final int operationsCount = (int) Math.ceil(Math.log(k) / Math.log(2));
        int increases = 0;

        for (int i = operationsCount - 1; i >= 0; --i) {
            final long halfSize = 1L << i;
            if (k > halfSize) {
                k -= halfSize;
                increases += operations[i];
            }
        }

        return (char) ('a' + increases % 26);
    }
}
