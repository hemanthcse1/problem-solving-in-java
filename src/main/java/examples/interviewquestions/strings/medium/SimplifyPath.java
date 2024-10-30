package examples.interviewquestions.strings.medium;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] components = path.split("/");

        for (String component : components) {
            if (component.equals("") || component.equals(".")) {
                continue;
            } else if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(component);
            }
        }

        StringBuilder canonicalPath = new StringBuilder();
        for (String dir : stack) {
            canonicalPath.append("/").append(dir);
        }

        return canonicalPath.length() > 0 ? canonicalPath.toString() : "/";
    }

    public static void main(String[] args) {
        SimplifyPath solution = new SimplifyPath();

        System.out.println("Simplified Path for '/home/': " + solution.simplifyPath("/home/"));
        System.out.println("Simplified Path for '/home//foo/': " + solution.simplifyPath("/home//foo/"));
        System.out.println("Simplified Path for '/home/user/Documents/../Pictures': " + solution.simplifyPath("/home/user/Documents/../Pictures"));
        System.out.println("Simplified Path for '/../': " + solution.simplifyPath("/../"));
        System.out.println("Simplified Path for '/.../a/../b/c/../d/./': " + solution.simplifyPath("/.../a/../b/c/../d/./"));
    }
}
