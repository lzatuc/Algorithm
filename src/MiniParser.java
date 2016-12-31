import java.util.Random;
import java.util.Stack;

/**
 * Created by li on 2016/12/30.
 */
public class MiniParser
{

    public static void main(String[] args){
        int sum = 8;
        char c = (char)(sum + '0');
        System.out.println(c);
        String str = "ab";
        StringBuilder sb = new StringBuilder(str);
        sb.append(55);
        System.out.println(sb.toString());
//        System.out.println(sb.toString());
//        int a = 1;
//        char c = (char)(a + '0');
//        System.out.println(c);
//        StringBuilder sb1 = sb.reverse();
//        System.out.println(sb.toString());
//        System.out.println(sb1.toString());

//        Character c = ']';
//        String s = "[123,[456,[789]]]";
//        NestedInteger res = deserialize(s);
//        String str = "abc";
//        char ch = str.charAt(0);
//        if ((ch = str.charAt(0)) == 'a'){
//            System.out.println("true");
//        }
    }
    public static NestedInteger deserialize(String s) {
        Stack<Object> stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0; ){
            Character ch = s.charAt(i);
            if (ch == ']'){
                stack.push(ch);
                i--;
            }
            else if (Character.isDigit(ch)){
//                System.out.println(ch);
                Integer val = 0, digit = 1;
                while(Character.isDigit(ch)){
//                    System.out.println("true");
                    val += digit * Character.getNumericValue(ch);
                    digit *= 10;
                    i--;
                    ch = s.charAt(i);
                }
//                System.out.println(val);
                stack.push(val);
            }
            else if (ch == ','){
                i--;
            }
            else if (ch == '['){
                NestedInteger nitg = new NestedInteger();
                while(!stack.isEmpty()){
                    Object top = stack.pop();
                    if (top instanceof Character){
                        stack.push(nitg);
                        break;
                    }
                    else if (top instanceof Integer){
                        nitg.add((Integer)top);
                    }
                    else if (top instanceof NestedInteger){
                        nitg.add((NestedInteger) top);
                    }
                }
                i--;
            }
            System.out.println(stack);
        }
        return (NestedInteger)stack.pop();
    }
}

class NestedInteger{
    public NestedInteger(){

    }

    public void add(Integer integer){

    }

    public void add(NestedInteger nitg){

    }
}