package labuladong;

/**
 * @Author zhangyong
 * @Date 2021/4/1 23:07
 */
public class Q701二叉搜索树中的插入操作 {


    public TreeNode insertIntoBST(TreeNode root, int val) {
       if (root == null){
            return new TreeNode(val);
        }
        if (root.val > val){
            root.left = insertIntoBST(root.left,val);
        }else if (root.val < val){
            root.right = insertIntoBST(root.right,val);
        }
        return root;
    }

}
