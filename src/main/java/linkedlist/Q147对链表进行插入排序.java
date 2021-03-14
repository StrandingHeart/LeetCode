package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/13 19:57
 */
public class Q147对链表进行插入排序 {

    /**
     * 对链表进行插入排序，插入排序的过程就是 再遍历链表的时候，拿当前节点与不断与之前的节点比较，将小的放前面
     *
     * 解题思路：插入排序，遍历的同时，当前的值跟移动过的值比较如果小，就说明要往前插，prev指针从开始遍历直到找到大于cur的节点在前面插入；
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode moved = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (moved.val <= cur.val) {
                moved = moved.next;
                cur = cur.next;
            } else {
                ListNode prev = pre;
                while (prev.next.val <= cur.val){
                    prev = prev.next;
                }
                // 将链接上，把cur节点去掉，接上后面的
                moved.next = cur.next;
                // cur节点移动到前面位置
                cur.next = prev.next;
                prev.next = cur;
                cur = moved.next;
            }
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(7);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);
        l5.setNext(l6);
        l4.setNext(l5);
        l3.setNext(l4);
        l2.setNext(l3);
        l1.setNext(l2);

        Q147对链表进行插入排序 s = new Q147对链表进行插入排序();
        System.out.println(s.insertionSortList(l1));
    }

}
