package offer;

/**
 * @author zhangyong
 * Created on 2021-04-09
 */
public class 剑指Offer14I剪绳子 {

    //给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
    //
    //示例 1：
    //
    //输入: 2
    //输出: 1
    //解释: 2 = 1 + 1, 1 × 1 = 1
    //示例 2:
    //
    //输入: 10
    //输出: 36
    //解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
    //提示：
    //
    //2 <= n <= 58

    //切的3越多越好，剩下的值为4就切成2*2 否则就按3切。
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int count = 0;
        while (n > 4) {
            n = n - 3;
            count++;
        }
        double pow = Math.pow(3, count);
        return (int) pow*n;
    }

    public static void main(String[] args) {
        剑指Offer14I剪绳子 s = new 剑指Offer14I剪绳子();
        System.out.println(s.cuttingRope(10));
    }
}
