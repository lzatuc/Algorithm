import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by lizheng on 2017/2/10.
 */
public class Intro {
    public static void main(String[] args){
//        int[] a = {1, 2, 3};
//        System.out.println(a);
//        Integer[] a = {1,2,3};
//        List<Integer> lst = Arrays.asList(a);
//        System.out.println(lst);
        int[] a = {1,2,3};
//        int[][] a = {{1,2}};

//        Arrays.stream(a).boxed().collect(Collectors.toList());
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        list1.add(1);
        list2.add(2);
        list2.add(1);
        list1.addAll(list2);
        System.out.println(list1);
        list1.remove(Integer.valueOf(1));
        System.out.println(list1);
        list1.set(1, 100);
        int[] res = list1.stream().mapToInt(i -> 2*i).toArray();
        for (int i : res){
            System.out.println(i);
        }
        int area = 4;
        int root = (int)Math.sqrt(4);
        System.out.println(root);

    }
}
