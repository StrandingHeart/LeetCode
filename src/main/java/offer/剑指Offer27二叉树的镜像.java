package offer;

/**
 * @author zhangyong
 * Created on 2021-04-13
 */
public class 剑指Offer27二叉树的镜像 {
    //请完成一个函数，输入一个二叉树，该函数输出它的镜像。
    //
    //输入：root = [4,2,7,1,3,6,9]
    //输出：[4,7,2,9,6,3,1]

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
