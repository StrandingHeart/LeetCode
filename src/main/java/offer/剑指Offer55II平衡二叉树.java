package offer;

/**
 * @author zhangyong
 * Created on 2021-05-06
 */
public class 剑指Offer55II平衡二叉树 {

    //输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
    //
    // 
    //
    //示例 1:
    //
    //给定二叉树 [3,9,20,null,null,15,7]
    //
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //返回 true 。
    //

    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        if (Math.abs(dp(root.left) - dp(root.right)) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    int count = 0;
    int res = 0;
    public int dp(TreeNode root){
        depth(root);
        int tmp = res;
        res = 0;
        return tmp;
    }

    public void depth(TreeNode root){
        if (root == null){
            return;
        }
        count++;
        depth(root.left);
        res = Math.max(res,count);
        depth(root.right);
        count--;
    }

}
