package offer;

/**
 * @author zhangyong
 * Created on 2021-04-23
 */
public class 剑指Offer46把数字翻译成字符串 {
    //给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
    //一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
    //示例 1:
    //
    //输入: 12258
    //输出: 5
    //解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
    //

    /**
     * 类似小青蛙跳台阶
     * 组成的两位数字可以被翻译，则 dp[i] = dp[i - 1] + dp[i - 2]dp[i]=dp[i−1]+dp[i−2] ；否则 dp[i] = dp[i - 1]dp[i]=dp[i−1]
     * <p>
     * 112191  当到2时，可以跟11组成 112 也可以组成1`12`
     * index = 0; 1    1种   1
     * index = 1; 11   2种   11 和 `11`
     * index = 2; 112  2和前一个1可以组成子母。 3种   112   `11`2   1`12`
     * index = 3; 1121 1和前一个2可以组成子母  5种  1121  `11`21  1`12`1   11`21`   112`1`
     * index = 4; 11219 9和前一个1可以组成子母 8种  可以是index=3的5种补9  11219  `11`219 。。。  也可以是最后两位连起来 112`19` `11`2`19`  1`12``19`
     * index = 5; 112191 9和1不能组成，所以只能是在原有的基础上加 9
     * 可以看到规律了，当后两位能是25及其之内的就是 dp[i-1] + dp[i-2]的种类。否则就是 dp[i-1]的种类
     *
     * @param num
     * @return
     * @author zhangyong05
     * 2021/4/27 3:29 下午
     */
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int[] dp = new int[str.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            // 后两位是子母
            String tmp = str.substring(i - 2, i);
            if (tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[str.length()];
    }

    public static void main(String[] args) {
        剑指Offer46把数字翻译成字符串 s = new 剑指Offer46把数字翻译成字符串();
        System.out.println(s.translateNum(12258));
    }
}
