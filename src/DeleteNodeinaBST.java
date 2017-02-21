/**
 * Created by lizheng on 2017/2/19.
 */
public class DeleteNodeinaBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode deleteNode(TreeNode root, int key){
        TreeNode node = root, toDel = null, delPrev = null;
        int delDir = 0;
        while(node != null){
            if (node.val == key){
                toDel = node;
                break;
            }
            else if (node.val < key){
                delPrev = node;
                delDir = 1;
                node = node.right;
            }
            else{
                delPrev = node;
                delDir = -1;
                node = node.left;
            }
        }
        if (toDel == null){
            return root;
        }
        else{
            if (toDel.left == null && toDel.right == null){
                if (delPrev == null){
                    toDel = null;
                    return null;
                }
                else{
                    if (delDir == -1){
                        delPrev.left = null;
                    }
                    else{
                        delPrev.right = null;
                    }
                    return root;
                }
            }
            if (toDel.left != null){
                TreeNode maxNode = toDel.left, preMaxNode = toDel;
                if (maxNode.right == null){
                    toDel.val = maxNode.val;
                    toDel.left = maxNode.left;
                }
                else{
                    while(maxNode.right != null){
                        preMaxNode = maxNode;
                        maxNode = maxNode.right;
                    }
                    toDel.val = maxNode.val;
                    preMaxNode.right = maxNode.left;
                }
                maxNode = null;
            }
            else if (toDel.right != null){
                TreeNode minNode = toDel.right, preMinNode = toDel;
                if (minNode.left == null){
                    toDel.val = minNode.val;
                    toDel.right = minNode.right;
                }
                else{
                    while(minNode.left != null){
                        preMinNode = minNode;
                        minNode = minNode.left;
                    }
                    toDel.val = minNode.val;
                    preMinNode.left = minNode.right;
                }
                minNode = null;
            }
            return root;
        }
    }


}
