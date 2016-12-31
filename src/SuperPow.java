import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by li on 2016/12/27.
 */
public class SuperPow
{
    public static void main(String args[]){
        int[] b = {2, 0, 0};
        int a = 2147483647;
        int res = superPow(a, b);
        System.out.println(res);
    }

    public static int superPow(int a, int[] b) {
        a %= 1937;
        List<Integer> pow = new ArrayList<>();
        for (int i = 0; i < b.length; i++){
            pow.add(b[i]);
        }
        return solve(a, pow);
    }

    private static int solve(int a, List<Integer> pow){
        if (pow.size() == 1 && pow.get(0) == 0){
            return 1;
        }
        List<Integer> powBy2 = divideBy2(pow);
//        System.out.println(powBy2);
        int t = solve(a, powBy2);
        if (pow.get(pow.size() - 1) % 2 == 1){
            return (t * t) % 1937 * a % 1937;
        }
        else{
            return t * t % 1937;
        }
    }

    static List<Integer> divideBy2(List<Integer> input){
        List<Integer> output = new ArrayList<>();
        if (input.size() == 1 && (input.get(0) == 0 || input.get(0) == 1)){
            output.add(0);
        }
        else{
            int remainder = 0;
            for (int i = 0; i < input.size(); i++){
                int cur = input.get(i) + 10 * remainder;
                if (!(i == 0 && input.get(0) == 1)){
                    output.add(cur/ 2);
                }
                remainder = cur % 2;
            }
        }
        return output;
    }
}
