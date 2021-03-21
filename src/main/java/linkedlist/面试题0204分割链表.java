package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/21 13:29
 */
public class 面试题0204分割链表 {

    /**
     * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
     *
     * 示例:
     *
     * 输入: head = 3->5->8->5->10->2->1, x = 5
     * 输出: 3->1->2->10->5->5->8
     *
     *
     * @return
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(-1);
        ListNode tmpS = small;
        ListNode big = new ListNode(-1);
        ListNode tmpB = big;
        while (head !=null){
            if (head.val < x){
                small.next = new ListNode(head.val);
                small = small.next;
            }else {
                big.next = new ListNode(head.val);
                big = big.next;
            }
            head = head.next;
        }
        small.next = tmpB.next;
        return tmpS.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(6);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(6);
        l5.setNext(l6);
        l4.setNext(l5);
        l3.setNext(l4);
        l2.setNext(l3);
        l1.setNext(l2);
        partition(l1,3);
    }
}
