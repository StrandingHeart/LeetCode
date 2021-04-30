package offer;

/**
 * @author zhangyong
 * Created on 2021-04-30
 */
public class 剑指Offer53I在排序数组中查找数字I {

    //统计一个数字在排序数组中出现的次数。
    //
    // 
    //
    //示例 1:
    //
    //输入: nums = [5,7,7,8,8,10], target = 8
    //输出: 2
    //示例 2:
    //
    //输入: nums = [5,7,7,8,8,10], target = 6
    //输出: 0
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int count = 0;
        while (left<=right){
            int mid = (left+right)/2;
            if (nums[mid] == target){
                for (int i = mid; i <= right; i++) {
                    if (nums[i] == target){
                        count++;
                    }
                }
                for (int i = left; i < mid; i++) {
                    if (nums[i] == target){
                        count++;
                    }
                }
                break;
            }else if (nums[mid] > target){
                right = mid-1;
            }else if (nums[mid] < target){
                left = mid+1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        剑指Offer53I在排序数组中查找数字I s = new 剑指Offer53I在排序数组中查找数字I();
        int[] arr = new int[]{5,7,7,8,8,10};
        System.out.println(s.search(arr, 1));
        System.out.println(s.search(arr, 5));
        System.out.println(s.search(arr, 6));
        System.out.println(s.search(arr, 7));
        System.out.println(s.search(arr, 8));
        System.out.println(s.search(arr, 10));
    }
}
