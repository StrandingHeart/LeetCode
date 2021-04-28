package offer;

/**
 * @author zhangyong
 * Created on 2021-04-25
 */
public class 剑指Offer49丑数 {

    //我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
    //
    // 
    //
    //示例:
    //
    //输入: n = 10
    //输出: 12
    //解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
    // 1,2,3,4,5,6,8,9,10,
    // 12,15,16,18,20,
    // 24,25,27,30;
    // 36,40;
    // 45,48,50;
    //说明:  
    //
    //1 是丑数。
    //n 不超过1690。
    //

    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int a = 0;
        int b = 0;
        int c = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = 2 * dp[a];
            int n3 = 3 * dp[b];
            int n5 = 5 * dp[c];
            dp[i] = Math.min(Math.min(n2,n3),n5);
            if (dp[i] == n2){
                a++;
            }
            if (dp[i] == n3){
                b++;
            }
            if (dp[i] == n5){
                c++;
            }
        }
        return dp[n-1];

    }
}
