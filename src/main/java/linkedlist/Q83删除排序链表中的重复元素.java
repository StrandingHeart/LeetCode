package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/7 17:56
 */
public class Q83删除排序链表中的重复元素 {


    /**
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     *
     * 示例 1:
     * 输入: 1->1->2
     * 输出: 1->2
     *
     * 解题思路：遍历一遍。当前的值跟下一个一样就把下一个删除了，不一样就往后遍历。
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode res = cur;
        while (cur!=null && cur.next!=null){
            if (cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l5.setNext(l6);
        l4.setNext(l5);
        l3.setNext(l4);
        l2.setNext(l3);
        l1.setNext(l2);
        ListNode listNode = deleteDuplicates(l1);
        System.out.println(listNode);
    }
}
