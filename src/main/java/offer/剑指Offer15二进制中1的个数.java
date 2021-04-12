package offer;

/**
 * @author zhangyong
 * Created on 2021-04-12
 */
public class 剑指Offer15二进制中1的个数 {

    //请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。
    //例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
    //示例 1：
    //输入：00000000000000000000000000001011
    //输出：3
    //解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。

    /**
     * 二进制的运算要考虑到 & | >> >>> ^ 与 或 移位 无符号移位 异或
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            // n=  1111001
            // n-1=1111000
            // &   1111000
            n = n & (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        剑指Offer15二进制中1的个数 s = new 剑指Offer15二进制中1的个数();
        System.out.println(s.hammingWeight(1));
        System.out.println(10 >> 1);
    }
}
