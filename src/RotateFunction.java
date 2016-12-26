/**
 * Created by li on 2016/12/26.
 */
public class RotateFunction
{
    public static void main(String args[]){
        int a[] = {4, 3, 2, 6};
        int res = maxRotateFunction(a);
        System.out.println(res);
    }
    public static int maxRotateFunction(int[] A) {
        int n = A.length;
        if (n == 0){
            return 0;
        }
        int res = 0, presum = 0, sufsum = 0;
        for (int i = 0; i < n; i++){
            res += i * A[i];
            presum += A[i];
        }
        int fun = res;
        presum -= A[n - 1];
        for (int k = 1; k <= n - 1; k++){
            fun += presum + sufsum - (n - 1) * A[n - k];
            if (fun > res){
                res = fun;
            }
            presum -= A[n - 1 - k];
            sufsum += A[n - k];
        }
        return res;
    }
}
