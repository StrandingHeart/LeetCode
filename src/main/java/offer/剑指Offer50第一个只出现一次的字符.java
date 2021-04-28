package offer;

import java.util.*;

/**
 * @author zhangyong
 * Created on 2021-04-23
 */
public class 剑指Offer50第一个只出现一次的字符 {
    //在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
    //
    //示例:
    //
    //s = "abaccdeff"
    //返回 "b"
    //
    //s = ""
    //返回 " "

    public char firstUniqChar(String s) {
        if (s.length() == 0){
            return ' ';
        }
        // a 按顺序放,重复就删除，将删除的记录到b
        List<Character> a = new ArrayList<>();
        // b 放删除过的重复元素
        Set<Character> b = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            Character tmp = s.charAt(i);
            if (a.contains(tmp)){
                a.remove(tmp);
                b.add(tmp);
            }else {
                if (!b.contains(tmp)){
                    a.add(tmp);
                }
            }
        }
        if (a.size() > 0){
            return a.get(0);
        }
        return ' ';
    }

    public static void main(String[] args) {
        剑指Offer50第一个只出现一次的字符 s = new 剑指Offer50第一个只出现一次的字符();
        System.out.println(s.firstUniqChar("abaccdeff"));
        System.out.println(s.firstUniqChar("hfhfhw"));
    }
}
