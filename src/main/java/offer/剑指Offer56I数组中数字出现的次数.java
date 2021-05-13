package offer;

/**
 * @author zhangyong
 * Created on 2021-05-11
 */
public class 剑指Offer56I数组中数字出现的次数 {

    //一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
    //
    // 
    //
    //示例 1：
    //
    //输入：nums = [4,1,4,6]
    //输出：[1,6] 或 [6,1]
    //示例 2：
    //
    //输入：nums = [1,2,10,4,1,4,3,3]
    //输出：[2,10] 或 [10,2]
    //

    public int[] singleNumbers(int[] nums) {
        int res = 0;
        // 异或能求出两个值异或的结果
        for (int num : nums) {
            res ^= num;
        }
        // mark 是异或结果res最低的为1的值   0001   0010  0100
        int mark = 1;
        while ((mark & res) == 0) {
            mark = mark << 1;
        }
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & mark) == 0){
                a^=num;
            }else {
                b^=num;
            }
        }
        return new int[]{a,b};

    }
}
