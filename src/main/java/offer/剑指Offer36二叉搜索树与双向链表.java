package offer;

/**
 * @author zhangyong
 * Created on 2021-04-15
 */
public class 剑指Offer36二叉搜索树与双向链表 {
    //输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
    //我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
    //特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。

    private Node head,pre;

    public Node treeToDoublyList(Node root) {
        if(root == null){
            return null;
        }
        dp(root);
        // 接头尾
        head.left = pre;
        pre.right = head;
        return head;
    }


    private void dp(Node root){
        if (root == null){
            return;
        }
        dp(root.left);
        if (pre == null){
            // 记录头结点
            head = root;
        }else {
            // 后续节点设置前后指针
            pre.right = root;
        }
        root.left = pre;
        // 往后移动
        pre = root;
        dp(root.right);
    }
}
