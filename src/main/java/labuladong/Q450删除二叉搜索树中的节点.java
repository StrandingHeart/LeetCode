package labuladong;

/**
 * @Author zhangyong
 * @Date 2021/4/1 23:11
 */
public class Q450删除二叉搜索树中的节点 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return null;
        }
        if (root.val == key){
            if (root.left==null) {
                // 情况1，欲删除节点无左子
                return root.right;
            }
            if (root.right==null) {
                // 情况2，欲删除节点无右子
                return root.left;
            }
            // 情况3，欲删除节点左右子都有
            TreeNode node = root.right;
            // 寻找欲删除节点右子树的最左节点
            while (node.left!=null){
                node = node.left;
            }
            // 将欲删除节点的左子树成为其右子树的最左节点的左子树
            node.left = root.left;
            // 欲删除节点的右子顶替其位置，节点被删除
            root = root.right;
        }else if (root.val > key){
            root.left = deleteNode(root.left,key);
        }else {
            root.right = deleteNode(root.right,key);
        }
        return root;
    }


    public TreeNode min(TreeNode root){
        while (root.left!=null){
            root = root.left;
        }
        return root;
    }
}
