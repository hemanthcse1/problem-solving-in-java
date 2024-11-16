package examples.interviewquestions.hashmaps.medium;

import java.util.HashMap;
import java.util.Map;

public class OnlineElection {

    private int[] times;
    private Map<Integer, Integer> timeToLeader;

    public OnlineElection(int[] persons, int[] times) {
        this.times = times;
        this.timeToLeader = new HashMap<>();
        Map<Integer, Integer> voteCount = new HashMap<>();
        int leader = -1;
        int maxVotes = 0;

        for (int i = 0; i < persons.length; i++) {
            int person = persons[i];
            voteCount.put(person, voteCount.getOrDefault(person, 0) + 1);
            if (voteCount.get(person) >= maxVotes) {
                leader = person;
                maxVotes = voteCount.get(person);
            }
            timeToLeader.put(times[i], leader);
        }
    }

    public int q(int t) {
        int lo = 0, hi = times.length - 1;
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            if (times[mid] <= t) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return timeToLeader.get(times[lo]);
    }

    public static void main(String[] args) {
        OnlineElection topVotedCandidate = new OnlineElection(new int[]{0, 1, 1, 0, 0, 1, 0}, new int[]{0, 5, 10, 15, 20, 25, 30});
        System.out.println(topVotedCandidate.q(3));
        System.out.println(topVotedCandidate.q(12));
        System.out.println(topVotedCandidate.q(25));
        System.out.println(topVotedCandidate.q(15));
        System.out.println(topVotedCandidate.q(24));
        System.out.println(topVotedCandidate.q(8));
    }
}
