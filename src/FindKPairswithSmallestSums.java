import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by li on 2016/12/24.
 */
public class FindKPairswithSmallestSums
{
    public static void main(String args[]){
        int A[] = {1, 2, 4}, B[] = {-1, 1, 2};
        List<int[]> res = kSmallestPairs(A, B, 12);
        res.forEach(r -> System.out.println(r[0] + ",  " + r[1]));
//        Set<List<Integer>> set = new HashSet<>();
//        List<Integer> lst = Arrays.asList(1,2);
//        List<Integer> lst1 = Arrays.asList(2,1);
//        set.add(lst);
//        if (set.contains(lst1)){
//            System.out.println("true");
//        }
//        else{
//            System.out.println("false");
//        }
//        List<List<Integer>> lst = new ArrayList<>();
//        List<Integer> pointer;
//        pointer = Arrays.asList(1,2);
//        lst.add(pointer);
//        pointer = Arrays.asList(3,4);
//        lst.add(pointer);
//        System.out.println(lst);
    }

    public static List<int[]> kSmallestPairs(int[] A, int[] B, int K) {
        if (A.length == 0 || B.length == 0){
            return new ArrayList<>();
        }
        int total = 0;
        List<int[]> res = new ArrayList<>();
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((x, y) -> {
            int sum1 = A[x.get(0)] + B[x.get(1)], sum2 = A[y.get(0)] + B[y.get(1)];
            if (sum1 < sum2){
                return -1;
            }
            else{
                return 1;
            }
        });
        Set<List<Integer>> visit = new HashSet<>();
        Arrays.sort(A);
        Arrays.sort(B);
        List<Integer> elem = Arrays.asList(0, 0);
        pq.add(elem);
        visit.add(elem);
        while(total < K && !pq.isEmpty()){
            List<Integer> head = pq.poll();
            int ai = head.get(0), bi = head.get(1);
            res.add(new int[]{A[ai], B[bi]});
            total++;
            List<Integer> next;
            if (ai + 1 < A.length){
                next = Arrays.asList(ai + 1, bi);
                if (!visit.contains(next)){
                    visit.add(next);
                    pq.offer(next);
                }
            }
            if (bi + 1 < B.length){
                next = Arrays.asList(ai, bi + 1);
                if (!visit.contains(next)){
                    visit.add(next);
                    pq.offer(next);
                }
            }
        }
        return res;
    }
}
