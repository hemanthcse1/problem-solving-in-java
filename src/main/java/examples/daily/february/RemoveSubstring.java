package examples.daily.february;

public class RemoveSubstring {

    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        int index;

        while ((index = sb.indexOf(part)) != -1) {
            sb.delete(index, index + part.length());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveSubstring solution = new RemoveSubstring();


        String s1 = "daabcbaabcbc", part1 = "abc";
        System.out.println(solution.removeOccurrences(s1, part1));


        String s2 = "axxxxyyyyb", part2 = "xy";
        System.out.println(solution.removeOccurrences(s2, part2));
    }
}
