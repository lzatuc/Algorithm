import java.util.*;

/**
 * Created by lizheng on 2017/2/19.
 */
public class CountofSmallerNumbersAfterSelf {
    class TreeNode{
        TreeNode left, right;
        int val, dup, count;
        public TreeNode(int val){
            this.val = val;
            this.count = 1;// all the nodes in left tree, including itself
            this.dup = 1;// duplication of val in this node
        }
    }

    class BST{

        private TreeNode root;

        public void insert(int val){
            TreeNode node = root, prev = null;
            if (root == null){
                root = new TreeNode(val);
            }
            else{
                int dir = 0;
                while(node != null){
                    if (node.val == val){
                        node.dup += 1;
                        node.count += 1;
                        return;
                    }
                    else{
                        prev = node;
                        if (node.val < val){
                            dir = 1;
                            node = node.right;
                        }
                        else{
                            dir = -1;
                            prev.count += 1;
                            node = node.left;
                        }
                    }
                }
                node = new TreeNode(val);
                if (dir == -1){
                    prev.left = node;
                }
                else{
                    prev.right = node;
                }
            }
        }

        public int getCount(TreeNode node, int val){
            while(node != null){
                if (node.val == val){
                    return node.count - node.dup;
                }
                else if (node.val < val){
                    return node.count + getCount(node.right, val);
                }
                else{
                    return getCount(node.left, val);
                }
            }
            return 0;
        }


    }

    public void printTree(TreeNode node){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                TreeNode head = q.poll();
                if (head.left != null){
                    q.offer(head.left);
                }
                if (head.right != null){
                    q.offer(head.right);
                }
                System.out.print("head.count:" + head.count + ", head.dup: " + head.dup + ", head.val: " + head.val + "; ");
            }
            System.out.println();
        }
    }

    BST bst;


    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        bst = new BST();
        for (int i = n - 1; i >= 0; i--){
            int rs = bst.getCount(bst.root, nums[i]);
            bst.insert(nums[i]);
            printTree(bst.root);
            System.out.println("&&&&&&&&&&&&&&");
            stack.push(rs);
        }
        List<Integer> list = new ArrayList<>();
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }

    public static void main(String[] args){
//        int[] nums = {2, 0, 1};
//        CountofSmallerNumbersAfterSelf counter = new CountofSmallerNumbersAfterSelf();
//        List<Integer> rs = counter.countSmaller(nums);
        int x = (int)((-8+1)/2);
        System.out.println(x);
    }
}
