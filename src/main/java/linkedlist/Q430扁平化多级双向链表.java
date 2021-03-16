package linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author zhangyong
 * @Date 2021/3/16 21:50
 */
public class Q430扁平化多级双向链表 {

    /**
     * 解题思路：这个题其实就是一个深度优先搜索，但是有个小坑，就是是一个双链表，要把结果的child置空，prev指向前驱。
     *
     * @param head
     * @return
     */

    public Node flatten(Node head) {
        if (head == null){
            return null;
        }
        Deque<Node> stack = new ArrayDeque<>();
        Node res = new Node(-1);
        Node ans = res;
        stack.push(head);
        while (!stack.isEmpty()){
            Node pop = stack.pop();
            if (pop.next!=null){
                stack.push(pop.next);
            }
            if (pop.child!=null){
                stack.push(pop.child);
            }
            // 指前后节点，child置空
            pop.next = null;
            pop.child = null;
            res.next = pop;
            pop.prev = res;
            res = res.next;
        }
        ans = ans.next;
        ans.prev = null;
        return ans;
    }
}
