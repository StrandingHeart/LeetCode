package offer;


/**
 * @author zhangyong05
 * Created on 2021-03-23 11:33
 */
public class 剑指Offer07重建二叉树 {

    //输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
    //例如，给出
    //
    //前序遍历 preorder = [3,9,20,15,7]
    //中序遍历 inorder = [9,3,15,20,7]
    //返回如下的二叉树：
    //
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //限制：
    //
    //0 <= 节点个数 <= 5000

    /**
     * 解题思路：
     * 前序遍历：[ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
     * 中序遍历：[ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
     * 只要找到对应位置的索引就好了，递归. 左子树的前序和中序绑起来，  右子树同理
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0){
            return null;
        }
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int val = preorder[preStart];
        int index = -1;
        for (int i = inStart;i<=inEnd;i++){
            if (inorder[i] == val){
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(val);
        int move = index-inStart;
        root.left = build(preorder,preStart+1,move+preStart,inorder,inStart,index-1);
        root.right = build(preorder,preStart+move+1,preEnd,inorder,index+1,inEnd);
        return root;
    }

}
