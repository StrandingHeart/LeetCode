package offer;

/**
 * @author zhangyong
 * Created on 2021-04-15
 */
public class 剑指Offer35复杂链表的复制 {
    //请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        Node cur = head;
        while (cur!=null){
            Node copy= new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = cur.next.next;
        }
        Node randCur = head;
        while (randCur!=null&&randCur.next != null){
             randCur.next.random = randCur.random == null ?null:randCur.random.next;
             randCur = randCur.next.next;
        }
        Node old = new Node(-1);
        Node newNode = new Node(-1);
        Node resCur = head;
        Node tmpOld = old;
        Node tmpNew = newNode;
        while (resCur!=null){
            old.next = resCur;
            old = old.next;
            newNode.next = resCur.next;
            newNode = newNode.next;
            resCur = resCur.next.next;
        }
        old.next = null;
        newNode.next = null;
        // 将源节点置回去
        head = tmpOld.next;
        return tmpNew.next;
    }
}
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/