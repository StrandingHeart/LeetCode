package labuladong;

/**
 * @author zhangyong
 * Created on 2021-03-30
 */
public class Q98验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        return valid(root, null, null);
    }

    public boolean valid(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return valid(root.left, min, root) && valid(root.right, root, max);
    }
}
