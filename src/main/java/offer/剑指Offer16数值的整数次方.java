package offer;

/**
 * @author zhangyong
 * Created on 2021-04-12
 */
public class 剑指Offer16数值的整数次方 {
    //实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
    //输入：x = 2.00000, n = 10
    //输出：1024.00000
    //示例 2：
    //
    //输入：x = 2.10000, n = 3
    //输出：9.26100
    //示例 3：
    //
    //输入：x = 2.00000, n = -2
    //输出：0.25000
    //解释：2-2 = 1/22 = 1/4 = 0.25

    //快速幂算法

    /**
     * 快速幂https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/jian-dan-li-jie-kuai-su-mi-by-ollieq-rl74/
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        long nTmp = n;
        if (n<0){
            nTmp = -nTmp;
            x = 1/x;
        }
        double res = 1.0;
        while (nTmp>0){
            //如果最后一位是1就乘上
            if ((nTmp&1)==1){
                res *=x;
            }
            // 取二进制的值
            x *=x;
            nTmp >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        剑指Offer16数值的整数次方 s = new 剑指Offer16数值的整数次方();
        System.out.println(s.myPow(2.1, 3));
    }
}
