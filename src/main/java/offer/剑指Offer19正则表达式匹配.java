package offer;

/**
 * @Author zhangyong
 * @Date 2021/5/29 11:12
 */
public class 剑指Offer19正则表达式匹配 {

    //请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
    //在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
    //
    //示例 1:
    //
    //输入:
    //s = "aa"
    //p = "a"
    //输出: false
    //解释: "a" 无法匹配 "aa" 整个字符串。
    //示例 2:
    //
    //输入:
    //s = "aa"
    //p = "a*"
    //输出: true
    //解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
    //

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j==0){
                    // 边界
                    dp[i][j] = i==0;
                }else {
                    if (p.charAt(j-1) != '*'){
                        if (i>0 && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.')){
                            dp[i][j] = dp[i-1][j-1];
                        }
                    }else {
                        //x*的情况，如果 s中没有x字符，那么模式串直接去掉俩。
                        if (j>=2){
                            dp[i][j] |= dp[i][j-2];
                        }
                        //s中 存在x时，每次s串挪一个。
                        if (j>1&&i>0&&(s.charAt(i-1) == p.charAt(j-2)|| p.charAt(j-2) == '.')){
                            dp[i][j] |= dp[i-1][j];
                        }
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        剑指Offer19正则表达式匹配 s = new 剑指Offer19正则表达式匹配();
        System.out.println(s.isMatch("aa", "a*"));
    }
}
