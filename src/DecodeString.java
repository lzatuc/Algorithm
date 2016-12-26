import java.util.Stack;

/**
 * Created by li on 2016/12/25.
 */
public class DecodeString
{
    public static void main(String args[]){
        String s = "2[ab3[cd]]4[xy]";
        String res = decodeString(s);
        System.out.println(res);
    }

    public static String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        int idx;
        for (int i = 0; i < s.length(); ){
            char ch = s.charAt(i);
            if (ch != ']'){
                if (Character.isDigit(ch)){
                    StringBuilder num = new StringBuilder();
                    for (idx = i; Character.isDigit(s.charAt(idx)); idx++){
                        num.append(s.charAt(idx));
                    }
                    stack.push(num.toString());
                    i = idx;
                }
                else{
                    stack.push(String.valueOf(ch));
                    i++;
                }
            }
            else{
                String inBracketStr = "";
                String str;
                while(!(str = stack.pop()).equals("[")){
                    inBracketStr = str + inBracketStr;
                }
                StringBuilder repeatSb = new StringBuilder();
                int repeatTimes = Integer.valueOf(stack.pop());
                System.out.println(repeatTimes);
                for (int t = 0; t < repeatTimes; t++){
                    repeatSb.append(inBracketStr);
                }
                stack.push(repeatSb.toString());
                i++;
            }
        }
        String res = "";
        while(!stack.isEmpty()){
            res = stack.pop() + res;
        }
        return res;
    }
}
