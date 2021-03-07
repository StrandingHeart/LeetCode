package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/2/25 22:39
 */
public class Q19删除倒数第n个节点 {

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * 单链表访问逆序元素的问题，最好的办法是使用双指针。
     * 哑节点其实就是在头节点前面加上一个节点，便于处理头节点的一些特殊情况，省去不必要的代码。
     * 而对于这种删除链表节点的题目，一般要找到前驱节点
     * 返回的时候返回哑节点的下一个节点，也就是头节点，注意，不能直接返回头节点，直接返回头节点就失去它存在的意义了，而且会出错
     *
     *
     * 解题思路：哑结点帮助减去头结点判断，找到被删除位置的前驱节点就行了，双指针，
     * fast遍历n次后，slow,fast一起遍历，fast再遍历到尾时slow就是指向前驱了，然后删除就行了。
     */

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        // 添加哑结点
        ListNode res = new ListNode(0,head);
        // slow 和 res指向同一个地址
        ListNode slow = res;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(4);
//        l3.setNext(l4);
//        l2.setNext(l3);
        l1.setNext(l2);
        System.out.println(removeNthFromEnd(l1, 2));
    }
}
