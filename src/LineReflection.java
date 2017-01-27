import java.util.*;

/**
 * Created by lizheng on 2017/1/24.
 */
public class LineReflection {
    public boolean isReflected(int[][] points){
        if (points == null){
            return false;
        }
        Set<List<Integer>> pset = new HashSet<>();
        for (int i = 0; i < points.length; i++) {
            List<Integer> p = Arrays.asList(points[i][0], points[i][1]);
            pset.add(p);
        }
        List<List<Integer>> plist = new ArrayList<>(pset);

        Collections.sort(plist, (a, b) -> {
            if (a.get(0) < b.get(0)){
                return -1;
            }
            else{
                return 1;
            }
        });
        System.out.println(plist);
        int n = plist.size();
        if (n < 2){
            return true;
        }
        List<Integer> ps = plist.get(0), pe = plist.get(n - 1);
        if (ps.get(1) != pe.get(1)) {
            return false;
        }
        int sum = ps.get(0) + pe.get(0);
        System.out.println("sum = " + sum);
        for (int i = 1, j = n - 2; i <= j; i++, j--){
            List<Integer> p1 = plist.get(i), p2 = plist.get(j);
            int curSum = p1.get(0) + p2.get(0);
            if (curSum != sum || p1.get(1) != p2.get(1)){
                System.out.println(curSum);
                System.out.println(sum);
                System.out.println("bere");
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        int[] ch = new int[256];
        Character c = 'a';
        ch[c]++;
        for (int i = 0; i < ch.length; i++){
            if (ch[i] != 0){
                System.out.println(i);
                System.out.println(ch[i]);
            }

        }
        Set<Integer> s = new HashSet<>();

    }
}
