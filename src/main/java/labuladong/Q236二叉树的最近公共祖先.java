package labuladong;

/**
 * @author zhangyong
 * Created on 2021-03-29
 */
public class Q236二叉树的最近公共祖先 {

    /**
     * 求 p q最近公共祖先，那么就左右分别求，因为不一定在哪边。但是肯定在一边
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        //左边最大公共祖先。
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //右边最大公共祖先。
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) {
            return null;
        }
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
