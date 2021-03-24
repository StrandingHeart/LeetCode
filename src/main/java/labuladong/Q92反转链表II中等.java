package labuladong;


/**
 * @author zhangyong
 * Created on 2021-03-22
 */
public class Q92反转链表II中等 {

    //反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
    //
    // 说明:
    //1 ≤ m ≤ n ≤ 链表长度。
    //
    // 示例:
    //
    // 输入: 1->2->3->4->5->NULL, m = 2, n = 4
    // 输出: 1->4->3->2->5->NULL

    /**
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode cur = res;
        ListNode ans = res;
        int tmp = left;
        while (tmp > 1) {
            tmp--;
            cur = cur.next;
        }
        ListNode pre = cur;
        cur = cur.next;
        int move = right - left;
        while (move > 0) {
            // 1-2-3-4-5
            // x-p-c-n
            // 1-2-4-3-5
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
            move--;
        }
        return ans.next;
    }

    public ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
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
        Q92反转链表II中等 s = new Q92反转链表II中等();
        System.out.println(s.reverse(l1, l3));
//        System.out.println(s.reverseBetween(l1, 1, 4));
    }
}
