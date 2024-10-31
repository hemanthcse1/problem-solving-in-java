package examples.interviewquestions.strings.medium;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments {
    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        StringBuilder newLine = new StringBuilder();
        boolean inBlock = false;

        for (String line : source) {
            int i = 0;
            if (!inBlock) newLine.setLength(0);
            while (i < line.length()) {
                if (!inBlock && i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                    inBlock = true;
                    i++;
                } else if (inBlock && i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                    inBlock = false;
                    i++;
                } else if (!inBlock && i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                    break;
                } else if (!inBlock) {
                    newLine.append(line.charAt(i));
                }
                i++;
            }
            if (!inBlock && newLine.length() > 0) {
                result.add(newLine.toString());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RemoveComments rc = new RemoveComments();
        String[] source = {
                "/*Test program */", "int main()", "{ ", "  // variable declaration ",
                "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ",
                "   testing */", "a = b + c;", "}"
        };
        List<String> result = rc.removeComments(source);
        for (String line : result) {
            System.out.println(line);
        }
    }
}
