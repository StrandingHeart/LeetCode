package offer;

/**
 * @author zhangyong
 * Created on 2021-04-30
 */
public class 剑指Offer52两个链表的第一个公共节点 {

    //输入两个链表，找出它们的第一个公共节点。

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a!=b){
            a = a == null ? headB:a.next;
            b = b == null ? headA:b.next;
        }
        return a;
    }

}
