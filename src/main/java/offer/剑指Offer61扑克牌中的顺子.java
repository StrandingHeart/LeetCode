package offer;

import java.util.Arrays;

/**
 * @author zhangyong
 * Created on 2021-05-07
 */
public class 剑指Offer61扑克牌中的顺子 {

    //从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。
    // A 不能视为 14。
    //
    // 
    //
    //示例 1:
    //
    //输入: [1,2,3,4,5]
    //输出: True
    //
    //


    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == 0) {
                start++;
            } else if(nums[i] == nums[i + 1]) {
                return false;
            }
        }
        return nums[nums.length-1] - nums[start] < 5;
        //int joker = 0;
        //        Arrays.sort(nums); // 数组排序
        //        for(int i = 0; i < 4; i++) {
        //            if(nums[i] == 0) joker++; // 统计大小王数量
        //            else if(nums[i] == nums[i + 1]) return false; // 若有重复，提前返回 false
        //        }
        //        return nums[4] - nums[joker] < 5;
        //
    }

    public static void main(String[] args) {
        剑指Offer61扑克牌中的顺子 s= new 剑指Offer61扑克牌中的顺子();
        System.out.println(s.isStraight(new int[]{1, 2, 3, 4, 6}));
        System.out.println(s.isStraight(new int[]{1, 2, 3, 4, 5}));
        System.out.println(s.isStraight(new int[]{0, 2, 3, 4, 5}));
        System.out.println(s.isStraight(new int[]{0, 2, 3, 4, 6}));
        System.out.println(s.isStraight(new int[]{0, 2, 3, 4, 7}));
    }
}
