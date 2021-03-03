package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/3 22:24
 */
public class Question21 {

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     */

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 使用哑结点免去头结点判断代码
        ListNode cur = new ListNode(0);
        // res是真正从头到尾的链表，cur是控制当前节点动的。
        ListNode res = cur;
        while (l1!=null && l2!=null){
            if (l1.val<=l2.val){
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            }else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1!=null){
            cur.next = l1;
        }
        if (l2!=null){
            cur.next = l2;
        }
        return res.next;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        l2.setNext(l3);
        l1.setNext(l2);


        ListNode q1 = new ListNode(3);
        ListNode q2 = new ListNode(4);
        ListNode q3 = new ListNode(5);
        q2.setNext(q3);
        q1.setNext(q2);

        System.out.println(l1);
        System.out.println(q1);

        ListNode listNode = mergeTwoLists(l1, q1);
        System.out.println(listNode);
    }
}
