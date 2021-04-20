package offer;

import java.util.*;

/**
 * @author zhangyong
 * Created on 2021-04-15
 */
public class 剑指Offer38字符串的排列 {

    //输入一个字符串，打印出该字符串中字符的所有排列。
    //你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
    //输入：s = "abc"
    //输出：["abc","acb","bac","bca","cab","cba"]

    private Set<String> resList = new HashSet<>();

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        find(chars, 0);
        return resList.toArray(new String[]{});
    }

    //https://blog.csdn.net/u013309870/article/details/68941284
    public void find(char[] chars, int start) {
        if (start == chars.length - 1) {
            resList.add(String.valueOf(chars));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = start; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                continue;
            }
            set.add(chars[i]);
            Swap(chars, i, start);
            find(chars, start + 1);
            Swap(chars, i, start);
        }
    }

    public void Swap(char chs[], int i, int j) {
        char temp;
        temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }

    public static void main(String[] args) {
        剑指Offer38字符串的排列 s = new 剑指Offer38字符串的排列();
        String[] abcs = s.permutation("abb");
        for (int i = 0; i < abcs.length; i++) {
            System.out.println(abcs[i]);
        }

    }
}
