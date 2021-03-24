package labuladong;

/**
 * @author zhangyong
 * Created on 2021-03-24
 */
public class Q114二叉树展开为链表 {
    //给你二叉树的根结点 root ，请你将它展开为一个单链表：
    //
    // 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
    // 展开后的单链表应该与二叉树 先序遍历 顺序相同。

    /**
     * 解题思路：把左节点置空，右节点为左节点，然后再将之前的右节点添加到最后的末节点.
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;

        TreeNode tmp = root;
        while (tmp.right!=null){
            tmp = tmp.right;
        }
        tmp.right = right;

        flatten(root.left);
        flatten(root.right);
    }
}
