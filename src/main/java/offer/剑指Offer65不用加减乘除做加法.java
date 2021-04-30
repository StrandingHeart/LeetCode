package offer;

/**
 * @author zhangyong
 * Created on 2021-04-30
 */
public class 剑指Offer65不用加减乘除做加法 {
    //写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
    //示例:
    //
    //输入: a = 1, b = 1
    //输出: 2
    //a, b 均可能是负数或 0
    //结果不会溢出 32 位整数

    // 进位
    public int add(int a, int b) {
        if (b == 0) {
            return a;
        }
        // 转换成非进位和 + 进位
        return add(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        剑指Offer65不用加减乘除做加法 s = new 剑指Offer65不用加减乘除做加法();
        s.add(99,99);
    }
}
