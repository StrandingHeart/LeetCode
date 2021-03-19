package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/18 22:21
 */
public class Q1669合并两个链表 {

    /**
     * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
     *
     * 请你将 list1 中第 a 个节点到第 b 个节点删除，并将list2 接在被删除节点的位置。
     *
     *
     * 解题思路：找到a位置的前驱以及b位置的后继，把list2放进去就行了。
     * @param list1
     * @param a
     * @param b
     * @param list2
     * @return
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode res = new ListNode(0);
        res.next = list1;
        ListNode cur = res;
        for (int i = 1; i < a; i++) {
            cur = cur.next;
        }
        ListNode pre = cur;
        int move = b-a;
        while (move >=0 && cur != null){
            move--;
            cur = cur.next;
        }
        pre.next = list2;
        ListNode cur2 = list2;
        while (cur2!=null && cur2.next!=null){
            cur2 = cur2.next;
        }
        cur2.next = cur.next;
        return res.next;
    }
}
