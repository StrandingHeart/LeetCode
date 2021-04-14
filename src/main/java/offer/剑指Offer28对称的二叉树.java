package offer;

/**
 * @author zhangyong
 * Created on 2021-04-13
 */
public class 剑指Offer28对称的二叉树 {
    //请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
    //
    //例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return dp(root.left,root.right);
    }

    public boolean dp(TreeNode left,TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left == null && right!=null){
            return false;
        }
        if (right == null && left!=null){
            return false;
        }
        if (left.val!=right.val){
            return false;
        }
        return dp(left.left,right.right) && dp(left.right,right.left);
    }
}
