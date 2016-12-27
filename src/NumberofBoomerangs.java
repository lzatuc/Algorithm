import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by li on 2016/12/26.
 */
public class NumberofBoomerangs
{

    public int numberOfBoomerangs(int[][] points) {
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

    private int dist(int x1, int y1, int x2, int y2){
        int xd = x1 - x2;
        int yd = y1 - y2;
        return xd*xd + yd*yd;
    }
}
