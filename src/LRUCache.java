import java.util.*;
import java.util.LinkedHashMap;

/**
 * Created by li on 2016/12/28.
 */
public class LRUCache
{

    public static void main(String args[]){
//        1,[set(2,1),get(2),set(3,2),get(2),get(3)]
//        List<Integer> vector = new Vector<>();
//        LRUCache lruCache = new LRUCache(1);
//        lruCache.set(2, 1);
//        vector.add(lruCache.get(2));
//        lruCache.set(3, 2);
//        vector.add(lruCache.get(2));
//        vector.add(lruCache.get(3));
//        System.out.println(vector);
        Map<Integer, Integer> map = new LinkedHashMap<>();
        map.put(1, 2);
        map.put(2, 3);
        System.out.println(map);

        map.put(null, null);



        map.put(1, 3);
        System.out.println(map);
//        map.remove(1);
//        System.out.println(map);
//        map.put(1, 2);
//        System.out.println(map);
    }

    private int capacity;
    private Map<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (cache.containsKey(key)){
            int value = cache.get(key);
            pushToTail(key, value);
            return value;
        }
        else{
            return -1;
        }
    }

    public void set(int key, int value) {
        if (cache.containsKey(key)){
            pushToTail(key, value);
        }
        else{
            if (cache.size() == capacity){
                int keyToRemove = cache.keySet().iterator().next();
                cache.remove(keyToRemove);
            }
            cache.put(key, value);
        }
//        if (cache.size() == capacity){
//            if (capacity == 0){
//                return;
//            }
//            if (cache.containsKey(key)){
//                pushToTail(key, value);
//            }
//            else{
//                int keyToRemove = cache.keySet().iterator().next();
//                cache.remove(keyToRemove);
//                cache.put(key, value);
//            }
//        }
//        else {
//            cache.put(key, value);
//        }
    }

    private void pushToTail (int key, int value){
        cache.remove(key);
        cache.put(key, value);
    }
}
