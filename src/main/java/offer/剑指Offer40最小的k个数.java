package offer;

import java.util.Arrays;

/**
 * @author zhangyong
 * Created on 2021-04-19
 */
public class 剑指Offer40最小的k个数 {

    //输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
    //
    // 
    //
    //示例 1：
    //
    //输入：arr = [3,2,1], k = 2
    //输出：[1,2] 或者 [2,1]
    //示例 2：
    //
    //输入：arr = [0,1,2,1], k = 1
    //输出：[0]
    //

    public int[] getLeastNumbers(int[] arr, int k) {
        fastSort(arr,0,arr.length-1,k);
        return Arrays.copyOfRange(arr,0,k);
    }

    public int fastSort(int[] arr,int left,int right,int k){
        if (left >=right){
            return -1;
        }
        int index = part(arr,left,right);
        if (index == k-1){
            return arr[index];
        }else if (index > k-1){
            // 排序左边
            return fastSort(arr,left,index-1,k);
        }else {
            // 排序右边
            return fastSort(arr,index+1,right,k);
        }
    }


    public int part(int[] arr,int left,int right){
        int var = arr[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j]<var){
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
            }
        }
        // 交换 arr[right] 到中间，让左边的都小于arr[i],右边的都大于
        int tmp = arr[right];
        arr[right] = arr[i];
        arr[i] = tmp;
        return i;
    }

    public static void main(String[] args) {
        剑指Offer40最小的k个数 s = new 剑指Offer40最小的k个数();
        int[] arr= new int[]{4,5,1,6,2,7,3,8};
        int[] leastNumbers = s.getLeastNumbers(arr, 4);
        for (int i : leastNumbers) {
            System.out.println(i);
        }
    }
}
