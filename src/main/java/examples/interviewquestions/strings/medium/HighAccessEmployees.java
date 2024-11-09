package examples.interviewquestions.strings.medium;

import java.util.*;

public class HighAccessEmployees {
    public List<String> highAccessEmployees(String[][] access_times) {
        Map<String, List<Integer>> employeeAccessMap = new HashMap<>();

        for (String[] access : access_times) {
            String employee = access[0];
            int timeInMinutes = convertToMinutes(access[1]);

            employeeAccessMap.putIfAbsent(employee, new ArrayList<>());
            employeeAccessMap.get(employee).add(timeInMinutes);
        }

        List<String> highAccessEmployees = new ArrayList<>();

        for (Map.Entry<String, List<Integer>> entry : employeeAccessMap.entrySet()) {
            String employee = entry.getKey();
            List<Integer> times = entry.getValue();
            Collections.sort(times);

            for (int i = 0; i < times.size() - 2; i++) {
                if (times.get(i + 2) - times.get(i) < 60) {
                    highAccessEmployees.add(employee);
                    break;
                }
            }
        }

        return highAccessEmployees;
    }

    private int convertToMinutes(String time) {
        int hours = Integer.parseInt(time.substring(0, 2));
        int minutes = Integer.parseInt(time.substring(2, 4));
        return hours * 60 + minutes;
    }

    public static void main(String[] args) {
        HighAccessEmployees solution = new HighAccessEmployees();

        String[][] accessTimes1 = {{"a", "0549"}, {"b", "0457"}, {"a", "0532"}, {"a", "0621"}, {"b", "0540"}};
        System.out.println(solution.highAccessEmployees(accessTimes1));

        String[][] accessTimes2 = {{"d", "0002"}, {"c", "0808"}, {"c", "0829"}, {"e", "0215"}, {"d", "1508"}, {"d", "1444"}, {"d", "1410"}, {"c", "0809"}};
        System.out.println(solution.highAccessEmployees(accessTimes2));

        String[][] accessTimes3 = {{"cd", "1025"}, {"ab", "1025"}, {"cd", "1046"}, {"cd", "1055"}, {"ab", "1124"}, {"ab", "1120"}};
        System.out.println(solution.highAccessEmployees(accessTimes3));
    }
}
