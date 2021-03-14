package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/13 18:18
 */
public class Q143重排链表 {

    /**
     * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
     * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * 解题思路：先根据双指针找到中点 mid 然后将mid后面的元素反转，mid与后面切断，接下来合并mid之前和mid之后反转的元素，替换的连、
     * @param head
     */
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode reverse = mid.next;
        mid.next = null;
        ListNode pre = null;
        while (reverse!=null){
            ListNode next = reverse.next;
            reverse.next = pre;
            pre = reverse;
            reverse = next;
        }
        while (head!=null && pre!=null){
            ListNode h1 = head.next;
            ListNode p1 = pre.next;
            head.next = pre;
            head = h1;
            pre.next = head;
            pre = p1;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l5.setNext(l6);
        l4.setNext(l5);
        l3.setNext(l4);
        l2.setNext(l3);
        l1.setNext(l2);
        Q143重排链表 s = new Q143重排链表();
        s.reorderList(l1);
    }

}
