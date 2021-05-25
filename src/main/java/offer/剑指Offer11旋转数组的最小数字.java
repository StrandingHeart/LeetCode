package offer;

/**
 * @author zhangyong
 * Created on 2021-05-25
 */
public class 剑指Offer11旋转数组的最小数字 {

    //把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
    // 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
    //
    //示例 1：
    //
    //输入：[3,4,5,1,2]
    //输出：1
    //示例 2：
    //
    //输入：[2,2,2,0,1]
    //输出：0
    //

    public int minArray(int[] numbers) {
        if (numbers.length == 0){
            return 0;
        }
        int l = 0;
        int r = numbers.length-1;
        while (l<r){
            int mid = (l+r)/2;
            if (numbers[r] > numbers[mid]){
                r = mid;
            }else if (numbers[r] < numbers[mid]){
                l = mid+1;
            }else {
                r--;
            }
        }
        return numbers[l];
    }

    public static void main(String[] args) {
        剑指Offer11旋转数组的最小数字 s = new 剑指Offer11旋转数组的最小数字();
        System.out.println(s.minArray(new int[]{2,2,2,0,1}));
        System.out.println(s.minArray(new int[]{3,4,5,1,2}));
    }
}
