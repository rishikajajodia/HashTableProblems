// Problem 6: Distributed Rate Limiter
import java.util.*;

class TokenBucket {
    int tokens;
    int max;
    long lastRefill;

    TokenBucket(int max) {
        this.max = max;
        this.tokens = max;
        this.lastRefill = System.currentTimeMillis();
    }
}

class RateLimiter {
    HashMap<String, TokenBucket> clients = new HashMap<>();

    public boolean check(String clientId) {
        clients.putIfAbsent(clientId, new TokenBucket(1000));
        TokenBucket bucket = clients.get(clientId);

        if (bucket.tokens > 0) {
            bucket.tokens--;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        RateLimiter rl = new RateLimiter();
        System.out.println(rl.check("abc123"));
    }
}