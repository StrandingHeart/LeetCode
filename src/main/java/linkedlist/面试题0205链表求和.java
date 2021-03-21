package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/21 13:53
 */
public class 面试题0205链表求和 {

    /**
     * 给定两个用链表表示的整数，每个节点包含一个数位。
     *
     * 这些数位是反向存放的，也就是个位排在链表首部。
     *
     * 编写函数对这两个整数求和，并用链表形式返回结果。
     *
     *
     *
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0;
        ListNode res = new ListNode(-1);
        ListNode ans = res;
        while (l1!=null || l2!=null || add > 0){
            int a = l1==null?0:l1.val;
            int b = l2==null?0:l2.val;
            int sum = a+b+add;
            add = sum / 10;
            res.next = new ListNode(sum%10);
            res = res.next;
            if (l1!=null){
                l1 = l1.next;
            }
            if (l2!=null){
                l2 = l2.next;
            }
        }
        return ans.next;
    }
}
