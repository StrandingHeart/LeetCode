package labuladong;

/**
 * @author zhangyong
 * Created on 2021-03-29
 */
public class Q538把二叉搜索树转换成累加树 {


    /**
     * 二叉搜索树的中序遍历是递增的，如果交换左右节点就是递减的，这个题可以看出来是每个节点都从最大值开始加的。
     * 排序是 10，20，30    反着是  30，20，10
     * 最终结果是  30-->30     20 --> 20+30=50     10--> 10+20+30;
     * 所以只需从高往低累加就行了，将累加结果放到当前节点，因为sum是一直增加的所以满足要求。可以理解中序遍历
     * 只需要将中序要做的事情在中间写就行了。
     *    20             50
     *  10  30        60    30
     */
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }

    public void convert(TreeNode root){
        if (root == null){
            return;
        }
        convert(root.right);
        sum += root.val;
        root.val = sum;
        convert(root.left);
    }

    public static void main(String[] args) {
        Q538把二叉搜索树转换成累加树 s = new Q538把二叉搜索树转换成累加树();
        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(5);
        root.left = root1;
        root.right = root2;
        TreeNode root3 = new TreeNode(-3);
        root.left.left = root3;
        TreeNode root4 = new TreeNode(4);
        root.right.left = root4;
        s.convertBST(root);
    }
}
