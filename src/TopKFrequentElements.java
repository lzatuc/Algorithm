/**
 * Created by li on 2016/12/14.
 */
import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentElements
{
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        Arrays.stream(nums).forEach(x -> count.put(x, count.getOrDefault(x, 0) + 1));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> count.get(a) - count.get(b));
        count.keySet().forEach(x -> {
            if (pq.size() < k) {
                pq.offer(x);
            }
            else {
                if (count.get(pq.peek()) < count.get(x)) {
                    pq.poll();
                    pq.offer(x);
                }
            }
        });
        return pq.stream().limit(k).collect(Collectors.toList());
    }

    public static void main(String args[]){
        int nums[] = {3,0,1,0};
        int k = 1;
        List<Integer> res = new TopKFrequentElements().topKFrequent(nums, k);
        System.out.println(res);
    }
}
