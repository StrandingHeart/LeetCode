package offer;

/**
 * @author zhangyong
 * Created on 2021-04-13
 */
public class 剑指Offer25合并两个排序的链表 {
    //输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
    //
    //示例1：
    //
    //输入：1->2->4, 1->3->4
    //输出：1->1->2->3->4->4
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode res = new ListNode(-1);
        ListNode ans = res;
        while (l1!=null && l2!=null){
            if (l1.val<l2.val){
                res.next = new ListNode(l1.val);
                l1 = l1.next;
            }else {
                res.next = new ListNode(l2.val);
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
