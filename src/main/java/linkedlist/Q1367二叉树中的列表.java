package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/18 22:17
 */
public class Q1367二叉树中的列表 {

    /**
     * 给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。
     *
     * 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，那么请你返回 True ，否则返回 False 。
     *
     * 一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。
     *
     *
     * 树递归找，如果head 为null代表找完了，  root为null代表没找着
     * @param head
     * @param root
     * @return
     */
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null){
            return true;
        }
        if (root == null){
            return false;
        }
        return sub(head,root) || isSubPath(head,root.left) || isSubPath(head,root.right);
    }

    private boolean sub(ListNode head, TreeNode root){
        if (head == null){
            return true;
        }
        if (root == null){
            return false;
        }
        if (head.val != root.val){
            return false;
        }
        return sub(head.next,root.left) || sub(head.next,root.right);
    }
}
