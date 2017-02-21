import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by lizheng on 2017/1/25.
 */
public class PredicttheWinner {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        int[] sum = new int[n];
        for (int i = 0; i < n; i++){
            sum[i] = i == 0? nums[i] : sum[i - 1] + nums[i];
            dp[i][i] = nums[i];
        }
        for (int l = 2; l <= n; l++){
            for (int i = 0; i + l - 1 < n; i++){
                int j = i + l - 1;
                int s1 = nums[i] + (sum[j] - sum[i])- dp[i+1][j];
                int s2 = nums[j] + (sum[j-1] - sum[i] + nums[i]) - dp[i][j-1];
                System.out.println("i = " + i + ", j = " + j + ", dp[i][j] = " + dp[i][j]);
                dp[i][j] = s1 > s2? s1 : s2;
            }
        }
        System.out.println(dp[0][n-1]);
        return 2*dp[0][n-1] >= sum[n-1];
    }

    public static void main(String[] args){
//        int[] nums = {1, 5, 2};
//        new PredicttheWinner().PredictTheWinner(nums);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(3,2);
        map.put(4,3);
        System.out.println(map.entrySet().stream().filter(entry -> entry.getValue() == 3).map(entry -> entry.getValue()).collect(Collectors.toList()));

    }
}
