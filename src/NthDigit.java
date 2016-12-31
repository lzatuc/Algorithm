import java.util.ArrayList;
import java.util.List;

/**
 * Created by li on 2016/12/30.
 */
public class NthDigit
{

    public static void main(String[] args){
//        int n = 1000000000;
//        System.out.println(new NthDigit().findNthDigit(n));
//
//        int x = Character.getNumericValue('5');
//        System.out.println(x);
        String s = "abc";
        Character ch = s.charAt(0);
        Object o = "1";
        String ss = (String)o;
        System.out.println(ss);


    }
    public int findNthDigit(int n) {
        long total = 0, tens = 1;
        int l = 0, left = 0;
        for (int i = 1; i<=10; i++){
            long cur = 9 * tens * i;
            total += cur;
            System.out.println(cur);
            if (total >= n){
                l = i;
                left = (int)(n - (total - cur));
                break;
            }
            tens *= 10;
        }
        System.out.println(total);
        int a = left / l;
        int b = left % l;
        if (b == 0){
            return (int)(tens + a - 1) % 10;
        }
        int val = (int)(tens + a);
        List<Integer> digits = new ArrayList<>();
        while(val != 0){
            digits.add(val % 10);
            val /= 10;
        }
        return digits.get(digits.size() - b);
    }
}
