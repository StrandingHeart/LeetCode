package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/16 21:58
 */
public class Q876链表的中间结点 {
    public ListNode middleNode(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
