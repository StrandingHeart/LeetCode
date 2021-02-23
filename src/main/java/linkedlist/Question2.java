package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/2/23 22:49
 */
public class Question2 {

    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     */


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0;
        //  cur 作为不断变化的指针
        ListNode cur = new ListNode(0);
        //  res 指向cur后不再变化
        ListNode res = cur;
        while (l1!=null || l2!=null){
            int a1 = l1!=null?l1.val:0;
            int a2 = l2!=null?l2.val:0;
            int sum = a1+a2+add;
            add = sum / 10;
            // cur next开始存的是真正的结果
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1!=null){
                l1 = l1.next;
            }
            if (l2!=null){
                l2 = l2.next;
            }
        }
        if (add > 0){
            cur.next = new ListNode(add);
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l2.setNext(l3);
        l1.setNext(l2);


        ListNode q1 = new ListNode(5);
        ListNode q2 = new ListNode(6);
        ListNode q3 = new ListNode(4);
        q2.setNext(q3);
        q1.setNext(q2);

        System.out.println(l1);
        System.out.println(q1);

        ListNode listNode = addTwoNumbers(l1, q1);
        System.out.println(listNode);
    }
}
