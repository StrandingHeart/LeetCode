package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/21 13:00
 */
public class 面试题0202返回倒数第k个节点 {
    /**
     * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
     * <p>
     * 注意：本题相对原题稍作改动
     * <p>
     * 示例：
     * <p>
     * 输入： 1->2->3->4->5 和 k = 2
     * 输出： 4
     *
     * @return
     */
    public int kthToLast(ListNode head, int k) {
        ListNode fast = head;

        while (k > 1) {
            k--;
            fast = fast.next;
        }
        ListNode slow = head;
        while (fast != null && fast.next!=null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }
}
