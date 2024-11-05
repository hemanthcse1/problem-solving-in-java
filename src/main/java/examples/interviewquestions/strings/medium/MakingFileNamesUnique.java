package examples.interviewquestions.strings.medium;

import java.util.HashMap;
import java.util.Map;

public class MakingFileNamesUnique {

    public String[] getFolderNames(String[] names) {
        Map<String, Integer> nameMap = new HashMap<>();
        String[] result = new String[names.length];

        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (!nameMap.containsKey(name)) {
                result[i] = name;
                nameMap.put(name, 1);
            } else {
                int k = nameMap.get(name);
                while (nameMap.containsKey(name + "(" + k + ")")) {
                    k++;
                }
                String uniqueName = name + "(" + k + ")";
                result[i] = uniqueName;
                nameMap.put(name, k + 1);
                nameMap.put(uniqueName, 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MakingFileNamesUnique solution = new MakingFileNamesUnique();

        String[] names1 = {"pes","fifa","gta","pes(2019)"};
        String[] names2 = {"gta","gta(1)","gta","avalon"};
        String[] names3 = {"onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"};

        System.out.println(java.util.Arrays.toString(solution.getFolderNames(names1)));
        System.out.println(java.util.Arrays.toString(solution.getFolderNames(names2)));
        System.out.println(java.util.Arrays.toString(solution.getFolderNames(names3)));
    }
}
