package offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author zhangyong
 * @Date 2021/3/22 21:59
 */
public class 剑指Offer03数组中重复的数字 {

    //找出数组中重复的数字。
    //
    //
    //在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
    //请找出数组中任意一个重复的数字。
    //
    //示例 1：
    //
    //输入：
    //[2, 3, 1, 0, 2, 5, 3]
    //输出：2 或 3
    // 
    //限制：
    //
    //2 <= n <= 100000

    /**
     * 解题思路：用去重的结构存一下，如果再有就证明是重复的了。
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int s : nums) {
            if (set.contains(s)){
                return s;
            }else {
                set.add(s);
            }
        }
        return -1;
    }
}
