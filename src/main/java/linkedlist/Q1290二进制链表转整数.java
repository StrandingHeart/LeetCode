package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/18 22:14
 */
public class Q1290二进制链表转整数 {


    /**
     * 先反转，到pre节点，然后遍历 按照2进制进行乘 加 就行了
     * @param head
     * @return
     */
    public int getDecimalValue(ListNode head) {
        if (head == null) {
            return 0;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        int loop = 1;
        int sum = 0;
        while (pre != null) {
            sum += pre.val * loop;
            pre = pre.next;
            loop *= 2;
        }
        return sum;
    }
}
