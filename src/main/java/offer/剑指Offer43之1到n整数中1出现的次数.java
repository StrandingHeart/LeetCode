package offer;

/**
 * @author zhangyong
 * Created on 2021-04-21
 */
public class 剑指Offer43之1到n整数中1出现的次数 {
    //输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
    //例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
    //示例 1：
    //
    //输入：n = 12
    //输出：5
    //示例 2：
    //
    //输入：n = 13
    //输出：6
    public int countDigitOne1(int n) {
        int i = 0;
        for (int j = 1; j <= n; j++) {
            int tmp = j;
            while (tmp != 0) {
                if ((tmp % 10) == 1) {
                    i++;
                }
                tmp = tmp / 10;
            }
        }
        return i;
    }

    public int countDigitOne(int n) {
        int res = 0;
        // 低位，当前位后面的
        int low = 0;
        // 高位，当前位前面的
        int high = n / 10;
        // 当前位
        int cur = n % 10;
        // 当前位的位级  个位十位百位...
        int i = 1;
        while (high != 0 || cur != 0) {
            // cur 不同值有不同的公式
            // cur = 0  high * i
            // cur = 1  high * i + low + 1
            // cur > 1  high * i + i
            if (cur == 0) {
                res += high * i;
            } else if (cur == 1) {
                res += high * i + low + 1;
            } else {
                res += high * i + i;
            }
            i *= 10;
            cur = high % 10;
            low = n % i;
            high /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        剑指Offer43之1到n整数中1出现的次数 s = new 剑指Offer43之1到n整数中1出现的次数();
        int i = s.countDigitOne(13);
        System.out.println(i);
    }
}
