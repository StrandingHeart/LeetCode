package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/21 14:10
 */
public class 面试题0207链表相交 {

    /**
     * 给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，而不是基于节点的值。换句话说，如果一个链表的第k个节点与另一个链表的第j个节点是同一节点（引用完全相同），则这两个链表相交。
     *
     *
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (headA!=headB){
            headA = headA == null ? b:headA.next;
            headB = headB == null ? a:headB.next;
        }
        return a;
    }
}
