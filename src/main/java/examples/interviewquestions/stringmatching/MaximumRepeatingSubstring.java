package examples.interviewquestions.stringmatching;

public class MaximumRepeatingSubstring {
    public int maxRepeating(String sequence, String word) {
        int maxK = 0;
        StringBuilder repeatedWord = new StringBuilder(word);

        while (sequence.contains(repeatedWord)) {
            maxK++;
            repeatedWord.append(word);
        }

        return maxK;
    }

    public static void main(String[] args) {
        MaximumRepeatingSubstring solution = new MaximumRepeatingSubstring();
        System.out.println(solution.maxRepeating("ababc", "ab"));
        System.out.println(solution.maxRepeating("ababc", "ba"));
        System.out.println(solution.maxRepeating("ababc", "ac"));
    }
}
