package labuladong;

/**
 * @Author zhangyong
 * @Date 2021/3/24 22:38
 */
public class Q106从中序与后序遍历序列构造二叉树 {

    //根据一棵树的中序遍历与后序遍历构造二叉树。
    //
    //注意:
    //你可以假设树中没有重复的元素。
    //
    //例如，给出
    //
    //中序遍历 inorder = [9,3,15,20,7]
    //后序遍历 postorder = [9,15,7,20,3]
    //返回如下的二叉树：
    //
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    /**
     * 解题思路：这个跟105题很相似，就是找索引，有一个注意的点是，index是在inorder中的，在postorder中不要直接用index。
     * index-inStart才是真正移动的下标位置
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int poStart, int poEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int val = postorder[poEnd];
        int index = 0;
        for (int i = inStart;i<=inEnd;i++){
            if (val == inorder[i]){
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(val);
        int move = index - inStart;
        root.left = build(inorder,inStart,index-1,postorder,poStart,move+poStart-1);
        root.right = build(inorder,index+1,inEnd,postorder,move+poStart,poEnd-1);
        return root;
    }
}
