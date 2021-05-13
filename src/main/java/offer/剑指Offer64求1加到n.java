package offer;

/**
 * @author zhangyong
 * Created on 2021-05-12
 */
public class 剑指Offer64求1加到n {
    //求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
    //示例 1：
    //输入: n = 3
    //输出: 6
    //示例 2：
    //
    //输入: n = 9
    //输出: 45
    // 
    //1 <= n<= 10000
    //
    int res = 0;

    public int sumNums(int n) {
        // && 短路，就不会执行后面了
        boolean x = (n > 1) && (sumNums(n - 1) > 0);
        res += n;
        return res;
    }

    public static void main(String[] args) {
        剑指Offer64求1加到n s = new 剑指Offer64求1加到n();
        System.out.println(s.sumNums(9));
    }
}
