// Problem 2: E-commerce Flash Sale Inventory Manager
import java.util.*;

class FlashSale {
    HashMap<String, Integer> inventory = new HashMap<>();
    Queue<Integer> waitingList = new LinkedList<>();

    public FlashSale() {
        inventory.put("IPHONE15_256GB", 100);
    }

    public int checkStock(String productId) {
        return inventory.getOrDefault(productId, 0);
    }

    public synchronized String purchaseItem(String productId, int userId) {
        int stock = inventory.get(productId);

        if (stock > 0) {
            inventory.put(productId, stock - 1);
            return "Success, remaining " + (stock - 1);
        }

        waitingList.add(userId);
        return "Added to waiting list position #" + waitingList.size();
    }

    public static void main(String[] args) {
        FlashSale fs = new FlashSale();
        System.out.println(fs.checkStock("IPHONE15_256GB"));
        System.out.println(fs.purchaseItem("IPHONE15_256GB", 12345));
    }
}