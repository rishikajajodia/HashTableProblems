// Problem 10: Multi-Level Cache System
import java.util.*;

class MultiLevelCache {

    LinkedHashMap<String, String> L1 = new LinkedHashMap<>(10000, 0.75f, true);
    HashMap<String, String> L2 = new HashMap<>();
    HashMap<String, String> DB = new HashMap<>();

    public MultiLevelCache() {
        DB.put("video_999", "VideoData");
    }

    public String getVideo(String id) {

        if (L1.containsKey(id)) {
            System.out.println("L1 HIT");
            return L1.get(id);
        }

        if (L2.containsKey(id)) {
            System.out.println("L2 HIT");
            String data = L2.get(id);
            L1.put(id, data);
            return data;
        }

        System.out.println("DB HIT");
        String data = DB.get(id);
        if (data != null) L2.put(id, data);

        return data;
    }

    public static void main(String[] args) {
        MultiLevelCache cache = new MultiLevelCache();
        cache.getVideo("video_999");
        cache.getVideo("video_999");
    }
}