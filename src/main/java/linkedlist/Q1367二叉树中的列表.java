package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/18 22:17
 */
public class Q1367二叉树中的列表 {

    /**
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
