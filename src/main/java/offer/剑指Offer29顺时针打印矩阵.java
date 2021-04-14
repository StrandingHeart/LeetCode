package offer;

/**
 * @author zhangyong
 * Created on 2021-04-14
 */
public class 剑指Offer29顺时针打印矩阵 {

    //输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
    //示例 1：
    //输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
    //输出：[1,2,3,6,9,8,7,4,5]
    //示例 2：
    //输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
    //输出：[1,2,3,4,8,12,11,10,9,5,6,7]

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return new int[0];
        }
        int left = 0;
        int top = 0;
        int right = matrix[0].length-1;
        int bottom = matrix.length-1;
        int[] res = new int[(right+1)*(bottom+1)];
        int k =0;
        while (left <= right && top <= bottom ){
            // 从左到右
            for (int i = left; i <= right; i++) {
                res[k++] = matrix[top][i];
            }
            top++;
            // 从上到下
            for (int i = top; i <= bottom; i++) {
                res[k++] = matrix[i][right];
            }
            right--;
            // 从右到左
            for (int i = right; i >= left && bottom >= top; i--) {
                res[k++] = matrix[bottom][i];
            }
            bottom--;
            // 从下到上
            for (int i = bottom; i >= top && right >= left; i--) {
                res[k++] = matrix[i][left];
            }
            left++;
        }
        return res;
    }

    public boolean find(int[] arr,int target){
        int l = 0;
        int r = arr.length-1;
        while (l<=r){
            int mid = (l+r)/2;
            if (arr[mid] == target){
                return true;
            }else if (arr[mid] > target){
                r = mid-1;
            }else {
                l = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        剑指Offer29顺时针打印矩阵 s = new 剑指Offer29顺时针打印矩阵();
        System.out.println(s.find(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 7));
        // {1,2,3,4},
        // {5,6,7,8},
        // {9,10,11,12}
        int[] ints = s.spiralOrder(new int[][]{{1, 2, 3,4}, { 5, 6,7,8}, {9,10,11,12}});
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+",");
        }
    }
}
