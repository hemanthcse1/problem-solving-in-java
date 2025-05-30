package examples.interviewquestions.arrays.medium;

public class SentenceSimilarityIII {

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");

        int i = 0, j = 0;

        while (i < words1.length && i < words2.length && words1[i].equals(words2[i])) {
            i++;
        }

        while (j < words1.length - i && j < words2.length - i &&
                words1[words1.length - 1 - j].equals(words2[words2.length - 1 - j])) {
            j++;
        }

        return i + j >= Math.min(words1.length, words2.length);
    }

    public static void main(String[] args) {
        SentenceSimilarityIII solution = new SentenceSimilarityIII();

        String sentence1 = "My name is Haley";
        String sentence2 = "My Haley";
        System.out.println(solution.areSentencesSimilar(sentence1, sentence2)); // Output: true

        String sentence1_2 = "of";
        String sentence2_2 = "A lot of words";
        System.out.println(solution.areSentencesSimilar(sentence1_2, sentence2_2));
    }
}
