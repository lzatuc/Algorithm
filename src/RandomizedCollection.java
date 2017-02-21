import java.util.*;

/**
 * Created by lizheng on 2017/2/13.
 */
public class RandomizedCollection {

    public Map<Integer, Set<Integer>> vToIdxSet;
    public List<Integer> v;
    public Random random;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        vToIdxSet = new HashMap<>();
        v = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contained = false;
        Set<Integer> idxSet = vToIdxSet.getOrDefault(val, null);
        if (idxSet != null){
            contained = true;
        }
        else{
            idxSet = new HashSet<>();
            vToIdxSet.put(val, idxSet);
        }
        v.add(val);
        idxSet.add(v.size() - 1);
        return !contained;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        Set<Integer> idxSet = vToIdxSet.getOrDefault(val, null);
        if (idxSet == null){
            return false;
        }
        //remove the last element

        int n = v.size(), lastvalue = v.get(n - 1);
        if (val == lastvalue){
            v.remove(n - 1);
            idxSet.remove(n - 1);
        }
        else{
            int idx = idxSet.iterator().next();
            v.set(idx, lastvalue);
            v.remove(n - 1);
            idxSet.remove(idx);
            if (idxSet.isEmpty()){
                vToIdxSet.remove(val);
            }
            Set<Integer> lastIdxSet = vToIdxSet.get(lastvalue);
            lastIdxSet.remove(n - 1);
            lastIdxSet.add(idx);
        }
        return true;
//        Set<Integer> idxSet = vToIdxSet.getOrDefault(val, null);
//        if (idxSet == null) {
//            return false;
//        }
//        int idx = idxSet.iterator().next();
//
//        int size = v.size();
//        System.out.println("size = " + size);
//        System.out.println(v);
//        int lastvalue = v.get(size - 1);
//        System.out.println("value = " + val);
////        System.out.println("idxset = " + new ArrayList<>(idxSet));
////        System.out.println(v);
////        System.out.println("lastvalue = " + lastvalue);
//
//        v.set(idx, lastvalue);
//        v.remove(size - 1);
//        System.out.println(v);
//        System.out.println("in function" + vToIdxSet);
//
//        Set<Integer> lastIdxSet = vToIdxSet.get(lastvalue);
//        System.out.println("lastidxset = " + lastIdxSet);
//        lastIdxSet.remove(size - 1);
//        System.out.println(lastIdxSet);
//        System.out.println("idx = " + idx);
//        lastIdxSet.add(idx);
//        System.out.println("after add lastidxset = " + lastIdxSet);
//
//        idxSet.remove(idx);
//        if (idxSet.isEmpty()){
//            vToIdxSet.remove(val);
//        }
//        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int idx = random.nextInt(v.size());
        return v.get(idx);
    }

    public static int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;

        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i-1][j] + (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }

    class Node{
        Node left, right;
        int val;
    }
    Node root = new Node();

    void add(int x){
        Node node = new Node();
        node.val = x;
        root.left = node;
    }

    public static void main(String[] args){

        String x = "" + 'a' + 'b'+ 'c';

//        System.out.println(x.compareTo(y));
//        RandomizedCollection rc = new RandomizedCollection();
//        rc.add(5);
//
//        System.out.println(rc.root.left.val);

//        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
//            return Math.abs(a) - Math.abs(b);
//        });
//        pq.add(5);
//        pq.add(1);
//        pq.add(-3);
//        pq.add(2);
//        while(!pq.isEmpty()){
//            System.out.println(pq.poll());
//        }
//
//
//        Integer a[] = {3,1,2};
//        List<Integer> list = Arrays.asList(a);
//        Collections.sort(list, (x, y) -> {
//            if (x > y){
//                return -1;
//            }
//            else{
//                return 1;
//            }
//        });
//        System.out.println(list);
//        int amount = 3;
//        int[] coins = {1,2,2,2};
//        System.out.println(change(amount, coins));
//        List<Integer> list = new LinkedList<>();
//        list.add(1);
//        list.add(2);
//        ListIterator<Integer> iterator = list.listIterator();
//        iterator.next();
//        iterator.next();
//        iterator.add(5);
//        iterator.remove();
//
//        Map<String, Iterator<Integer>> map = new HashMap<>();
//
//        System.out.println(list);
//        System.out.println(iterator.hasNext());

//        Set<Integer> set = new TreeSet<>();
//        set.add(4);
//        set.add(3);
//        set.add(5);
//        System.out.println(set);
//        List<Integer> list = new ArrayList<>(set);
//        System.out.println(list);
//        RandomizedCollection randomizedCollection = new RandomizedCollection();
//        randomizedCollection.insert(0);
//        randomizedCollection.remove(0);
//        randomizedCollection.insert(-1);
//        randomizedCollection.remove(0);
//        randomizedCollection.insert(1);
//        randomizedCollection.insert(2);
//        randomizedCollection.insert(3);
//        randomizedCollection.insert(3);


//        System.out.println(randomizedCollection.vToIdxSet);
//        randomizedCollection.remove(2);
//        System.out.println(randomizedCollection.vToIdxSet);
//        randomizedCollection.remove(3);
//        System.out.println(randomizedCollection.vToIdxSet);
//        randomizedCollection.remove(0);
//        randomizedCollection.getRandom();
//        randomizedCollection.getRandom();
//        randomizedCollection.getRandom();
//        randomizedCollection.getRandom();

    }
}
//["RandomizedCollection","insert","insert","insert","insert","insert","remove","remove","remove","getRandom","getRandom","getRandom","getRandom"]
//        [[],[0],[1],[2],[3],[3],[2],[3],[0],[],[],[],[]]
