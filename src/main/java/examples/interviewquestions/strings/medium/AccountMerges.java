package examples.interviewquestions.strings.medium;

import java.util.*;

public class AccountMerges {
    private int[] parent;

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToId = new HashMap<>();
        parent = new int[accounts.size()];

        for (int i = 0; i < accounts.size(); i++) {
            parent[i] = i;
        }

        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (!emailToId.containsKey(email)) {
                    emailToId.put(email, i);
                } else {
                    union(i, emailToId.get(email));
                }
            }
        }

        Map<Integer, List<String>> groups = new HashMap<>();
        for (String email : emailToId.keySet()) {
            int rootId = find(emailToId.get(email));
            groups.computeIfAbsent(rootId, x -> new ArrayList<>()).add(email);
        }

        List<List<String>> result = new ArrayList<>();
        for (int id : groups.keySet()) {
            List<String> emails = groups.get(id);
            Collections.sort(emails);
            List<String> account = new ArrayList<>();
            account.add(accounts.get(id).get(0));
            account.addAll(emails);
            result.add(account);
        }

        return result;
    }

    public static void main(String[] args) {
        AccountMerges solution = new AccountMerges();

        List<List<String>> accounts1 = Arrays.asList(
                Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                Arrays.asList("Mary", "mary@mail.com"),
                Arrays.asList("John", "johnnybravo@mail.com")
        );
        System.out.println(solution.accountsMerge(accounts1));

        List<List<String>> accounts2 = Arrays.asList(
                Arrays.asList("Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe1@m.co"),
                Arrays.asList("Kevin", "Kevin3@m.co", "Kevin5@m.co", "Kevin0@m.co"),
                Arrays.asList("Ethan", "Ethan5@m.co", "Ethan4@m.co", "Ethan0@m.co"),
                Arrays.asList("Hanzo", "Hanzo3@m.co", "Hanzo1@m.co", "Hanzo0@m.co"),
                Arrays.asList("Fern", "Fern5@m.co", "Fern1@m.co", "Fern0@m.co")
        );
        System.out.println(solution.accountsMerge(accounts2));
    }
}
