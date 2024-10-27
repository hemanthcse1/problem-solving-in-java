package examples.interviewquestions.hashmaps.medium;

import java.util.*;

public class DesignTwitter {

    private static int timestamp = 0;
    private Map<Integer, Set<Integer>> followers;
    private Map<Integer, List<Tweet>> tweets;

    private class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    public DesignTwitter() {
        followers = new HashMap<>();
        tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId, timestamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> feed = new PriorityQueue<>((a, b) -> a.time - b.time); // Min-heap to get top 10 most recent tweets

        if (tweets.containsKey(userId)) {
            for (Tweet tweet : tweets.get(userId)) {
                feed.offer(tweet);
                if (feed.size() > 10) feed.poll();
            }
        }

        Set<Integer> followees = followers.getOrDefault(userId, new HashSet<>());
        for (int followeeId : followees) {
            if (tweets.containsKey(followeeId)) {
                for (Tweet tweet : tweets.get(followeeId)) {
                    feed.offer(tweet);
                    if (feed.size() > 10) feed.poll();
                }
            }
        }

        List<Integer> result = new LinkedList<>();
        while (!feed.isEmpty()) {
            result.add(0, feed.poll().tweetId);
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            followers.putIfAbsent(followerId, new HashSet<>());
            followers.get(followerId).add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId)) {
            followers.get(followerId).remove(followeeId);
        }
    }

    public static void main(String[] args) {
        DesignTwitter twitter = new DesignTwitter();

        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1));

        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1));

        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
    }
}
