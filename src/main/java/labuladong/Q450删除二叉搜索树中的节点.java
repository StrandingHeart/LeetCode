package labuladong;

/**
 * @Author zhangyong
 * @Date 2021/4/1 23:11
 */
public class Q450删除二叉搜索树中的节点 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return null;
        }
        if (root.val == key){
            // 找到要删除的节点， 当左右子树为空的时候返回null，就是删除当前节点，否则哪个不空返回哪个。
            if (root.left == null){
                return root.right;
            }
            if (root.right == null){
                return root.left;
            }
            // 左右子树都有的话，就取右子树的最左子树。
            TreeNode min = min(root.right);
            // 当前节点值为右子树的最左子树(待删除)值，然后将右子树的最左子树(叶子节点)删除
            root.val = min.val;
            root.right = deleteNode(root.right,min.val);
        }else if (root.val > key){
            root.left = deleteNode(root.left,key);
        }else {
            root.right = deleteNode(root.right,key);
        }
        return root;
    }


    public TreeNode min(TreeNode root){
        while (root.left!=null){
            root = root.left;
        }
        return root;
    }
}
