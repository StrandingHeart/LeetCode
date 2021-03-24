package offer;

/**
 * @author zhangyong
 * Created on 2021-03-23
 */
public class 剑指Offer06从尾到头打印链表 {

    //输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
    //示例 1：
    //
    //输入：head = [1,3,2]
    //输出：[2,3,1]
    //0 <= 链表长度 <= 10000

    /**
     * 先反转，再遍历
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        ListNode pre = null;
        int len = 0;
        while (head!=null){
            len++;
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        int[] arr = new int[len];
        int i = 0;
        while (pre!=null){
            arr[i] = pre.val;
            i++;
            pre = pre.next;
        }
        return arr;
    }
}
