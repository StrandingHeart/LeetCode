package offer;

import java.util.Arrays;

/**
 * @author zhangyong
 * Created on 2021-05-13
 */
public class 剑指Offer60n个骰子的点数 {
    //把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
    //
    // 
    //
    //你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
    //
    // 
    //
    //示例 1:
    //
    //输入: 1
    //输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]

    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp,1.0/6.0);
        // 遍历筛子
        for (int i = 2; i <= n; i++) {
            // 每一轮能有多少个和
            double[] tmp = new double[5*i+1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[k+j] += dp[j] /6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }

    public static void main(String[] args) {
        剑指Offer60n个骰子的点数 s= new 剑指Offer60n个骰子的点数();
        double[] doubles = s.dicesProbability(2);
        for (int i = 0; i < doubles.length; i++) {
            System.out.println(doubles[i]);
        }
    }
}
