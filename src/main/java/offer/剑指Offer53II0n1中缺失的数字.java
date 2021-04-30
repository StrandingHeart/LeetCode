package offer;

/**
 * @author zhangyong
 * Created on 2021-04-30
 */
public class 剑指Offer53II0n1中缺失的数字 {
    //一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
    //
    // 
    //
    //示例 1:
    //
    //输入: [0,1,3]
    //输出: 2
    //示例 2:
    //
    //输入: [0,1,2,3,4,5,6,7,9]
    //输出: 8

    /**
     * 找到索引不能于值的就行
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        if (nums.length-1 == nums[nums.length-1]){
            return nums.length;
        }
        int left = 0;
        int right = nums.length-1;
        while (left < right){
            int mid = (left + right)/2;
            // 0,1,2,4  num[3] = 4
            if (nums[mid] > mid){
                right = mid;
            }else if (nums[mid] <= mid){
                // 缺失在右侧
                left = mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        剑指Offer53II0n1中缺失的数字 s = new 剑指Offer53II0n1中缺失的数字();
        int[] arr = new int[]{0,1};
        System.out.println(s.missingNumber(arr));
    }
}
