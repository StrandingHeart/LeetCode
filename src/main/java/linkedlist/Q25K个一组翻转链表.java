package linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhangyong
 * @Date 2021/3/19 20:35
 */
public class Q25K个一组翻转链表 {
    //给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
    //
    //k 是一个正整数，它的值小于或等于链表的长度。
    //
    //如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
    //
    //进阶：
    //
    //你可以设计一个只使用常数额外空间的算法来解决此问题吗？
    //你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
    //

    /**
     * 解题思路：每k个反转，然后拼一起就行了
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int len = 0;
        List<ListNode> all = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            len++;
            if (len == k) {
                len = 0;
                ListNode next = cur.next;
                cur.next = null;
                all.add(head);
                head = next;
                cur = next;
            } else {
                cur = cur.next;
            }
        }
        return reverse(all, head);
    }


    public ListNode reverse(List<ListNode> heads, ListNode end) {
        ListNode res = new ListNode(-1);
        ListNode ans = res;
        for (ListNode head : heads) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            res.next = pre;
            while (res.next!=null){
                res = res.next;
            }
        }
        res.next = end;
        return ans.next;
    }
}
