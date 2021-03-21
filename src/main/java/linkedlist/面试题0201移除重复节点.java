package linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhangyong
 * @Date 2021/3/21 12:45
 */
public class 面试题0201移除重复节点 {
    /**
     * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
     *
     *     示例1:
     *
     *     输入：[1, 2, 3, 3, 2, 1]
     *     输出：[1, 2, 3]
     *
     *
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null){
            return null;
        }
        Map<Integer,Boolean> map = new HashMap<>();
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode cur = res;
        while (cur.next!=null){
            if (map.containsKey(cur.next.val)){
                cur.next = cur.next.next;
            }else {
                map.put(cur.next.val,null);
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(1);
        l4.setNext(l5);
        l3.setNext(l4);
        l2.setNext(l3);
        l1.setNext(l2);
        面试题0201移除重复节点 s = new 面试题0201移除重复节点();
        System.out.println(s.removeDuplicateNodes(l1));
    }

}
