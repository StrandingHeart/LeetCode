package offer;

/**
 * @author zhangyong
 * Created on 2021-05-06
 */
public class 剑指Offer55I二叉树的深度 {

    //输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
    //
    //例如：
    //
    //给定二叉树 [3,9,20,null,null,15,7]，
    //
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //返回它的最大深度 3 。
    //
    int count = 0;
    int res = 0;
    public int maxDepth(TreeNode root) {
        dp(root);
        return res;
    }

    public void dp(TreeNode root){
        if (root == null){
            return;
        }
        count++;
        dp(root.left);
        res = Math.max(res,count);
        dp(root.right);
        count--;
    }
}
