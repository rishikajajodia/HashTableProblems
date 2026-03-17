// Problem 4: Plagiarism Detection System
import java.util.*;

class PlagiarismDetector {
    HashMap<String, Set<String>> index = new HashMap<>();

    public List<String> generateNgrams(String text, int n) {
        String[] words = text.split(" ");
        List<String> grams = new ArrayList<>();

        for (int i = 0; i <= words.length - n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) sb.append(words[i + j]).append(" ");
            grams.add(sb.toString().trim());
        }
        return grams;
    }

    public void addDocument(String docId, String text) {
        for (String gram : generateNgrams(text, 3)) {
            index.computeIfAbsent(gram, k -> new HashSet<>()).add(docId);
        }
    }

    public void analyze(String docId, String text) {
        int matches = 0;
        List<String> grams = generateNgrams(text, 3);

        for (String g : grams) {
            if (index.containsKey(g)) matches++;
        }

        double similarity = matches * 100.0 / grams.size();
        System.out.println("Similarity: " + similarity + "%");
    }

    public static void main(String[] args) {
        PlagiarismDetector pd = new PlagiarismDetector();
        pd.addDocument("doc1", "this is a simple essay test");
        pd.analyze("doc2", "this is a simple essay example");
    }
}