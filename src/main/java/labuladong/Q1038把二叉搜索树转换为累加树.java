package labuladong;

/**
 * @author zhangyong
 * Created on 2021-03-30
 */
public class Q1038把二叉搜索树转换为累加树 {

    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        add(root);
        return root;
    }

    public void add(TreeNode root){
        if (root == null){
            return;
        }
        add(root.right);
        sum += root.val;
        root.val = sum;
        add(root.left);
    }
}
