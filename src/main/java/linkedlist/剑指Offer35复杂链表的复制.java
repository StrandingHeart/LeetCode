package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/21 11:10
 */
public class 剑指Offer35复杂链表的复制 {

    /**
     * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
     * 还有一个 random 指针指向链表中的任意节点或者 null。
     *
     * 解题思路：将原来的复制一份到当前后面----      1-1`-2-2`  这种，然后再复制random 最后遍历一遍就能取到新的节点了。
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        while (cur != null) {
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = cur.next.next;
        }
        cur = head;
        while (cur != null && cur.next != null) {
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        Node old = new Node(-1);
        Node newNode = new Node(-1);
        Node tmpOld = old;
        Node tmpNew = newNode;
        cur = head;
        while (cur != null && cur.next!=null) {
            old.next = cur;
            newNode.next = cur.next;
            cur = cur.next.next;
            old = old.next;
            newNode = newNode.next;
        }
        old.next = null;
        newNode.next = null;
        head = tmpOld.next;
        return tmpNew.next;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n4.next = n5;
        n3.next = n4;
        n2.next = n3;
        n1.next = n2;

        n1.random = n3;
        n2.random = n4;
        n3.random = n5;
        n4.random = n1;
        n5.random = n2;
        剑指Offer35复杂链表的复制  s = new 剑指Offer35复杂链表的复制();
        s.copyRandomList(n1);
    }
}
