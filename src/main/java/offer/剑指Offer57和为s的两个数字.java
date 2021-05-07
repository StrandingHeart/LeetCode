package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyong
 * Created on 2021-05-07
 */
public class 剑指Offer57和为s的两个数字 {
    //输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
    //
    // 
    //
    //示例 1：
    //
    //输入：nums = [2,7,11,15], target = 9
    //输出：[2,7] 或者 [7,2]
    //

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)){
                return new int[]{num,map.get(num)};
            }
            map.put(target-num,num);
        }
        return null;
    }


    public int[] twoSum2(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<right){
            int tmp = nums[left] + nums[right];
            if (tmp > target){
                right--;
            }else if (tmp < target){
                left++;
            }else {
                return new int[]{nums[left],nums[right]};
            }
        }
        return null;
    }


    public static void main(String[] args) {
        剑指Offer57和为s的两个数字 s = new 剑指Offer57和为s的两个数字();
        int[] arr= new int[]{10,26,30,31,47,60};
        int[] ints = s.twoSum(arr, 40);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
