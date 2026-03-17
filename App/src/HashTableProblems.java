// Problem 3: DNS Cache with TTL
import java.util.*;

class DNSEntry {
    String ip;
    long expiry;

    DNSEntry(String ip, int ttl) {
        this.ip = ip;
        this.expiry = System.currentTimeMillis() + ttl * 1000;
    }
}

class DNSCache {
    HashMap<String, DNSEntry> cache = new HashMap<>();
    int hits = 0;
    int misses = 0;

    public String resolve(String domain) {
        if (cache.containsKey(domain)) {
            DNSEntry e = cache.get(domain);
            if (System.currentTimeMillis() < e.expiry) {
                hits++;
                return e.ip;
            }
        }

        misses++;
        String ip = "172.217.14." + new Random().nextInt(255);
        cache.put(domain, new DNSEntry(ip, 300));
        return ip;
    }

    public void stats() {
        int total = hits + misses;
        System.out.println("Hit Rate: " + (hits * 100.0 / total) + "%");
    }

    public static void main(String[] args) {
        DNSCache dns = new DNSCache();
        System.out.println(dns.resolve("google.com"));
        System.out.println(dns.resolve("google.com"));
        dns.stats();
    }
}