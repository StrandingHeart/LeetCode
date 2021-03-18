package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/18 22:21
 */
public class Q1669合并两个链表 {

    /**
     * 找到a位置的前驱以及b位置的后继，把list2放进去就行了。
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
