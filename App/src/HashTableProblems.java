// Problem 1: Social Media Username Availability Checker
import java.util.*;

class UsernameChecker {
    private HashMap<String, Integer> users = new HashMap<>();
    private HashMap<String, Integer> attempts = new HashMap<>();

    public boolean checkAvailability(String username) {
        attempts.put(username, attempts.getOrDefault(username, 0) + 1);
        return !users.containsKey(username);
    }

    public void register(String username, int userId) {
        users.put(username, userId);
    }

    public List<String> suggestAlternatives(String username) {
        List<String> list = new ArrayList<>();
        list.add(username + "1");
        list.add(username + "2");
        list.add(username.replace("_", "."));
        return list;
    }

    public String getMostAttempted() {
        String maxUser = "";
        int max = 0;
        for (String u : attempts.keySet()) {
            if (attempts.get(u) > max) {
                max = attempts.get(u);
                maxUser = u;
            }
        }
        return maxUser;
    }

    public static void main(String[] args) {
        UsernameChecker uc = new UsernameChecker();
        uc.register("john_doe", 1);
        System.out.println(uc.checkAvailability("john_doe"));
        System.out.println(uc.checkAvailability("jane_smith"));
        System.out.println(uc.suggestAlternatives("john_doe"));
    }
}