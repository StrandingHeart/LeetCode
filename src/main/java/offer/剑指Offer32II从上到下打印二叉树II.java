package offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangyong
 * Created on 2021-04-14
 */
public class 剑指Offer32II从上到下打印二叉树II {
    //从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
    //
    // 
    //
    //例如:
    //给定二叉树: [3,9,20,null,null,15,7],
    //
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //返回其层次遍历结果：
    //
    //[
    //  [3],
    //  [9,20],
    //  [15,7]
    //]

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            // queue.size这个不能放在 中间判断语句，因为size是变化的
            for (int i = queue.size(); i > 0; i--) {
                TreeNode pop = queue.pop();
                tmp.add(pop.val);
                // 将每一层的子都加进去
                if (pop.left != null) {
                    queue.add(pop.left);
                }
                if (pop.right != null) {
                    queue.add(pop.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        剑指Offer32II从上到下打印二叉树II s = new 剑指Offer32II从上到下打印二叉树II();
        System.out.println(s.levelOrder(node1));

    }
}
