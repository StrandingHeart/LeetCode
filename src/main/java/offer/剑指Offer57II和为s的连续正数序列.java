package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyong
 * Created on 2021-05-07
 */
public class 剑指Offer57II和为s的连续正数序列 {
    //输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
    //
    //序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
    //
    // 
    //
    //示例 1：
    //
    //输入：target = 9
    //输出：[[2,3,4],[4,5]]
    //

    public int[][] findContinuousSequence(int target) {
        int start = 1;
        int end = 2;
        int sum = 3;
        List<int[]> res = new ArrayList<>();
        while (start < end) {
            if (sum < target) {
                end++;
                sum += end;
            } else if (sum > target) {
                sum -= start;
                start++;
            } else {
                int[] arr = new int[end - start + 1];
                int j = 0;
                for (int i = start; i <= end; i++) {
                    arr[j] = i;
                    j++;
                }
                res.add(arr);
                end++;
                sum += end;
            }
        }
        return res.toArray(new int[0][]);
    }

}
