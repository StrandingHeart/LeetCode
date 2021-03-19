package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/14 14:57
 */
public class Q148排序链表 {

    /**
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     *
     * 进阶：
     *
     * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sort-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 解题思路：归并排序时间复杂度是 nlogn
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        return sort(head,null);
    }

    public ListNode sort(ListNode head,ListNode tail){
        // 当头==尾时，说明当前节点下面没有子树了。
        if (head == tail){
            return head;
        }
        // 找中点，然后合并，类似构建二叉树
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=tail && fast.next!=tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode next = mid.next;
        mid.next = null;
        ListNode left = sort(head, mid);
        ListNode right = sort(next, tail);
        return merge(left, right);
    }

    /**
     * 合并两个升序链表
     * @param l1
     * @param l2
     */
    public ListNode merge(ListNode l1,ListNode l2){
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        while (l1!=null && l2!=null){
            if (l1.val >= l2.val){
                cur.next = l2;
                l2 = l2.next;
            }else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        if (l1!=null){
            cur.next = l1;
        }
        if (l2!=null){
            cur.next = l2;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l2.setNext(l3);
        l1.setNext(l2);


        ListNode q1 = new ListNode(3);
        ListNode q2 = new ListNode(4);
        ListNode q3 = new ListNode(5);
        q2.setNext(q3);
        q1.setNext(q2);

        System.out.println(l1);
        System.out.println(q1);

        Q148排序链表 s = new Q148排序链表();
        ListNode listNode = s.sortList(l1);
        System.out.println(listNode);
    }
}
