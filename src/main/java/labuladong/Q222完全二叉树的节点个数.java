package labuladong;

/**
 * @author zhangyong
 * Created on 2021-03-24
 */
public class Q222完全二叉树的节点个数 {

    //给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
    //
    //完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
    //提示：
    //
    //树中节点的数目范围是[0, 5 * 104]
    //0 <= Node.val <= 5 * 104
    //题目数据保证输入的树是 完全二叉树
    //进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？

    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    /**
     * 左子树+右子树+1就是全部节点的数量
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
