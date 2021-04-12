package labuladong;

/**
 * @author zhangyong
 * Created on 2021-03-30
 */
public class Q700二叉搜索树中的搜索 {
    TreeNode res = null;

    /**
     * 类似二分法查找，如果当前比目标小，那么在右子树找，否则在左子树找。
     */
    public TreeNode searchBST(TreeNode root, int val) {
        search(root,val);
        return res;
    }

    public TreeNode search(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            res = root;
        } else if (root.val > val) {
            searchBST(root.left, val);
        } else {
            searchBST(root.right, val);
        }
        return null;
    }

    public static void main(String[] args) {
        Q700二叉搜索树中的搜索 s = new Q700二叉搜索树中的搜索();
        TreeNode root = new TreeNode(4);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(7);
        root.left = root1;
        root.right = root2;
        TreeNode root3 = new TreeNode(1);
        TreeNode root4 = new TreeNode(3);
        root.left.left = root3;
        root.left.right = root4;
        s.searchBST(root, 2);
    }
}
