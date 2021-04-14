package offer;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhangyong
 * Created on 2021-04-14
 */
public class 剑指Offer32III从上到下打印二叉树III {

    //请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
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
    //  [20,9],
    //  [15,7]
    //]
    //
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size();i>0;i--){
                TreeNode pop = queue.pop();
                tmp.add(pop.val);
                if (pop.left != null){
                    queue.add(pop.left);
                }
                if (pop.right != null){
                    queue.add(pop.right);
                }
            }
            if ((res.size() & 1) == 1){
                Collections.reverse(tmp);
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
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        // [0,2,4,1,null,3,-1,5,1,null,6,null,8]
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        剑指Offer32III从上到下打印二叉树III s = new 剑指Offer32III从上到下打印二叉树III();
        System.out.println(s.levelOrder(node1));

    }
}
