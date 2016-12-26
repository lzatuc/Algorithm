import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by li on 2016/12/24.
 */
public class TotalHammingDistance
{
    public static void main(String args[]){
        int nums[] = {4,2,0};
        String s = "a";
        s += "b";
        Map<Character, Integer> freq = new HashMap<>();
        freq.put('a', 2);
        freq.put('b', 1);
        freq.put('c', 3);
        Set<Character>  set = new TreeSet<>((a, b) -> {
            if (freq.get(a) < freq.get(b)){
                return 1;
            }
            else{
                return -1;
            }
        });
        set.add('a');
        set.add('c');
        set.add('b');

//        freq.keySet()
        Set<Integer> myset = new HashSet<>();

        myset.add(5);
        myset.add(6);
        myset.add(3);
        myset.add(4);

        for (Integer integer : myset){
            System.out.println(integer);
        }

//        String s= "ab";
        Character c = s.charAt(0);
        Collections.sort(new ArrayList<>(myset), (a, b) -> {
            if (a > b){
                return 1;
            }
            else{
                return -1;
            }
        });
        List<int[]> list = new ArrayList<>();

        list.add(new int[]{1,2});

    }
}
