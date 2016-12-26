import java.util.*;
import java.util.LinkedHashMap;

/**
 * Created by li on 2016/12/26.
 */
public class FirstUniqueCharacterinaString
{
    public static void main(String[] args){
        String str = "loveleetcode";
        int res = firstUniqChar(str);
        System.out.println(res);
    }
    public static int firstUniqChar(String s) {
        Map<Character, Integer> charToIndex = new LinkedHashMap<>();
        Set<Character> exist = new HashSet<>();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (!exist.contains(ch)){
                exist.add(ch);
                charToIndex.put(ch, i);
            }
            else{
                charToIndex.remove(ch);
            }
        }
        if (charToIndex.isEmpty()){
            return -1;
        }
        else{
            return charToIndex.values().iterator().next();
        }
    }
}
