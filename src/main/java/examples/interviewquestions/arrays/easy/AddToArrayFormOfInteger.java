package examples.interviewquestions.arrays.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayFormOfInteger {

    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int n = num.length;
        int i = n - 1;
        int carry = k;

        while (i >= 0 || carry > 0) {
            if (i >= 0) {
                carry += num[i];
                i--;
            }

            result.add(carry % 10);

            carry /= 10;
        }

        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {
        AddToArrayFormOfInteger solution = new AddToArrayFormOfInteger();

        int[] num1 = {1, 2, 0, 0};
        int k1 = 34;
        System.out.println("Test case 1 output: " + solution.addToArrayForm(num1, k1));

        int[] num2 = {2, 7, 4};
        int k2 = 181;
        System.out.println("Test case 2 output: " + solution.addToArrayForm(num2, k2));

        int[] num3 = {2, 1, 5};
        int k3 = 806;
        System.out.println("Test case 3 output: " + solution.addToArrayForm(num3, k3));
    }
}
