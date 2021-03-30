package labuladong;

/**
 * @author zhangyong
 * Created on 2021-03-29
 */
public class Q230二叉搜索树种第K小的元素 {

    int res = 0;
    int rank = 0;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null){
            return -1;
        }
        kthSmallest(root.left,k);
        rank++;
        if (rank == k){
            res = root.val;
            return res;
        }
        kthSmallest(root.right,k);
        return res;
    }
}
