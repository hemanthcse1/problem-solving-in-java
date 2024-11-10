package examples.interviewquestions.strings.medium;

import java.util.*;

public class PopularVideoCreator {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, Long> popularityMap = new HashMap<>();
        Map<String, Pair<String, Integer>> topVideoMap = new HashMap<>();

        for (int i = 0; i < creators.length; i++) {
            String creator = creators[i];
            String videoId = ids[i];
            int viewCount = views[i];

            popularityMap.put(creator, popularityMap.getOrDefault(creator, 0L) + viewCount);

            if (!topVideoMap.containsKey(creator)) {
                topVideoMap.put(creator, new Pair<>(videoId, viewCount));
            } else {
                Pair<String, Integer> currentTop = topVideoMap.get(creator);
                if (viewCount > currentTop.getValue() ||
                        (viewCount == currentTop.getValue() && videoId.compareTo(currentTop.getKey()) < 0)) {
                    topVideoMap.put(creator, new Pair<>(videoId, viewCount));
                }
            }
        }

        long maxPopularity = Collections.max(popularityMap.values());

        List<List<String>> result = new ArrayList<>();
        for (String creator : popularityMap.keySet()) {
            if (popularityMap.get(creator) == maxPopularity) {
                result.add(Arrays.asList(creator, topVideoMap.get(creator).getKey()));
            }
        }

        return result;
    }

    static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        PopularVideoCreator solution = new PopularVideoCreator();

        String[] creators1 = {"alice", "bob", "alice", "chris"};
        String[] ids1 = {"one", "two", "three", "four"};
        int[] views1 = {5, 10, 5, 4};
        System.out.println(solution.mostPopularCreator(creators1, ids1, views1));

        String[] creators2 = {"alice", "alice", "alice"};
        String[] ids2 = {"a", "b", "c"};
        int[] views2 = {1, 2, 2};
        System.out.println(solution.mostPopularCreator(creators2, ids2, views2));
    }
}
