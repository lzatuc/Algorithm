import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by li on 2016/12/26.
 */
public class NumberofBoomerangs
{

    public  static  void main(String args[]){
        int a[][] = {{0,0},{1,0},{-1,0},{0,1},{0,-1}};
        int res = numberOfBoomerangs(a);
        System.out.println(res);
    }

    public int numberOfBoomerangs1(int[][] points) {
        if (points == null || points.length == 0){
            return 0;
        }
        int res = 0, n = points.length;
        for (int i = 0; i < n; i++){
            List<Integer> dists = new ArrayList<>();
            int x = points[i][0], y = points[i][1];
            for (int j = 0; j < n; j++){
                if (j == i){
                    continue;
                }
                int d = dist(x, y, points[j][0], points[j][1]);
                dists.add(d);
            }
            Collections.sort(dists);

            int j;

            for (int k = 0; k < dists.size(); k = j){
                int d0 = dists.get(k);
                for (j = k + 1; j < dists.size(); j++){
                    int d = dists.get(j);
                    if (d != d0){
                        break;
                    }
                }
                int total = j - k;
                res += (total - 1) * total;
            }
        }

        return res;
    }

    public static int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length == 0){
            return 0;
        }
        int res = 0, n = points.length;

        for (int i = 0; i < n; i++){
            Map<Integer, Integer> count = new HashMap<>();
            int x = points[i][0], y = points[i][1];
            for (int j = 0; j < n; j++){
                if (j == i){
                    continue;
                }
                int d = dist(x, y, points[j][0], points[j][1]);
                count.put(d, count.getOrDefault(d, 0) + 1);
//                for (Integer c : count.values()){
//                    res += (c - 1) * c;
//                }

            }
            for (Map.Entry<Integer, Integer> entry : count.entrySet()){
                int v = entry.getValue();
                res += (v - 1) * v;
            }
        }
        return res;
    }

    private static int dist(int x1, int y1, int x2, int y2){
        int xd = x1 - x2;
        int yd = y1 - y2;
        return xd*xd + yd*yd;
    }
}
