import java.util.*;

public class LRUCache {

    class Pair implements Comparable<Pair> {
        int key;
        int val;
        long ticker;

        Pair(int key, int val, long tick) {
            this.key = key;
            this.val = val;
            ticker = tick;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.ticker < other.ticker) return -1;
            if (this.ticker > other.ticker) return 1;
            return 0;
        }

    }

    long tick = 0;

    PriorityQueue<Pair> cache;
    HashMap<Integer, Pair> lookupTable;
    int capcity;

    public LRUCache(int capacity) {
        cache = new PriorityQueue<>(capacity);
        lookupTable = new HashMap<>(capacity);
        capcity = capacity;
    }

    public int get(int key) {
        if (!lookupTable.containsKey(key)) return -1;
        Pair elem = lookupTable.get(key);
        cache.remove(elem);
        elem.ticker = tick++;
        cache.add(elem);
        return elem.val;
    }

    public void set(int key, int value) {
        // should we incHit?!
        if (lookupTable.containsKey(key)) {
            Pair elem = lookupTable.get(key);
            cache.remove(elem);
            elem.ticker = tick++;
            cache.add(elem);
            elem.val = value;
        } else {
            if (cache.size() == capcity) {
                // remove a fucker first
                Pair abandon = cache.poll();
                lookupTable.remove(abandon.key);
            }
            Pair newElem = new Pair(key, value, tick++);
            cache.add(newElem);
            lookupTable.put(key, newElem);
        }
    }
}