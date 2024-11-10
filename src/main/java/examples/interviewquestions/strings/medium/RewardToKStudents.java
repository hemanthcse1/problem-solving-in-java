package examples.interviewquestions.strings.medium;

import java.util.*;

public class RewardToKStudents {
    public List<Integer> topKStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> positiveSet = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> negativeSet = new HashSet<>(Arrays.asList(negative_feedback));
        Map<Integer, Integer> scoreMap = new HashMap<>();

        for (int i = 0; i < report.length; i++) {
            String[] words = report[i].split(" ");
            int student = student_id[i];
            int score = 0;

            for (String word : words) {
                if (positiveSet.contains(word)) {
                    score += 3;
                } else if (negativeSet.contains(word)) {
                    score -= 1;
                }
            }

            scoreMap.put(student, scoreMap.getOrDefault(student, 0) + score);
        }

        List<Student> students = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : scoreMap.entrySet()) {
            students.add(new Student(entry.getKey(), entry.getValue()));
        }

        students.sort((a, b) -> {
            if (b.score != a.score) {
                return b.score - a.score;
            }
            return a.id - b.id;
        });

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(students.get(i).id);
        }

        return result;
    }

    private static class Student {
        int id;
        int score;

        Student(int id, int score) {
            this.id = id;
            this.score = score;
        }
    }

    public static void main(String[] args) {
        RewardToKStudents solution = new RewardToKStudents();
        String[] positive_feedback = {"smart", "brilliant", "studious"};
        String[] negative_feedback = {"not"};
        String[] report = {"this student is studious", "the student is smart"};
        int[] student_id = {1, 2};
        int k = 2;

        System.out.println(solution.topKStudents(positive_feedback, negative_feedback, report, student_id, k)); // Output: [1, 2]
    }
}
