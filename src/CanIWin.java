import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by li on 2016/12/11.
 */
public class CanIWin
{
    public static void main(String args[]){
//        boolean res = new CanIWin().canIWin(18, 50);
//        System.out.println(res);

        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        map.put(1,set);
        set.add(5);
        System.out.println(map.get(1));

//        int lasthouse = -1,lastheaer = -2;//= -1;
//        Integer point[] = new Integer[5];
//        List<Integer> points = Arrays.asList(point);
//        Collections.sort(points, (a, b) -> {
//            if (Math.abs(a) < Math.abs(b)){
//                return -1;
//            }
//            else{
//                return 1;
//            }
//        });
//        List<Integer> lst = Arrays.asList(-3,1,2);
//        List<Integer> lst1 = Arrays.asList(5,-4,2);
//        Collections.sort(lst, (a, b) -> {
//            if (Math.abs(a) < Math.abs(b)){
//                return -1;
//            }
//            else{
//                return 1;
//            }
//        });
//        System.out.println(lst);
    }

    private Map<List<Integer>, Boolean> map = new HashMap<>();

    private boolean canIWin (int maxChoose, int total){
        map.clear();
        int sum = maxChoose * (maxChoose + 1) / 2;
        if (sum < total){
            return false;
        }
        return search(maxChoose, 0, total);
    }

    private boolean search (int maxChoose, int curState, int total){
        for (int i = maxChoose; i >= 1; i--){
            int twoPower = (1 << (i - 1));
            int nextState = (curState | twoPower);
            if (nextState != curState && i >= total){
                map.put(Arrays.asList(curState, total), true);
                return true;
            }
        }

        for (int i = 1; i <= maxChoose; i++){
            int twoPower = (1 << (i - 1));
            int nextState = (curState | twoPower);
            if (nextState != curState){
                List<Integer> pair = Arrays.asList(nextState, total - i);
                boolean isSecondWin;
                if (map.containsKey(pair)){
                    isSecondWin = map.get(pair);
                }
                else{
                    isSecondWin = search(maxChoose, nextState, total - i);
                }
                if (!isSecondWin){
                    map.put(Arrays.asList(curState, total), true);
                    return true;
                }
            }
        }
        map.put(Arrays.asList(curState, total), false);
        return false;
    }
}
