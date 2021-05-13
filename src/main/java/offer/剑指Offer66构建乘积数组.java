package offer;

/**
 * @author zhangyong
 * Created on 2021-05-12
 */
public class 剑指Offer66构建乘积数组 {
    //给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
    // 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
    //
    // 
    //
    //示例:
    //
    //输入: [1,2,3,4,5]
    //输出: [120,60,40,30,24]
    // 
    //
    //提示：
    //
    //所有元素乘积之和不会溢出 32 位整数
    //a.length <= 100000
    //

    /**
     * 求非0的和
     * 判断有几个0，然后做出对应处理
     * @param a
     * @return
     */
    public int[] constructArr(int[] a) {
        int sum = 1;
        int zero = 0;
        for (int i : a) {
            if (i == 0){
                zero++;
                continue;
            }
            sum *= i;
        }
        int[] arr = new int[a.length];
        for (int i = 0; i < arr.length; i++) {
            if (a[i]==0){
                if (zero > 1){
                    arr[i] = 0;
                }else {
                    arr[i] = sum;
                }
            }else {
                if (zero >= 1){
                    arr[i] = 0;
                }else {
                    arr[i] = sum/a[i];
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        剑指Offer66构建乘积数组 s = new 剑指Offer66构建乘积数组();
        int[] arr = s.constructArr(new int[]{1, 2, 3, 4, 5});
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
