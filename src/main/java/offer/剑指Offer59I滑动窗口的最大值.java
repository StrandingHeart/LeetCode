package offer;

/**
 * @author zhangyong
 * Created on 2021-05-25
 */
public class 剑指Offer59I滑动窗口的最大值 {

    //给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
    //
    //示例:
    //
    //输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
    //输出: [3,3,5,5,6,7]
    //解释:
    //
    //  滑动窗口的位置                最大值
    //---------------               -----
    //[1  3  -1] -3  5  3  6  7       3
    // 1 [3  -1  -3] 5  3  6  7       3
    // 1  3 [-1  -3  5] 3  6  7       5
    // 1  3  -1 [-3  5  3] 6  7       5
    // 1  3  -1  -3 [5  3  6] 7       6
    // 1  3  -1  -3  5 [3  6  7]      7
    //你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        // 滑动窗口起始索引
        int start = 0;
        // 滑动窗口结束索引
        int end = k - 1;
        // 结果集
        int[] arr = new int[nums.length - k + 1];
        // 结果集索引
        int m = 0;
        // 窗口最大值索引
        int index = 0;
        // 窗口最大值
        int lastValue = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length && end < nums.length; i++) {
            if (lastValue < nums[end] || index < start) {
                // 重算最大值
                int tmp = Integer.MIN_VALUE;
                for (int j = start; j <= end; j++) {
                    if (nums[j] > tmp) {
                        tmp = nums[j];
                        index = j;
                        lastValue = nums[j];
                    }
                }
            }
            arr[m] = lastValue;
            m++;
            start++;
            end++;
        }
        return arr;
    }

    public static void main(String[] args) {
        剑指Offer59I滑动窗口的最大值 s = new 剑指Offer59I滑动窗口的最大值();
        int[] ints = s.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        for (int i : ints) {
            System.out.println(i);
        }
    }
}
