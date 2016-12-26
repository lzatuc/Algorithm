/**
 * Created by li on 2016/12/26.
 */
public class MaximumXORofTwoNumbersinanArray
{
    public static void main(String args[]){
        int nums[] = {1,2,3};//{3, 10, 5, 25, 2, 8};
        int res = findMaximumXOR(nums);
        System.out.println(res);
    }

    private static int groundTruth(int x, int xx[]){
        int res = 0;
        for (int i = 0; i < xx.length; i++){
            int t = (x ^ xx[i]);
            if (t > res){
                res = t;
            }
        }
        return res;
    }

    private static TrieNode root = new TrieNode();

    public static int findMaximumXOR(int[] nums) {
        int res = 0;

        for (int i = 0; i < nums.length; i++){
            String binaryString = intToBinaryString(nums[i]);
            System.out.println(binaryString + ": " + nums[i]);
            insertTrieTree(binaryString);
        }

        for (int i = 0; i < nums.length; i++){
            int temp = maxXORFrom(nums[i]);
            System.out.println("num = " + nums[i] + "， temp = " + temp + ", groundTruth = " + groundTruth(nums[i], nums));
            if (temp > res){
                res = temp;
            }
        }

        return res;
    }

    private static int maxXORFrom(int num){
        String bStr = intToBinaryString(num);
        StringBuilder sb = new StringBuilder();
        TrieNode curNode = root;
        int i = 0;
        while(i < bStr.length()){
            char ch = bStr.charAt(i);
            if (ch == '0'){
                if (curNode.one != null){
                    sb.append('1');
                    curNode = curNode.one;
                }
                else{
                    sb.append('0');
                    curNode = curNode.zero;
                }
            }
            else{
                if (curNode.zero != null){
                    sb.append('1');
                    curNode = curNode.zero;
                }
                else{
                    sb.append('0');
                    curNode = curNode.one;
                }
            }
            i++;
        }
        System.out.println("nnum = " + num  + ", str = " + sb.toString());
        return binaryStringToInt(sb.toString());
    }
    // 1011
    private static int binaryStringToInt(String str){
        int res = 0;
        for (int i = 0; i < str.length(); i++){
            res = 2 * res + (str.charAt(i) - '0');
        }
        return res;
    }

    private static String intToBinaryString(int num){
        StringBuilder sb = new StringBuilder();
        if (num == 0){
            sb.append('0');
        }
        else{
            while(num != 0){
                int t = num & 1;
                if (t == 0){
                    sb.append('0');
                }
                else{
                    sb.append('1');
                }
                // sb.append(Character.valueOf(num & 1));
                num >>= 1;
            }
            sb.reverse();
        }
        String bStr = sb.toString();
//        return bStr;
        int len = bStr.length();
        int numOfLeadingZeros = 32 - len;
        StringBuilder sbzeros = new StringBuilder();
        for (int i = 0 ; i < numOfLeadingZeros; i++){
            sbzeros.append('0');
        }
        return sbzeros.append(bStr).toString();
    }

    private static void insertTrieTree(String str){
        TrieNode curNode = root;
        int i = 0;
        while(i < str.length()){
            char ch = str.charAt(i);
            if (ch == '0'){
                if (curNode.zero == null) {
                    curNode.zero = new TrieNode();
                }
                curNode = curNode.zero;
            }
            else{
                if (curNode.one == null) {
                    curNode.one = new TrieNode();
                }
                curNode = curNode.one;
            }
            i++;
        }
    }
}

class TrieNode{
    TrieNode zero, one;

    public TrieNode(){
        zero = null;
        one = null;
    }
}

// 00001010
// 00001000
// 00000010
// 00010011
// 00010101
// 00011001

// 001
// 010
// 011