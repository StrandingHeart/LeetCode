package offer;

import java.util.Arrays;

/**
 * @author zhangyong
 * Created on 2021-04-12
 */
public class 剑指Offer20表示数值的字符串 {
    //请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
    // 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
    // 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
    //
    // 
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    // https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/solution/javaban-ben-ti-jie-luo-ji-qing-xi-by-yangshyu6/
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0){
            return false;
        }
        char[] chars = s.trim().toCharArray();
        boolean isNum = false;
        boolean isDot = false;
        boolean isEe = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                isNum = true;
            } else if (chars[i] == '.') {
                //.之前不能出现.或者e
                if (isDot || isEe) {
                    return false;
                }
                isDot = true;
            } else if (chars[i] == 'e' || chars[i] == 'E') {
                //e之前不能出现e，必须出现数
                if (isEe || !isNum) {
                    return false;
                }
                //重置isNum，排除123e或者123e+的情况,确保e之后也出现数
                isNum = false;
                isEe = true;
            } else if (chars[i] == '+' || chars[i] == '-') {
                //+-出现在0位置或者e/E的后面第一个位置才是合法的
                if (i != 0 && chars[i - 1] != 'e' && chars[i - 1] != 'E') {
                    return false;
                }
            } else {
                //其他不合法字符
                return false;
            }
        }
        return isNum;
    }

    public static void main(String[] args) {
        剑指Offer20表示数值的字符串 s = new 剑指Offer20表示数值的字符串();
        // 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
        // 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
//        System.out.println(s.isNumber("+100"));
//        System.out.println(s.isNumber("5e2"));
//        System.out.println(s.isNumber("-123"));
//        System.out.println(s.isNumber("3.1416"));
//        System.out.println(s.isNumber("1.2.3"));
//        System.out.println(s.isNumber("1a3.14"));
//        System.out.println(s.isNumber("12e"));
//        System.out.println(s.isNumber("+-5"));
//        System.out.println(s.isNumber("12e+5.4"));
        System.out.println(s.isNumber("-1E-16"));
    }
}
