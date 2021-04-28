package offer;

import java.util.Arrays;

/**
 * @author zhangyong
 * Created on 2021-04-23
 */
public class 剑指Offer45把数组排成最小的数 {

    //输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
    //示例 1:
    //
    //输入: [10,2]
    //输出: "102"
    //
    //输入: [3,30,34,5,9]
    //输出: "3033459"

    public String minNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        // 3 & 30 ==>   330    303
        Arrays.sort(arr,(x,y)->(x+y).compareTo(y+x));
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        剑指Offer45把数组排成最小的数 s = new 剑指Offer45把数组排成最小的数();
        String s1 = s.minNumber(new int[]{3,30,34,5,9,0});
        System.out.println(s1);
    }

}
