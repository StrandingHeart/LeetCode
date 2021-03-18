package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/18 22:34
 */
public class Q1721交换链表中的节点 {

    /**
     * 交换节点的值。
     *
     * 解题思路：找到对应节点的位置然后还一下值就行了。
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }
        ListNode node1 = fast;
        while (fast!=null && fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        int tmp = node1.val;
        node1.val = slow.val;
        slow.val = tmp;
        return head;
    }
}
