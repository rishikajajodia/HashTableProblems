// Problem 7: Autocomplete System
import java.util.*;

class Autocomplete {
    HashMap<String, Integer> freq = new HashMap<>();

    public void addQuery(String q) {
        freq.put(q, freq.getOrDefault(q, 0) + 1);
    }

    public List<String> search(String prefix) {
        List<String> res = new ArrayList<>();

        for (String q : freq.keySet()) {
            if (q.startsWith(prefix)) res.add(q);
        }

        res.sort((a, b) -> freq.get(b) - freq.get(a));
        return res.subList(0, Math.min(10, res.size()));
    }

    public static void main(String[] args) {
        Autocomplete ac = new Autocomplete();
        ac.addQuery("java tutorial");
        ac.addQuery("javascript");
        ac.addQuery("java download");

        System.out.println(ac.search("jav"));
    }
}