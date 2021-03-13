package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/13 16:45
 */
public class Q141环形链表 {

    /**
     * 判断有环
     * <p>
     * 解题思路，快慢指针，快指针走两步，慢指针走一步，如果相遇证明有环，否则快指针走到头证明没环
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

}
