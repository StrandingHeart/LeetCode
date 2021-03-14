package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/14 16:08
 */
public class Q160相交链表 {

    /**
     * 解题思路：
     * a1->a2->c1->c2->c3->b1->b2->b3->c1->c2->c3;
     * b1->b2->b3->c1->c2->c3->a1->a2->c1->c2->c3;
     * --------------------------------!-----------
     * a+b 和 b+a 如果有重合的那么肯定最后的几个元素就是重合的元素、 上面就是！处的c1是重复的
     *
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        l2.setNext(l3);
        l1.setNext(l2);


        ListNode q1 = new ListNode(1);
        ListNode q2 = new ListNode(3);
//        ListNode q3 = new ListNode(4);
        q2.setNext(l2);
        q1.setNext(q2);

        System.out.println(l1);
        System.out.println(q1);

        ListNode listNode = getIntersectionNode(l1, q1);
        System.out.println(listNode);
    }
}
