package offer;

/**
 * @author zhangyong
 * Created on 2021-05-06
 */
public class 剑指Offer54二叉搜索树的第k大节点 {

    //给定一棵二叉搜索树，请找出其中第k大的节点。
    //
    // 
    //
    //示例 1:
    //
    //输入: root = [3,1,4,null,2], k = 1
    //   3
    //  / \
    // 1   4
    //  \
    //   2
    //输出: 4

    int count = 0;
    int res = 0;

    /**
     * 中序遍历
     * @param root
     * @param k
     * @return
     * @author zhangyong05
     * 2021/5/6 7:48 下午
     */
    public int kthLargest(TreeNode root, int k) {
        count = k;
        dp(root,k);
        return res;
    }

    public void dp(TreeNode root, int k){
        if (root == null){
            return;
        }
        dp(root.right,k);
        if (count == 0){
            return;
        }
        if (--count == 0){
            res = root.val;
            return;
        }
        dp(root.left,k);
    }

}
