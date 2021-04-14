package offer;

import java.util.*;

/**
 * @author zhangyong
 * Created on 2021-04-14
 */
public class 剑指Offer32I从上到下打印二叉树 {

    //从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
    //例如:
    //给定二叉树: [3,9,20,null,null,15,7],
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    // 返回： [3,9,20,15,7]

    public int[] levelOrder(TreeNode root) {
        if (root ==null){
            return new int[0];
        }
        List<Integer> arr = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode pop = queue.pop();
            arr.add(pop.val);
            if (pop.left!=null){
                queue.add(pop.left);
            }
            if (pop.right!=null){
                queue.add(pop.right);
            }
        }
        int[] res = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            res[i] = arr.get(i);
        }
        return res;
    }
}
