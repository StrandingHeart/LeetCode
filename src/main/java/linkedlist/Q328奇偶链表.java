package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/14 18:33
 */
public class Q328奇偶链表 {


    /**
     * 1-2-3-4-5 ===》   1-3-5-2-4
     *
     * 解题思路：奇链表和偶链表  当链超过3个节点为循环。
     * @param head
     * @return
     */
    public static ListNode oddEvenList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode odd = head;
        ListNode res = odd;
        ListNode even = head.next;
        ListNode evenTmp = even;
        while (even !=null && even.next!=null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenTmp;
        return res;
    }

    /**
     * 切开，但是慢
     * @param head
     * @return
     */
//    public static ListNode oddEvenList(ListNode head) {
//        ListNode cur = head;
//        ListNode ji = new ListNode(-1);
//        ListNode jiTmp = ji;
//        ListNode ou = new ListNode(-1);
//        ListNode ouTmp = ou;
//        boolean flag = false;
//        while (cur!=null){
//            if (!flag){
//                ji.next = cur;
//                ji = ji.next;
//                flag = true;
//            }else {
//                ou.next = cur;
//                ou = ou.next;
//                flag = false;
//            }
//            cur = cur.next;
//        }
//        ji.next = ouTmp.next;
//        return jiTmp.next;
//    }




    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
//        ListNode l6 = new ListNode(6);
//        l5.setNext(l6);
        l4.setNext(l5);
        l3.setNext(l4);
        l2.setNext(l3);
        l1.setNext(l2);
        System.out.println(oddEvenList(l1));
    }
}
