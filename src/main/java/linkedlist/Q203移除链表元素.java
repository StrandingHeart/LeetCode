package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/14 16:33
 */
public class Q203移除链表元素 {

    /**
     * https://leetcode-cn.com/problems/remove-linked-list-elements/
     * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
     *
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode cur = res;
        while (cur!=null && cur.next!=null){
            ListNode next = cur.next;
            if (next.val == val){
                cur.next = next.next;
            }else {
                cur = cur.next;
            }
        }
        return res.next;
    }
}
