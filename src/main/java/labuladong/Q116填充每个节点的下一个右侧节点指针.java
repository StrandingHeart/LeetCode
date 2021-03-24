package labuladong;

/**
 * @author zhangyong
 * Created on 2021-03-24
 */
public class Q116填充每个节点的下一个右侧节点指针 {

    //给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。
    // 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。
    // 如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
    //
    // 初始状态下，所有 next 指针都被设置为 NULL。

    /**
     * 解题思路：需要将左节点指向右节点，然后不同父的节点也要指(左边的right -> 右边的left)。
     * 需要一个函数入参两个节点来绑定关系
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        connectNode(root.left,root.right);
        return root;
    }

    void connectNode(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        node1.next = node2;
        connectNode(node1.left,node1.right);
        connectNode(node2.left,node2.right);
        connectNode(node1.right,node2.left);
    }

}
