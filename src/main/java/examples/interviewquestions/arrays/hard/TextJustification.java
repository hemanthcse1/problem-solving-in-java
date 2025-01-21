package examples.interviewquestions.arrays.hard;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public  static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;


            while (last < words.length) {

                if (words[last].length() + count + 1 > maxWidth) break;
                count += 1 + words[last].length();
                last++;
            }


            StringBuilder sb = new StringBuilder();
            int numberOfWords = last - index;
            int totalSpaces = maxWidth - countOfLetters(words, index, last);


            if (last == words.length || numberOfWords == 1) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) {
                        sb.append(" ");
                    }
                }

                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            }

            else {
                int gaps = numberOfWords - 1;
                int space = totalSpaces / gaps;
                int remainder = totalSpaces % gaps;

                for (int i = 0; i < gaps; i++) {
                    sb.append(words[index + i]);

                    int currentGapSize = space + (i < remainder ? 1 : 0);
                    for (int s = 0; s < currentGapSize; s++) {
                        sb.append(" ");
                    }
                }
                sb.append(words[last - 1]);
            }
            result.add(sb.toString());
            index = last;
        }

        return result;
    }

    private static int countOfLetters(String[] words, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += words[i].length();
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] words1 = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth1 = 16;
        System.out.println(fullJustify(words1, maxWidth1));


        String[] words2 = {"What","must","be","acknowledgment","shall","be"};
        int maxWidth2 = 16;
        System.out.println(fullJustify(words2, maxWidth2));


        String[] words3 = {
                "Science","is","what","we","understand","well","enough","to",
                "explain","to","a","computer.","Art","is","everything","else","we","do"
        };
        int maxWidth3 = 20;
        System.out.println(fullJustify(words3, maxWidth3));

    }
}
