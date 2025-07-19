package examples.daily.july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveSubfoldersFromFilesystem {

    public static List<String> removeSubfolders(String[] folder) {
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
        String[] input = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        List<String> cleanedFolders = removeSubfolders(input);
        System.out.println("Cleaned folder structure:");
        for (String folder : cleanedFolders) {
            System.out.println(folder);
        }
    }
}
