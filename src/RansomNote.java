import java.util.HashMap;
import java.util.Map;

/**
 * Created by li on 2016/12/29.
 */
public class RansomNote
{
    public static void main(String args[]){
        String ransomNote = "aa", magazine = "aab";
        System.out.println(new RansomNote().canConstruct(ransomNote, magazine));
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> note, mag;
        note = helper(ransomNote);
        mag = helper(magazine);
        return isSubset(note, mag);
    }

    private Map<Character, Integer> helper(String str){
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return map;
    }

    private boolean isSubset(Map<Character, Integer> m1, Map<Character, Integer> m2){
        for (Map.Entry<Character, Integer> entry : m1.entrySet()){
            Character key = entry.getKey();
            int value = entry.getValue();
            if (!m2.containsKey(key) || m2.get(key) < value){
                return false;
            }
        }
        return true;
    }
}
