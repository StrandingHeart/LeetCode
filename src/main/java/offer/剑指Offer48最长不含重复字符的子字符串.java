package offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhangyong
 * Created on 2021-04-25
 */
public class 剑指Offer48最长不含重复字符的子字符串 {
    //请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
    //
    // 
    //
    //示例 1:
    //
    //输入: "abcabcbb"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    //示例 2:
    //
    //输入: "bbbbb"
    //输出: 1
    //解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
    //示例 3:
    //
    //输入: "pwwkew"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
    //     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
    //

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int i = -1;
        Map<Character,Integer> map = new HashMap<>();
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))){
                // 左指针移动，最大值，防止往回走
                i = Math.max(map.get(s.charAt(j)),i);
            }
            map.put(s.charAt(j),j);
            res = Math.max(res,j-i);
        }
        return res;
    }

    public static void main(String[] args) {
        剑指Offer48最长不含重复字符的子字符串 s = new 剑指Offer48最长不含重复字符的子字符串();
//        System.out.println(s.lengthOfLongestSubstring("pwwkew"));
//        System.out.println(s.lengthOfLongestSubstring("bbbbb"));
//        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(s.lengthOfLongestSubstring("a"));
//        System.out.println(s.lengthOfLongestSubstring("ab"));
//        System.out.println(s.lengthOfLongestSubstring(" "));
        System.out.println(s.lengthOfLongestSubstring("aab"));
    }
}
