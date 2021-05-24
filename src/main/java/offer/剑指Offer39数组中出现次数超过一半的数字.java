package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhangyong
 * @Date 2021/4/18 16:43
 */
public class 剑指Offer39数组中出现次数超过一半的数字 {
    //数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
    //
    // 
    //
    //你可以假设数组是非空的，并且给定的数组总是存在多数元素。
    //
    // 
    //
    //示例 1:
    //
    //输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
    //输出: 2
    //

    Map<Integer,Integer> map = new HashMap<>();

    public int majorityElement(int[] nums) {
        for (int num : nums) {
            int i = map.getOrDefault(num,0);
            map.put(num,++i);
            if (i * 2 >nums.length){
                return num;
            }
        }
        return -1;
    }

    /**
     * 摩尔投票法，求众数
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int x = 0;
        int vote = 0;
        for (int num : nums) {
            if (vote == 0){
                x = num;
            }
            vote += num == x? 1:-1;
        }
        return x;
    }

}
