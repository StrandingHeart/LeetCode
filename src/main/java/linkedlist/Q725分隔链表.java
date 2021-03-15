package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/15 22:31
 */
public class Q725分隔链表 {

    /**
     * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
     *
     * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
     *
     * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
     *
     * 返回一个符合上述规则的链表的列表。
     *
     * 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
     *
     * 解题思路：首先分配一下每个位置分多少长度。  arr[i%k]即是；然后再遍历断开链接就行了。
     *
     * @return
     */
    public static ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        if (root == null){
            return res;
        }
        int[] arr = new int[k];
        ListNode loop = root;
        int len = 0;
        while (loop!=null){
            len++;
            loop = loop.next;
        }
        for (int i = 0; i < len; i++) {
            arr[i%k]++;
        }
        ListNode cur = root;
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            ListNode nowNode = new ListNode(-1);
            nowNode.next = cur;
            ListNode tmpNode = nowNode;
            while (cur!=null && tmp>0){
                tmp--;
                cur = cur.next;
                tmpNode = tmpNode.next;
            }
            tmpNode.next = null;
            res[i] = nowNode.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l5.setNext(l6);
        l4.setNext(l5);
        l3.setNext(l4);
        l2.setNext(l3);
        l1.setNext(l2);
        ListNode[] listNodes = splitListToParts(l1, 3);
    }
}
