package offer;

/**
 * @author zhangyong
 * Created on 2021-05-17
 */
public class 剑指Offer51数组中的逆序对 {
    //在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
    //
    // 
    //
    //示例 1:
    //
    //输入: [7,5,6,4]
    //输出: 5
    //限制：
    //
    //0 <= 数组长度 <= 50000
    //
    int count = 0;
    public int reversePairs(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return count;
    }

    public void mergeSort(int[] nums,int l,int r){
        if (l>=r){
            return;
        }
        int mid = (r+l)/2;
        mergeSort(nums,l,mid);
        mergeSort(nums,mid+1,r);
        merge(nums,l,mid,r);
    }
    public void merge1(int[] nums,int l,int mid,int r){
        int left = l;
        int middle = mid+1;
        // arr设置为num的长度就超时  好气
        int[] arr = new int[nums.length];
        int index = l;
        while (left <= mid && middle <=r){
            if (nums[left] <= nums[middle]){
                arr[index++] = nums[left++];
            }else {
                // 左边大于右边
                arr[index++] = nums[middle++];
                count += mid - left+1;
            }
        }
        while (left<=mid){
            arr[index++] = nums[left++];
        }
        while (middle<=r){
            arr[index++] = nums[middle++];
        }
        while (l<=r){
            nums[l] = arr[l++];
        }
    }
    public void merge(int[] nums,int l,int mid,int r){
        int left = l;
        int middle = mid+1;
        int[] arr = new int[r-l+1];
        int index = 0;
        while (left <= mid && middle <=r){
            if (nums[left] <= nums[middle]){
                arr[index++] = nums[left++];
            }else {
                // 左边大于右边
                arr[index++] = nums[middle++];
                // 下面这个值就是左边部分从当前元素到左边部分的尾有几个元素
                count += mid - left+1;
            }
        }
        while (left<=mid){
            arr[index++] = nums[left++];
        }
        while (middle<=r){
            arr[index++] = nums[middle++];
        }
        for (int i = 0; i <= r-l; i++) {
            nums[l+i] = arr[i];
        }
    }

    public static void main(String[] args) {
        剑指Offer51数组中的逆序对 s = new 剑指Offer51数组中的逆序对();
        int arr = s.reversePairs(new int[]{7, 5, 6, 4});
        System.out.println(arr);
    }
}
