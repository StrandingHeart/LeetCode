package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/7 20:45
 */
public class Q86分隔链表 {

    /**
     * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
     *
     * 你应当 保留 两个分区中每个节点的初始相对位置。
     *
     * 解题思路：例如x=3，将所有val小于3的节点放到small这个链表上，将 >=3的放到另一个链表上，然后连上就行了。
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode cur = head;
        ListNode small = new ListNode(-1);
        ListNode big = new ListNode(-1);
        ListNode res = small;
        ListNode tmpBig = big;
        while (cur!=null){
            if (cur.val<x){
                small.next = new ListNode(cur.val);
                small = small.next;
            }else {
                big.next = new ListNode(cur.val);
                big = big.next;
            }
            cur = cur.next;
        }
        small.next = tmpBig.next;
        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(1);
        l5.setNext(l6);
        l4.setNext(l5);
        l3.setNext(l4);
        l2.setNext(l3);
        l1.setNext(l2);
        ListNode partition = partition(l1, 3);
        System.out.println(partition);
    }

}
