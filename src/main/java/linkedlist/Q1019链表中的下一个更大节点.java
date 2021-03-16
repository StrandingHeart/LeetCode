package linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhangyong
 * @Date 2021/3/16 22:08
 */
public class Q1019链表中的下一个更大节点 {

    /**
     * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
     *
     * 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。
     *
     * 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
     *
     * 输入：[1,7,5,1,9,2,5,1]
     * 输出：[7,9,9,9,0,5,0,0]
     *
     * // 这个暴力就能解出来，高端点的可以用单调栈来完成。
     * @param head
     * @return
     */
    public int[] nextLargerNodes(ListNode head) {
        if (head == null){
            return new int[]{0};
        }
        ListNode cur = head;
        List<Integer> res = new ArrayList<>();
        while (cur!=null){
            int i = cur.val;
            ListNode tmp = cur.next;
            boolean flag = false;
            while (tmp!=null){
                int j = tmp.val;
                if (j>i){
                    flag = true;
                    res.add(j);
                    break;
                }
                tmp = tmp.next;
            }
            if (!flag){
                res.add(0);
            }
            cur = cur.next;
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}
