package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/14 17:02
 */
public class Q237删除链表中的节点 {

    /**
     * 这个题不太好理解，意思是给定要删除的节点，让你干掉他。且要删除的不是最后的节点
     * 解题思路：当前节点的值 = 下个节点的值。然后将下个节点去掉....
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
