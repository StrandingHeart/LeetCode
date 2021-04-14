package offer;

/**
 * @author zhangyong
 * Created on 2021-04-12
 */
public class 剑指Offer17打印从1到最大的n位数 {
    //输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
    //
    //示例 1:
    //
    //输入: n = 1
    //输出: [1,2,3,4,5,6,7,8,9]
    // 
    //
    //说明：
    //
    //用返回一个整数列表来代替打印
    //n 为正整数

    public int[] printNumbers(int n) {
        long tmp = 1;
        for (int i = 0; i < n; i++) {
            tmp *= 10;
        }
        tmp--;
        int[] arr = new int[(int)tmp];
        for (long i = tmp-1; i >= 0; i--) {
            arr[(int) i] = (int) tmp;
            tmp--;
        }
        return arr;
    }

    public static void main(String[] args) {
        剑指Offer17打印从1到最大的n位数 s = new 剑指Offer17打印从1到最大的n位数();
        System.out.println(s.printNumbers(2));
    }
}
