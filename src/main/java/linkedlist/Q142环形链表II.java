package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/13 16:58
 */
public class Q142环形链表II {

    /**
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     *
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
     *
     * 说明：不允许修改给定的链表。
     *
     * 你是否可以使用 O(1) 空间解决此题？
     * 示例 1：
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：返回索引为 1 的链表节点
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 解题思路：快慢指针找到环,然后设置虚拟指针指向head，虚拟指针和slow同时往后移动一步，当相遇时即是环的起点。
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean circle = false;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                circle = true;
                break;
            }
        }
        // 前面代码能看出来有没有环，没环就返回null
        if (!circle){
            return null;
        }
        // 设置头结点与slow节点，同时往后移动一步，当相遇时就是环的起点了。
        ListNode pre = head;
        while (pre!=slow){
            pre = pre.next;
            slow = slow.next;
        }
        return pre;
    }
}
