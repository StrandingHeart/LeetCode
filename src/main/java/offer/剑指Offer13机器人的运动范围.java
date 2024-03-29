package offer;

/**
 * @author zhangyong
 * Created on 2021-04-08
 */
public class 剑指Offer13机器人的运动范围 {
    //地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
    //输入：m = 2, n = 3, k = 1
    //输出：3
    //示例 2：
    //
    //输入：m = 3, n = 1, k = 0
    //输出：1
    // 16 8 4   25  ===> 15
    int m,n,k;
    boolean[][] visit;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        visit = new boolean[m][n];
        return dfs(0,0,0,0);
    }

    private int dfs(int i,int j,int mSum,int nSum){
        if (i >= m || j >= n || k < mSum + nSum || visit[i][j]){
            return 0;
        }
        visit[i][j] = true;
        return 1 + dfs(i+1,j,getCount(i+1),nSum) + dfs(i,j+1,mSum,getCount(j+1));
    }

    private int getCount(int i) {
        int res = 0;
        while (i > 0) {
            res += i % 10;
            i = i / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        剑指Offer13机器人的运动范围 s = new 剑指Offer13机器人的运动范围();
        int count = s.getCount(0);
        System.out.println(count);

        System.out.println(s.movingCount(16, 8, 4));
    }

}
