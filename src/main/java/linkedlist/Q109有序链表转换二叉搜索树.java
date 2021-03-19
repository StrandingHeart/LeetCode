package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/13 13:39
 */
public class Q109有序链表转换二叉搜索树 {


    /**
     * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
     *
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     *
     * 示例:
     *
     * 给定的有序链表： [-10, -3, 0, 5, 9],
     *
     * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
     *
     *       0
     *      / \
     *    -3   9
     *    /   /
     *  -10  5
     * 解题思路：这个就是恢复成BST 不断的找中位数，因为链表是有序的，递归时每次把中间的数加为节点进行构造二叉树就可以了
     */
    public TreeNode sortedListToBST(ListNode head) {
        return createNode(head, null);
    }

    TreeNode createNode(ListNode head, ListNode tail) {
        // 当头==尾时，说明当前节点下面没有子树了。
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
