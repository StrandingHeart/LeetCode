package offer;

/**
 * @author zhangyong
 * Created on 2021-04-14
 */
public class 剑指Offer33二叉搜索树的后序遍历序列 {
    //输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
    //
    // 
    //
    //参考以下这颗二叉搜索树：
    //
    //     5
    //    / \
    //   2   9
    //  / \  /\
    // 1   3 7  10
    // 1,3,2,7,10,9,5
    //示例 1：
    //
    //输入: [1,6,3,2,5]
    //输出: false
    //示例 2：
    //
    //输入: [1,3,2,6,5]
    //输出: true
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    /**
     * 二叉搜索树，左子树<根<右子树
     * 最后为根节点，找到第一个大于根节点的就是右子树的开始，如果后面有小于根的说明不是后序遍历
     *
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        return dp(postorder, 0, postorder.length - 1);
    }

    private boolean dp(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int root = postorder[end];
        int mid = start;
        while (postorder[mid] < root) {
            mid++;
        }
        // 第一个大于root的，这个是右子树的起点
        int tmp = mid;
        // 右子树有小于 root 的就错了
        while (tmp < end) {
            if (postorder[tmp++] < root) {
                return false;
            }
        }
        return dp(postorder,start,mid-1)&&dp(postorder,mid,end-1);
    }


    public static void main(String[] args) {
        剑指Offer33二叉搜索树的后序遍历序列 s = new 剑指Offer33二叉搜索树的后序遍历序列();
        System.out.println(s.verifyPostorder(new int[]{1,2,5,10,6,9,4,3}));
        System.out.println(s.verifyPostorder(new int[]{4, 8, 6, 12, 16, 14, 10}));
    }

}
