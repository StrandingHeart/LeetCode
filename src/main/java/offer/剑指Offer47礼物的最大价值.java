package offer;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangyong
 * Created on 2021-04-23
 */
public class 剑指Offer47礼物的最大价值 {

    //在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
    //
    // 
    //
    //示例 1:
    //
    //输入:
    //[
    //[1,3,1],
    //[1,5,1],
    //[4,2,1]
    //]
    //输出: 12
    //解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
    int max = 0;
    public int maxValue(int[][] grid) {
        dfs(grid,0,0,0);
        return max;
    }

    /**
     * 超时
     * @return
     * @author zhangyong05
     * 2021/4/28 2:52 下午
     */
    public void dfs(int[][] grid,int i,int j,int val){
        if (i >= grid.length-1 && j >= grid[0].length-1){
            val += grid[i][j];
            max = Math.max(val,max);
            return;
        }
        if (i > grid.length-1 || j > grid[0].length-1){
            return;
        }
        val += grid[i][j];
        dfs(grid,i+1,j,val);
        dfs(grid,i,j+1,val);
    }

    public int test(int[][] grid){
        int row = grid.length;
        int column = grid[0].length;
        //dp[i][j]表示从grid[0][0]到grid[i - 1][j - 1]时的最大价值
        int[][] dp = new int[row + 1][column + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[row][column];
    }

    public static void main(String[] args) {
        剑指Offer47礼物的最大价值 s = new 剑指Offer47礼物的最大价值();
        int[][] grid = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}};
        int i = s.maxValue(grid);
        System.out.println(i);
        int test = s.test(grid);
    }
}
