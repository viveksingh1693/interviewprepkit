package cache;

import java.util.*;

public class LRUCacheUsingBuiltInDL {
    private int capacity;
    private Map<Integer, Integer> cacheMap;
    private LinkedList<Integer> lruList;

    LRUCacheUsingBuiltInDL(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.lruList = new LinkedList<>();
    }

    public int get(int key) {
        if (!cacheMap.containsKey(key)) {
            return -1;
        }
        lruList.remove(key);
        lruList.addFirst(key);
        return cacheMap.get(key);

    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            cacheMap.put(key, value);
            lruList.remove(key);
            lruList.remove(Integer.valueOf(key));
        } else {
            if (cacheMap.size() >= capacity) {
                Integer leastRecentlyUsed = lruList.removeLast();
                cacheMap.remove(leastRecentlyUsed);
                cacheMap.put(key, value);
            }
        }
        //update the most recently used
        lruList.add(key);
    }
}


