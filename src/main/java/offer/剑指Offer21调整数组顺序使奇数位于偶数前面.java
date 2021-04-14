package offer;

/**
 * @author zhangyong
 * Created on 2021-04-13
 */
public class 剑指Offer21调整数组顺序使奇数位于偶数前面 {
    //输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
    //
    // 
    //
    //示例：
    //
    //输入：nums = [1,2,3,4]
    //输出：[1,3,2,4]
    //注：[3,1,2,4] 也是正确的答案之一。
    public int[] exchange(int[] nums) {
        int fast = 0;
        int slow = 0;
        while (fast != nums.length) {
            if ((nums[fast] & 1) == 1) {
                int tmp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = tmp;
                slow++;
            }
            fast++;
        }
        return nums;
    }

    public static void main(String[] args) {
        剑指Offer21调整数组顺序使奇数位于偶数前面 s = new 剑指Offer21调整数组顺序使奇数位于偶数前面();
        int[] exchange = s.exchange(new int[]{2,16,3,5,13,1,16,1,12,18,11,8,11,11,5,1});
        for (int i = 0; i < exchange.length; i++) {
            System.out.print(exchange[i] + ",");
        }
    }
}
