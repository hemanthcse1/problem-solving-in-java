package examples.daily.june;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringGroupDivider {

    public String[] divideString(String s, int k, char fill) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            int end = Math.min(i + k, s.length());
            String group = s.substring(i, end);

            if (group.length() < k) {
                int remaining = k - group.length();
                StringBuilder sb = new StringBuilder(group);
                for (int j = 0; j < remaining; j++) {
                    sb.append(fill);
                }
                group = sb.toString();
            }

            result.add(group);
            i += k;
        }

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        StringGroupDivider divider = new StringGroupDivider();

        System.out.println(Arrays.toString(divider.divideString("abcdefghi", 3, 'x')));
        System.out.println(Arrays.toString(divider.divideString("abcdefghij", 3, 'x')));
    }
}
