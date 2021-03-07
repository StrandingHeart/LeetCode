package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/6 14:47
 */
public class Q61旋转链表 {


    /**
     * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
     * 输入: 0->1->2->NULL, k = 4
     * 输出: 2->0->1->NULL
     * 解释:
     * 向右旋转 1 步: 2->0->1->NULL
     * 向右旋转 2 步: 1->2->0->NULL
     * 向右旋转 3 步: 0->1->2->NULL
     * 向右旋转 4 步: 2->0->1->NULL
     *
     * 解题思路是计算出长度，双指针。fast到最后节点，将链表连成环，当移动完将fast.next=null 断开环就行了。
     */
    public static ListNode rotateRight(ListNode head, int k) {
        // 只有头节点是null的时候需要特殊处理一下
        if (head == null) {
            return null;
        }
        ListNode low = head;
        ListNode fast = head;
        int len = 1;
        while (fast!=null){
            if (fast.next == null){
                // 到链表最后一个节点了，此时将链表连成一个环
                fast.next = head;
                break;
            }
            fast = fast.next;
            len++;
        }
        k = k%len;
        int loop = len-k;
        //  len-k代表的是移动方向几次low指向头结点，画图能看出来端倪
        while (loop > 0){
            low = low.next;
            fast = fast.next;
            loop--;
        }
        fast.next=null;
        return low;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.re1234();
        ListNode listNode = rotateRight(l1, 7);
        System.out.println(listNode);
    }
}
