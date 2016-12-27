import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by li on 2016/12/26.
 */
public class LinkedHashMap
{
    public static void main(String[] args){
        Map<Integer, Integer> lhmap = new java.util.LinkedHashMap<>();
        for (int i = 5; i < 10; i++){
            lhmap.put(i, i * 3);
        }




//        for (Map.Entry<Integer, Integer> entry : lhmap.entrySet()){
//            System.out.println(entry.getKey() + ", " + entry.getValue());
//        }
//        for (Integer itg : lhmap.keySet()){
//            System.out.println(itg);
//        }
//
//        for (Integer itg : lhmap.values()){
//            System.out.println(itg);
//        }
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 20; i<=25; i++){
            set.add(i);
        }
        List<Integer> list = new ArrayList<>();

//        set.add(22);

//        set.remove(22);
        for (Integer itg : set){
            System.out.println(itg);
        }

//        lhmap.remove(6);

//        for (Map.Entry<Integer, Integer> entry : lhmap.entrySet()){
//            System.out.println(entry.getKey() + ", " + entry.getValue());
//        }

        set.iterator().next();

    }
}
