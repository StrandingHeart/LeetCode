package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyong
 * Created on 2021-04-13
 */
public class 剑指Offer26树的子结构 {

    //输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
    //
    //B是A的子结构， 即 A中有出现和B相同的结构和节点值。
    //输入：A = [1,2,3], B = [3,1]
    //输出：false
    //示例 2：
    //
    //输入：A = [3,4,5,1,2], B = [4,1]
    //输出：true

    /**
     * 子结构，后序遍历
     *
     * @param A
     * @param B
     * @return
     */


    /**
     * 取所有的根节点去判断是否包含
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) {
            return false;
        }
        return dp(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }


    /**
     * 判断a是否包含b
     */
    public boolean dp(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null || a.val != b.val) {
            return false;
        }
        return dp(a.left, b.left) && dp(a.right, b.right);
    }


    public static void main(String[] args) {
        //[3,5,0,3,4]
        //[1,-4,2,-1,3,-3,-4,0,-3,-1]
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
//        node2.right = node5;
//        node3.left = node6;
        剑指Offer26树的子结构 s = new 剑指Offer26树的子结构();
        System.out.println(s.isSubStructure(node1, node3));
    }

}
