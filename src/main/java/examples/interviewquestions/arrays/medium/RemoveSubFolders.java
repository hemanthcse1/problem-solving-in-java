package examples.interviewquestions.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveSubFolders {

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        String prev = folder[0];
        result.add(prev);

        for (int i = 1; i < folder.length; i++) {
            if (!folder[i].startsWith(prev + "/")) {
                prev = folder[i];
                result.add(prev);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        RemoveSubFolders solution = new RemoveSubFolders();
        System.out.println(solution.removeSubfolders(new String[]{"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"}));
        System.out.println(solution.removeSubfolders(new String[]{"/a", "/a/b/c", "/a/b/d"}));
    }
}
