package linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhangyong
 * @Date 2021/3/18 22:04
 */
public class Q1171从链表中删去总和值为零的连续节点 {

    /**
     * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
     * <p>
     * 删除完毕后，请你返回最终结果链表的头节点。
     * <p>
     *  
     * <p>
     * 你可以返回任何满足题目要求的答案。
     *
     * 解题思路：当两次sum相等就代表中间是要被删去的
     * @param head
     * @return
     */
    public static ListNode removeZeroSumSublists(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode res = new ListNode();
        res.next = head;
        Map<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        for (ListNode cur = res; cur != null; cur = cur.next) {
            sum += cur.val;
            map.put(sum,cur);
        }

        sum = 0;
        for (ListNode cur = res; cur != null; cur = cur.next) {
            sum += cur.val;
            cur.next = map.get(sum).next;
        }
        return res.next;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(-1);
        ListNode l4 = new ListNode(-2);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l5.setNext(l6);
        l4.setNext(l5);
        l3.setNext(l4);
        l2.setNext(l3);
        l1.setNext(l2);
        System.out.println(removeZeroSumSublists(l1));
    }
}
