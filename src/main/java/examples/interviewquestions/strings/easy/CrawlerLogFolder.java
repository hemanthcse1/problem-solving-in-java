package examples.interviewquestions.strings.easy;

public class CrawlerLogFolder {
    public static void main(String[] args) {
        String[] logs1 = {"d1/", "d2/", "../", "d21/", "./"};
        String[] logs2 = {"d1/", "d2/", "../", "../", "d21/", "./", "../"};
        String[] logs3 = {"d1/", "./", "d2/", "../", "d3/", "../", "../"};

        System.out.println(minOperations(logs1));
        System.out.println(minOperations(logs2));
        System.out.println(minOperations(logs3));
    }
    public static int minOperations(String[] logs) {
        int depth = 0;
        for (String log : logs) {
            if (log.equals("../")) {
                if (depth > 0) {
                    depth--;
                }
            } else if (!log.equals("./")) {
                depth++;
            }
        }
        return depth;
    }
}
