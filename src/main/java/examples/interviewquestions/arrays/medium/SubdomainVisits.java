package examples.interviewquestions.arrays.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisits {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> domainCounts = new HashMap<>();

        for (String cpdomain : cpdomains) {
            String[] parts = cpdomain.split(" ");
            int count = Integer.parseInt(parts[0]);
            String domain = parts[1];

            String[] subdomains = domain.split("\\.");
            String current = "";
            for (int i = subdomains.length - 1; i >= 0; i--) {
                current = subdomains[i] + (i < subdomains.length - 1 ? "." : "") + current;
                domainCounts.put(current, domainCounts.getOrDefault(current, 0) + count);
            }
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : domainCounts.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }

        return result;
    }

    public static void main(String[] args) {
        SubdomainVisits solution = new SubdomainVisits();
        System.out.println(solution.subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));

        System.out.println(solution.subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));

    }
}
