package offer;

/**
 * @Author zhangyong
 * @Date 2021/3/13 13:38
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

class Node {
    int val;
    Node next;
    Node random;
    Node left;
    Node right;
    public Node prev;
    public Node child;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}