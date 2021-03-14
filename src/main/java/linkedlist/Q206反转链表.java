package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/14 16:50
 */
public class Q206反转链表 {

    /**
     * 反转链表
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode cur = head;
        ListNode pre =null;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
