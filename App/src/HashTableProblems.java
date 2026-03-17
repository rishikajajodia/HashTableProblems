// Problem 9: Two Sum Financial Transactions
import java.util.*;

class Transaction {
    int id;
    int amount;

    Transaction(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }
}

class TwoSumSystem {
    public List<int[]> findTwoSum(List<Transaction> list, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<int[]> res = new ArrayList<>();

        for (Transaction t : list) {
            int complement = target - t.amount;

            if (map.containsKey(complement)) {
                res.add(new int[]{map.get(complement), t.id});
            }

            map.put(t.amount, t.id);
        }
        return res;
    }

    public static void main(String[] args) {
        List<Transaction> list = Arrays.asList(
                new Transaction(1, 500),
                new Transaction(2, 300),
                new Transaction(3, 200)
        );

        TwoSumSystem ts = new TwoSumSystem();
        System.out.println(ts.findTwoSum(list, 500));
    }
}