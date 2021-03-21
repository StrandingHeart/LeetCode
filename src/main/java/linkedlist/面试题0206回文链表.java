package linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author zhangyong
 * @Date 2021/3/21 13:59
 */
public class 面试题0206回文链表 {

    /**
     * 编写一个函数，检查输入的链表是否是回文的。
     *
     *  
     *
     * 示例 1：
     *
     * 输入： 1->2
     * 输出： false
     * 示例 2：
     *
     * 输入： 1->2->2->1
     * 输出： true
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = slow.next;
        ListNode pre = head;
        Deque<Integer> stack = new ArrayDeque<>();
        while (slow!=null){
            stack.push(slow.val);
            slow = slow.next;
        }
        while (!stack.isEmpty()){
            Integer pop = stack.pop();
            if (pop != pre.val){
                return false;
            }
            pre = pre.next;
        }
        return true;
    }
}
