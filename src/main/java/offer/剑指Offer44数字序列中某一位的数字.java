package offer;

/**
 * @author zhangyong
 * Created on 2021-04-22
 */
public class 剑指Offer44数字序列中某一位的数字 {

    //数字以0123456789101112131415…的格式序列化到一个字符序列中。
    //在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
    //请写一个函数，求任意第n位对应的数字。
    //示例 1：
    //
    //输入：n = 3
    //输出：3
    //示例 2：
    //
    //输入：n = 11
    //输出：0
    // 0123456789101112131415     15
    // start = 10   start + (n-1) * digit
    // 10+(6-1)/2 = 38;

    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';

    }

    public static void main(String[] args) {
        剑指Offer44数字序列中某一位的数字 s=  new 剑指Offer44数字序列中某一位的数字();
        s.findNthDigit(15);
    }
}
