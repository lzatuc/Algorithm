/**
 * Created by li on 2016/12/30.
 */
public class AddStrings
{
    public static void main(String args[]){
        System.out.println(addStrings("123", "456"));
    }
    public static String addStrings(String num1, String num2) {
        String a = new StringBuilder(num1).reverse().toString();
        String b = new StringBuilder(num2).reverse().toString();
        StringBuilder c = new StringBuilder();
        int i = 0, carry = 0, l1 = a.length(), l2 = b.length(), sum = 0;
        while(i < l1 || i < l2){
            sum = 0;
            if (i < l1){
                sum += Character.getNumericValue(a.charAt(i));
            }
            if (i < l2){
                sum += Character.getNumericValue(b.charAt(i));
            }
            sum += carry;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            }
            char ch = (char)(sum + '0');
            c.append(ch);
            i++;
        }
        if (sum == 1){
            c.append('1');
        }
        return c.reverse().toString();
    }
}
