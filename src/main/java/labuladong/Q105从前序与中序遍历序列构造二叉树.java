package labuladong;

/**
 * @author zhangyong
 * Created on 2021-03-24
 */
public class Q105从前序与中序遍历序列构造二叉树 {

    //根据一棵树的前序遍历与中序遍历构造二叉树。
    //
    // 注意:
    //你可以假设树中没有重复的元素。
    //
    // 例如，给出
    //
    // 前序遍历 preorder = [3,9,20,15,7]
    // 中序遍历 inorder = [9,3,15,20,7]
    //
    // 返回如下的二叉树：
    //
    //     3
    //   / \
    //  9  20
    //    /  \
    //   15   7

    /**
     * 解题思路：这种题就是找索引位置
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int val = preorder[preStart];
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == val){
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(val);
        int move = index - inStart;
        root.left = build(preorder,preStart+1,preStart+move,inorder,inStart,index-1);
        root.right = build(preorder,preStart+move+1,preEnd,inorder,index+1,inEnd);
        return root;
    }
}
