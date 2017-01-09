import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * Created by li on 2016/12/30.
 */
public class MiniParser
{

    public static void main(String[] args){
        for (int i = 0; i < 10; i++){
            System.out.println(new Random().nextInt(5));
        }
//        char ch = null;
//        System.out.println(Character.isDigit(ch = '5'));
//        int sum = 8;
//        char c = (char)(sum + '0');
//        System.out.println(c);
//        String str = "ab";
//        StringBuilder sb = new StringBuilder(str);
//        sb.append(55);
//        System.out.println(sb.toString());
//        int a = '9' - '0';
//        System.out.println(a);
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

    int[] nums;

    public List<Integer> f(){

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++){
            int pos = Math.abs(nums[i]) - 1;
            if (nums[pos] > 0){
                nums[pos] = -nums[pos];
            }
        }

        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0){
                res.add(i + 1);
            }
        }
        return res;

    }

    public List<List<String>> gen(String[] elems, int curIndex, int total){
        if (curIndex + 1 < total || total == 0){
            List<String> in = new ArrayList<>();
            List<List<String>> out = new ArrayList<>();
            out.add(in);
            return out;
        }
        List<List<String>> res = new ArrayList<>();
        List<List<String>> res1 = gen(elems, curIndex - 1, total);
        List<List<String>> res2 = gen(elems, curIndex - 1, total - 1);
//        System.out.println(elems[curIndex]);
//        System.out.println(res1);
//        System.out.println(res2);
        res2.forEach(strs -> strs.add(elems[curIndex]));
//        System.out.println(res2);
        res1.forEach(res::add);
        res2.forEach(res::add);
        return res;
    }

//    public List<String> bwatch(){
//
//    }

    public static void main(String[] args){
//        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
//        NestedInteger nestedInteger = new NestedInteger();
//        nestedInteger.nums = nums;
//        System.out.println(nestedInteger.f());
        String[] elems = {"4", "2", "1"};
        List<List<String>> res = new NestedInteger().gen(elems, elems.length - 1, 2);
        System.out.println(res);
    }

    // 8 4 2 1
    // 32 16 8 4 2 1



}
//Input:
//        [4,3,2,7,8,2,3,1]
//        [4,3,2,-7,8,2,3,1]
//        [4,3,-2,-7,8,2,3,1]
//        [4,-3,-2,-7,8,2,3,1]
//        [4,-3,-2,-7,8,2,-3,1]
//        [4,-3,-2,-7,8,2,-3,-1]
//        [-4,-3,-2,-7,8,2,-3,-1]
//
//        Output:
//        [5,6]