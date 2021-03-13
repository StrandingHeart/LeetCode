package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/13 15:29
 */
public class Q138复制带随机指针的链表 {

    /**
     * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
     * <p>
     * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
     * <p>
     * 解题思路：将节点依次拷贝放到next节点上，然后random也是同样的操作，最后拆开成两个链、
     *
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        cur = head;
        while (cur != null) {
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        Node old = head;
        Node newNode = head.next;
        Node res = head.next;
        while (newNode != null) {
            old.next = old.next.next;
            newNode.next = newNode.next == null ? null : newNode.next.next;
            // 往尾部挂节点
            old = old.next;
            newNode = newNode.next;
        }
        return res;
    }
}
