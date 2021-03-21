package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/21 10:46
 */
public class 剑指Offer22链表中倒数第k个节点 {

    /**
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     *
     * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
     *
     *  
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 k = 2.
     *
     * 返回链表 4->5.
     *
     * 解题思路：快慢指针，快指针先走k，然后快慢一起走，最后slow就是返回点
     *
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null){
            return null;
        }
        ListNode fast = head;
        while (k > 0){
            k--;
            fast = fast.next;
        }
        ListNode slow = head;
        while (fast != null&& fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
