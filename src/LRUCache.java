// PROBLEM : 146
import java.util.*;

class LRUCache {
    // same as hashmap but maintains the insertion order.
    // it uses a doubly linked list internally to keep track of the insertion order.
   LinkedHashMap<Integer, Integer> cache;
    int capacity;
    public LRUCache(int capacity) {
        this.cache = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            int val = cache.get(key);
            cache.remove(key);
            cache.put(key, val);
          return  val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            cache.remove(key);
        } else {
            if(capacity == cache.size()) {
                cache.remove(cache.keySet().iterator().next());
            }
        }
        
        cache.put(key, value);
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */