package examples.interviewquestions.strings.medium;

import java.util.ArrayList;
import java.util.List;

public class LargestTimeForGivenDigits {
    public String largestTimeFromDigits(int[] arr) {
        List<String> times = new ArrayList<>();
        permute(arr, 0, times);
        String latestTime = "";

        for (String time : times) {
            String hh = time.substring(0, 2);
            String mm = time.substring(2, 4);
            if (isValidTime(hh, mm)) {
                String currentTime = hh + ":" + mm;
                if (latestTime.isEmpty() || currentTime.compareTo(latestTime) > 0) {
                    latestTime = currentTime;
                }
            }
        }

        return latestTime;
    }

    private void permute(int[] arr, int start, List<String> times) {
        if (start == arr.length) {
            StringBuilder sb = new StringBuilder();
            for (int num : arr) sb.append(num);
            times.add(sb.toString());
            return;
        }
        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i);
            permute(arr, start + 1, times);
            swap(arr, start, i);
        }
    }

    private boolean isValidTime(String hh, String mm) {
        int hours = Integer.parseInt(hh);
        int minutes = Integer.parseInt(mm);
        return hours >= 0 && hours <= 23 && minutes >= 0 && minutes <= 59;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        LargestTimeForGivenDigits solution = new LargestTimeForGivenDigits();
        int[] arr = {1, 2, 3, 4};
        System.out.println(solution.largestTimeFromDigits(arr));
    }
}
