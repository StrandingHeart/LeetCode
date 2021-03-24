package labuladong;

/**
 * @author zhangyong
 * Created on 2021-03-24
 */
public class Q226翻转二叉树 {
    // 输入：
    //
    //      4
    //   /   \
    //  2     7
    // / \   / \
    //1   3 6   9
    //
    // 输出：
    //
    //      4
    //   /   \
    //  7     2
    // / \   / \
    //9   6 3   1

    /**
     * 解题思路：左右节点交换就行了。然后对左右子树也递归处理
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
