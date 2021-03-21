package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/21 10:54
 */
public class 剑指Offer52两个链表的第一个公共节点 {

    /**
     * 输入两个链表，找出它们的第一个公共节点。
     *
     *
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmp1 = headA;
        ListNode tmp2 = headB;
        while (headA !=headB){
            headA = headA == null?tmp2:headA.next;
            headB = headB == null? tmp1:headB.next;
        }
        return headA;
    }
}
