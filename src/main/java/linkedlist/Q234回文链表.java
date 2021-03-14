package linkedlist;

import java.util.Stack;

/**
 * @Author zhangyong
 * @Date 2021/3/14 17:32
 */
public class Q234回文链表 {

    // 使用栈,快慢指针，遍历的时候入栈，然后快指针遍历结束，出栈并和slow的节点值比较判断是否回文
    /*public static boolean isPalindrome1(ListNode head) {
        if (head == null){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next!=null){
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast!=null){
            // 奇数长度
            while (slow!=null && slow.next!=null){
                slow = slow.next;
                Integer pop = stack.pop();
                if (slow.val != pop){
                    return false;
                }
            }
        }else {
            // 偶数长度
            while (slow!=null){
                Integer pop = stack.pop();
                if (slow.val != pop){
                    return false;
                }
                slow = slow.next;
            }
        }
        return true;
    }*/


    /**
     * 将中点后面的反转，然后比较      还有一种办法是从头遍历的时候，并反转前面的节点。 fast走完比较
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return result;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private static ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // next和next.next能保证偶数链表中点出现在前面  1-2-3-4  2的位置  而 fast  fast.next的方式中点会出现在3的位置需要额外判断
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
//        ListNode l5 = new ListNode(1);

//        l4.setNext(l5);
        l3.setNext(l4);
        l2.setNext(l3);
        l1.setNext(l2);
        System.out.println(isPalindrome(l1));
    }
}
