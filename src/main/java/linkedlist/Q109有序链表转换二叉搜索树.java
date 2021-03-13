package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/13 13:39
 */
public class Q109有序链表转换二叉搜索树 {


    /**
     * 不断的找中位数，因为链表是有序的，递归时每次把中间的数加为节点进行构造二叉树就可以了
     */
    public TreeNode sortedListToBST(ListNode head) {
        return createNode(head, null);
    }

    TreeNode createNode(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = createNode(head, slow);
        root.right = createNode(slow.next, tail);
        return root;
    }
}
