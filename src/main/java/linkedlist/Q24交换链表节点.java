package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/3 23:04
 */
public class Q24交换链表节点 {

    /**
     * 两两交换链表中的节点
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * 解题思路：利用哑结点，设置next  next.next 节点转换，循环就行了，注意的是cur一下跳两个节点
     */
    public static ListNode swapPairs(ListNode head) {
        ListNode cur = new ListNode(-1);
        cur.next = head;
        ListNode res = cur;
        while (cur.next!=null && cur.next.next!=null){
            ListNode tmp1 = cur.next;
            ListNode tmp2 = cur.next.next;
            tmp1.next = tmp2.next;
            tmp2.next = tmp1;
            cur.next = tmp2;
            cur = cur.next.next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.re1234();

        System.out.println(l1);
        ListNode listNode = swapPairs(l1);
        System.out.println(listNode);
    }
}
