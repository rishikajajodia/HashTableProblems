// Problem 5: Real-Time Analytics Dashboard
import java.util.*;

class Analytics {
    HashMap<String, Integer> pageViews = new HashMap<>();
    HashMap<String, Set<String>> uniqueVisitors = new HashMap<>();
    HashMap<String, Integer> sourceCount = new HashMap<>();

    public void processEvent(String url, String userId, String source) {
        pageViews.put(url, pageViews.getOrDefault(url, 0) + 1);

        uniqueVisitors.computeIfAbsent(url, k -> new HashSet<>()).add(userId);

        sourceCount.put(source, sourceCount.getOrDefault(source, 0) + 1);
    }

    public void dashboard() {
        System.out.println("Top Pages:");
        for (String p : pageViews.keySet()) {
            System.out.println(p + " - " + pageViews.get(p) + " views");
        }
    }

    public static void main(String[] args) {
        Analytics a = new Analytics();
        a.processEvent("/news", "user1", "google");
        a.processEvent("/news", "user2", "facebook");
        a.dashboard();
    }
}
