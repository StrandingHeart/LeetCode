package offer;

/**
 * @author zhangyong
 * Created on 2021-03-23
 */
public class 剑指Offer05替换空格 {
    //请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
    //示例 1：
    //输入：s = "We are happy."
    //输出："We%20are%20happy."
    //0 <= s 的长度 <= 10000

    /**
     * 遍历一遍。把空格替换就行了
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' '){
                sb.append("%20");
            }else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
