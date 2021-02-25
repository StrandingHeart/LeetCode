package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/2/25 22:39
 */
public class Question19 {

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * @param head
     * @param n
     * @return
     */

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        // 添加哑结点
        ListNode res = new ListNode(0,head);
        // slow 和 res指向同一个地址
        ListNode slow = res;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(4);
//        l3.setNext(l4);
//        l2.setNext(l3);
        l1.setNext(l2);
        System.out.println(removeNthFromEnd(l1, 2));
    }
}
