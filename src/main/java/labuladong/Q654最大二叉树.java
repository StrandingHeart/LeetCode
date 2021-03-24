package labuladong;

/**
 * @author zhangyong
 * Created on 2021-03-24
 */
public class Q654最大二叉树 {
    //给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
    //
    // 二叉树的根是数组 nums 中的最大元素。
    // 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
    // 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
    //
    // 返回有给定数组 nums 构建的 最大二叉树。

    /**
     * 主要就是找索引，找出最大值之后，最大值左边作为左节点遍历，右边作为右节点遍历递归
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0){
            return null;
        }
        return build(nums,0,nums.length-1);
    }
    TreeNode build(int[] nums,int start,int end){
        if (start > end){
            return null;
        }
        int index = 0;
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (nums[i]>max){
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(nums[index]);
        root.left = build(nums,start,index-1);
        root.right = build(nums,index+1,end);
        return root;
    }

}
