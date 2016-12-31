import java.util.*;
import java.util.LinkedHashMap;

/**
 * Created by li on 2016/12/28.
 */
public class LFUCache
{
//    ["LFUCache","set","set","get","set","get","get","set","get","get","get"]
//            [[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]

//    ["LFUCache","set","get","set","get","get"]
//    [[1],[2,1],[2],[3,2],[2],[3]]

//    ["LFUCache","set","set","set","set","set","get","set","get","get","set","get","set","set","set","get","set","get","get","get","get","set","set","get","get","get","set","set","get","set","get","set","get","get","get","set","set","set","get","set","get","get","set","set","get","set","set","set","set","get","set","set","get","set","set","get","set","set","set","set","set","get","set","set","get","set","get","get","get","set","get","get","set","set","set","set","get","set","set","set","set","get","get","get","set","set","set","get","set","set","set","get","set","set","set","get","get","get","set","set","set","set","get","set","set","set","set","set","set","set"]


    public static void main(String args[]){

        Map<Integer, Set<Integer>> map = new HashMap<>();

        Set<Integer> set = new HashSet<>();

        set.add(5);

        map.put(55, set);

        Set<Integer> s = map.get(55);

        s.remove(5);

        if (s.isEmpty()){
            System.out.println("true");
            map.remove(55);
        }

        System.out.println(map);


//        lfuCache.set(1, 1);
//        lfuCache.set(2, 2);
//        lst.add(lfuCache.get(1));
//        lfuCache.set(3, 3);
//        lst.add(lfuCache.get(2));
//        lst.add(lfuCache.get(3));
//        lfuCache.set(4, 4);
//        lst.add(lfuCache.get(1));
//        lst.add(lfuCache.get(3));
//        lst.add(lfuCache.get(4));
//        System.out.println(lst);
    }

    private Map<Integer, Integer> cache;
    private Map<Integer, Integer> k2c;
    private Map<Integer, Set<Integer>> c2k;

    // count -> key1, key2, ...;
    // key -> count;

    private int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        k2c = new HashMap<>();
        c2k = new LinkedHashMap<>();
        cache = new HashMap<>();
    }

    public int get(int key) {
        if (cache.containsKey(key)){
            insertK2c(key);
            insertC2k(key, k2c.get(key));
            return cache.get(key);
        }
        else{
            return -1;
        }
    }

    public void set(int key, int value) {
        if (capacity == 0){
            return;
        }
        if (cache.size() == capacity){
            int keyToRemove = c2k.values()
                                 .iterator()
                                 .next()
                                 .iterator()
                                 .next();
            cache.remove(keyToRemove);
            k2c.remove(key);
            removeFromC2k();
        }
        insertK2c(key);
        insertC2k(key, k2c.get(key));
        cache.put(key, value);
    }

    private void insertK2c(int key){
        int count = k2c.getOrDefault(key, 0);
        k2c.put(key, count + 1);
    }

    private void insertC2k(int key, int count){
        Set<Integer> oldKeys = c2k.get(count - 1);
        Set<Integer> newKeys = c2k.get(count);
        if (oldKeys != null) {
            oldKeys.remove(key);
            if (oldKeys.isEmpty()){
                c2k.remove(count - 1);
            }
        }
        if (newKeys == null){
            newKeys = new LinkedHashSet<>();
            newKeys.add(key);
            c2k.put(count, newKeys);
        }
        else{
            newKeys.add(key);
        }
    }

    private void removeFromC2k(){
        Set<Integer> keys = c2k.values().iterator().next();
        int firstKey = keys.iterator().next();
        keys.remove(firstKey);
    }
}
