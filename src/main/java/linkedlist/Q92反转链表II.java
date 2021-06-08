package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/10 22:19
 */
public class Q92反转链表II {

    /**
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     * 说明:
     * 1 ≤ m ≤ n ≤ 链表长度。
     * 示例:
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     * <p>
     * 解题思路：这种要注意不要重复节点位置，即链经过不重复。穿针引线把经过的节点放到最前面这样经过[left,right]部分就是反转的了
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode pre = res;
        int tmpLeft = left;
        while (left > 1) {
            left--;
            pre = pre.next;
        }
        ListNode cur = pre.next;
        int tmp = right - tmpLeft;
        ListNode cNext;
        while (tmp > 0) {
            tmp--;
            cNext = cur.next;
            cur.next = cNext.next;
            cNext.next = pre.next;
            pre.next = cNext;

        }
        return res.next;
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
        System.out.println(reverseBetween(l1, 1, 2));
    }
}
