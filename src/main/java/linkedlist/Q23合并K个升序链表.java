package linkedlist;

/**
 * @Author zhangyong
 * @Date 2021/3/19 20:42
 */
public class Q23合并K个升序链表 {

    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     *
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     *
     * 解题思路：这个就是个归并排序，归并的是链表而已。
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeList(lists,0,lists.length-1);
    }

    public ListNode mergeList(ListNode[] lists,int head,int tail){
        if (head == tail){
            return lists[head];
        }
        if (head > tail){
            return null;
        }
        int mid = (head+tail)/2;
        return merge(mergeList(lists,head,mid),mergeList(lists,mid+1,tail));
    }

    private ListNode merge (ListNode l1,ListNode l2){
        ListNode res = new ListNode(-1);
        ListNode ans = res;
        while (l1!=null && l2!=null){
            if (l1.val <= l2.val){
                res.next = l1;
                l1 = l1.next;
            }else {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }
        if (l1!=null){
            res.next = l1;
        }
        if (l2!=null){
            res.next = l2;
        }
        return ans.next;
    }
}
