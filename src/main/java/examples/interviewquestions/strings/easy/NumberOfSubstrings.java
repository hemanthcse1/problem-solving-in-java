package examples.interviewquestions.strings.easy;

public class NumberOfSubstrings {

    public static void main(String[] args) {
        String[] patterns = {"a","abc","bc","d"};
        String word = "abc";
        System.out.println("Count -> "+stringCount(patterns,word));
    }

    public static int stringCount(String[] patterns, String word){
        int count = 0;

        for (String pattern : patterns){
            if (word.contains(pattern)){
                count++;
            }
        }
        return count;
    }
}
