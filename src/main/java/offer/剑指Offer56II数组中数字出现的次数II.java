package offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author zhangyong
 * Created on 2021-05-11
 */
public class 剑指Offer56II数组中数字出现的次数II {
    //在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
    //
    // 
    //
    //示例 1：
    //
    //输入：nums = [3,4,3,3]
    //输出：4
    //示例 2：
    //
    //输入：nums = [9,1,7,9,7,9,7]
    //输出：1

    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue()>1){
                continue;
            }
            return entry.getKey();
        }
        return 0;
    }

    public static void main(String[] args) {
        剑指Offer56II数组中数字出现的次数II s = new 剑指Offer56II数组中数字出现的次数II();
        System.out.println(s.singleNumber(new int[]{9, 1, 7, 9, 7, 9, 7}));
    }
}
