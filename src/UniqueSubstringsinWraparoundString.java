import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * Created by li on 2016/12/13.
 */
public class UniqueSubstringsinWraparoundString
{
    public int findSubstringInWraproundString(String p) {
        if (p == null || p.isEmpty()){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int i, endIndex, len;
        len = p.length();
        map.put(p.charAt(len - 1), 1);
        endIndex = len - 1;
        i = len - 2;
        while(i >= 0){
            Character c1 = p.charAt(i), c2 = p.charAt(i + 1);
            if (c1 + 1 == c2 || c1 == 'z' && c2 == 'a'){
                if (map.containsKey(c1)){
                    int curMaxLen = map.get(c1);
                    int newLen = endIndex - i + 1;
                    if (newLen > curMaxLen){
                        map.put(c1, newLen);
                    }
                }
                else{
                    map.put(c1, endIndex - i + 1);
                }
            }
            else{
                endIndex = i;
            }
            i--;
        }
        int res = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            res += entry.getValue();
        }
        return res;
    }

    public static void main(String args[]){
//        int res = new UniqueSubstringsinWraparoundString().findSubstringInWraproundString("abc");
//        System.out.println(res);
//        int a[] = {1,2};
//        Arrays.stream(a).forEach();
        Map<Integer, Integer> map = new HashMap<>();
       // map.keySet().stream().
                //map.keySet()
     //   map.getOrDefault();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
//        pq.stream().limit(5).collect(Collectors.toList());
        pq.offer(5);
//        System.out.println(pq.peek());
//        pq.offer(3);
//        System.out.println(pq.peek());
//        pq.offer(10);
//        System.out.println(pq.peek());
//        pq.poll()
        int n = 25;
        System.out.println(Math.round(Math.log(n) / Math.log(3)));
//        System.out.println(Math.log(n) / Math.log(3));
        double res= Math.abs(Math.pow(3, Math.round(Math.log(n) / Math.log(3))) - n);
//        Math.random()
        System.out.println(res);
    }
}
