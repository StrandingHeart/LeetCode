package linkedlist;


/**
 * @Author zhangyong
 * @Date 2021/3/21 10:19
 */
public class 剑指offer06从尾到头打印链表 {

    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     * 示例 1：
     *
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     *
     * 解题思路：反转，遍历
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        int len = 0;
        while (cur!=null){
            len++;
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        int[] res = new int[len];
        int i = 0;
        for (ListNode tmp = pre;tmp!=null;tmp=tmp.next){
            res[i] = tmp.val;
            i++;
        }
        return res;
    }
}
