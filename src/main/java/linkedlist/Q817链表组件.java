package linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhangyong
 * @Date 2021/3/16 22:00
 */
public class Q817链表组件 {

    /**
     * 给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。
     *
     * 同时给定列表 G，该列表是上述链表中整型值的一个子集。
     *
     * 返回列表 G 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 G 中）构成的集合。
     * 输入:
     * head: 0->1->2->3->4
     * G = [0, 3, 1, 4]
     * 输出: 2
     * 解释:
     * 链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。
     *
     * 解题思路：有个算法，当前节点在G中出现且next节点在G中没出现就是组件的次数
     * @author zhangyong
     * 2021/3/16 22:01
     */
    public int numComponents(ListNode head, int[] G) {
        if (head == null){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < G.length; i++) {
            map.put(G[i],null);
        }
        int res = 0;
        ListNode cur = head;
        while (cur!=null){
            if (map.containsKey(cur.val) && (cur.next==null||!map.containsKey(cur.next.val))){
                res++;
            }
            cur = cur.next;
        }
        return res;
    }
}
