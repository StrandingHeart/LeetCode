package linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author zhangyong
 * @Date 2021/3/16 21:50
 */
public class Q430扁平化多级双向链表 {

    /**
     * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
     *
     * 给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。
     *
     * 输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
     * 输出：[1,2,3,7,8,11,12,9,10,4,5,6]
     *
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
