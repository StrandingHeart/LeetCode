package linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author zhangyong
 * @Date 2021/3/15 22:16
 */
public class Q445两数相加II {

    /**
     * 1-2-3-4  l1
     *   3-4-5  l2
     * 1-5-7-9  l3
     * l1 + l2 = l3 不用反转链表
     *
     * 逆序对，反转这种都可以用栈来实现。
     * @return
     */

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        while (l1!=null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2!=null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode cur = null;
        int add = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || add !=0){
            int a = stack1.isEmpty()?0:stack1.poll();
            int b = stack2.isEmpty()?0:stack2.poll();

            int sum = a+b+add;
            add = sum / 10;
            ListNode node = new ListNode(sum%10);
            node.next = cur;
            cur = node;
        }
        return cur;
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
