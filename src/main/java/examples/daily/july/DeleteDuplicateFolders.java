package examples.daily.july;

import java.util.*;

public class DeleteDuplicateFolders {

    private final TrieNode root = new TrieNode();

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<TrieNode>> subtreeMap = new HashMap<>();

        paths.sort(Comparator.<List<String>>comparingInt(List::size).thenComparing((a, b) -> {
            for (int i = 0; i < Math.min(a.size(), b.size()); ++i) {
                int cmp = a.get(i).compareTo(b.get(i));
                if (cmp != 0) return cmp;
            }
            return 0;
        }));

        for (List<String> path : paths) {
            TrieNode current = root;
            for (String folder : path) {
                current.children.putIfAbsent(folder, new TrieNode());
                current = current.children.get(folder);
            }
        }

        collectSubtrees(root, subtreeMap);

        for (List<TrieNode> duplicates : subtreeMap.values()) {
            if (duplicates.size() > 1) {
                for (TrieNode node : duplicates) {
                    node.deleted = true;
                }
            }
        }

        buildResult(root, new ArrayList<>(), result);
        return result;
    }

    private StringBuilder collectSubtrees(TrieNode node, Map<String, List<TrieNode>> map) {
        StringBuilder sb = new StringBuilder("(");
        for (String folder : node.children.keySet()) {
            TrieNode child = node.children.get(folder);
            sb.append(folder).append(collectSubtrees(child, map));
        }
        sb.append(")");
        String subtree = sb.toString();
        if (!subtree.equals("()")) {
            map.computeIfAbsent(subtree, k -> new ArrayList<>()).add(node);
        }
        return sb;
    }

    private void buildResult(TrieNode node, List<String> path, List<List<String>> result) {
        for (String folder : node.children.keySet()) {
            TrieNode child = node.children.get(folder);
            if (!child.deleted) {
                path.add(folder);
                buildResult(child, path, result);
                path.remove(path.size() - 1);
            }
        }
        if (!path.isEmpty()) {
            result.add(new ArrayList<>(path));
        }
    }

    public static void main(String[] args) {
        DeleteDuplicateFolders solution = new DeleteDuplicateFolders();
        List<List<String>> input = Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("c"),
                Arrays.asList("a", "b"),
                Arrays.asList("c", "b"),
                Arrays.asList("a", "b", "x"),
                Arrays.asList("c", "b", "x")
        );
        List<List<String>> output = solution.deleteDuplicateFolder(input);
        for (List<String> path : output) {
            System.out.println(path);
        }
    }
}

class TrieNode {
    Map<String, TrieNode> children = new HashMap<>();
    boolean deleted = false;
}
