package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyong
 * Created on 2021-04-14
 */
public class 剑指Offer34二叉树中和为某一值的路径 {

    //输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
    //
    // 
    //
    //示例:
    //给定如下二叉树，以及目标和 target = 22，
    //
    //              5
    //             / \
    //            4   8
    //           /   / \
    //          11  13  4
    //         /  \    / \
    //        7    2  5   1
    //返回:
    //
    //[
    //   [5,4,11,2],
    //   [5,8,4,5]
    //]
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    private int target;

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> inner = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        this.target = target;
        find(root,0);
        return res;
    }

    public void find(TreeNode root, int sum){
        if (root == null){
            return;
        }
        sum += root.val;
        inner.add(root.val);
        if (sum == target&& root.left == null && root.right == null){
            res.add(new ArrayList<>(inner));
        }
        find(root.left,sum);
        find(root.right,sum);
        inner.remove(inner.size()-1);
    }

    public static void main(String[] args) {
        剑指Offer34二叉树中和为某一值的路径 s = new 剑指Offer34二叉树中和为某一值的路径();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        System.out.println(s.pathSum(node1, 7));
    }

}
