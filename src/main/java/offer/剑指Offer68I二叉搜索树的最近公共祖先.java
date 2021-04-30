package offer;

/**
 * @author zhangyong
 * Created on 2021-04-30
 */
public class 剑指Offer68I二叉搜索树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null){
            if(root.val > p.val && root .val > q.val){
                root = root.left;
            }else if (root.val < p.val && root .val < q.val){
                root = root.right;
            }else {
                break;
            }
        }
        return root;
    }
}
