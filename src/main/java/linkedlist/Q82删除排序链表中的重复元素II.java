package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/6 15:37
 */
public class Q82删除排序链表中的重复元素II {
    /**
     * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     *
     * 示例 1:
     *
     * 输入: 1->2->3->3->4->4->5
     * 输出: 1->2->5
     * 示例 2:
     *
     * 输入: 1->1->1->2->3
     * 输出: 2->3
     *
     * 解题思路：加一个哑结点，取next  next.next比较值是否相同，相同就都删除，然后记录这个删的元素，下一个元素如果再跟这个删除的元素一样就继续删除
     * flag设置为了防止head头节点处相同误删
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = new ListNode(-1);
        cur.next = head;
        ListNode fast;
        ListNode slow;
        ListNode res = cur;
        ListNode deleted = head;
        // flag设置为了防止head头节点处相同误删
        boolean flag = false;
        while (cur.next!=null&&cur.next.next!=null){
            slow = cur.next;
            fast = cur.next.next;
            if (slow.val == fast.val){
                flag = true;
                deleted = slow;
                cur.next = cur.next.next.next;
            }else if (flag && deleted.val == slow.val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        if (cur.next!=null && flag && cur.next.val == deleted.val){
            cur.next = null;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l5.setNext(l6);
        l4.setNext(l5);
        l3.setNext(l4);
        l2.setNext(l3);
        l1.setNext(l2);
        ListNode listNode = deleteDuplicates(l1);
        System.out.println(listNode);
    }
}
