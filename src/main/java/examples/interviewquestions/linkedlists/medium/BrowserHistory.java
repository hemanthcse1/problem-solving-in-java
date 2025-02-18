package examples.interviewquestions.linkedlists.medium;

import java.util.ArrayList;
import java.util.List;

public class BrowserHistory {

    private List<String> history;
    private int currentIndex;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        currentIndex = 0;
    }

    public void visit(String url) {
        // Remove forward history
        history = history.subList(0, currentIndex + 1);
        history.add(url);
        currentIndex++;
    }

    public String back(int steps) {
        currentIndex = Math.max(0, currentIndex - steps);
        return history.get(currentIndex);
    }

    public String forward(int steps) {
        currentIndex = Math.min(history.size() - 1, currentIndex + steps);
        return history.get(currentIndex);
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");

        browserHistory.visit("google.com");       // Visit google.com
        browserHistory.visit("facebook.com");     // Visit facebook.com
        browserHistory.visit("youtube.com");      // Visit youtube.com

        System.out.println(browserHistory.back(1)); // Move back to facebook.com -> "facebook.com"
        System.out.println(browserHistory.back(1)); // Move back to google.com -> "google.com"
        System.out.println(browserHistory.forward(1)); // Move forward to facebook.com -> "facebook.com"

        browserHistory.visit("linkedin.com");     // Visit linkedin.com

        System.out.println(browserHistory.forward(2)); // Cannot move forward -> "linkedin.com"
        System.out.println(browserHistory.back(2)); // Move back to google.com -> "google.com"
        System.out.println(browserHistory.back(7)); // Move back to leetcode.com -> "leetcode.com"
    }
}
