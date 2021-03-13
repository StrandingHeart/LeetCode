package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/13 16:58
 */
public class Q142环形链表II {

    /**
     * 找到环的节点，没有环返回null
     *
     * 快慢指针找到环,然后设置虚拟指针指向head，虚拟指针和slow同时往后移动一步，当相遇时即是环的起点。
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean circle = false;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                circle = true;
                break;
            }
        }
        // 前面代码能看出来有没有环，没环就返回null
        if (!circle){
            return null;
        }
        // 设置头结点与slow节点，同时往后移动一步，当相遇时就是环的起点了。
        ListNode pre = head;
        while (pre!=slow){
            pre = pre.next;
            slow = slow.next;
        }
        return pre;
    }
}
