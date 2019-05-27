
import java.util.Arrays;

/**
 * 相对比较容易理解的快排代码
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {9,9,8,8,7,7,6,6,5,5,4,4,3,3,2,2,1,1};
        System.out.println(Arrays.toString(a));
        quickSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] a) {
        if(a.length>0) {
            quickSort(a, 0 , a.length-1);
        }
    }

    /**
     * 快排算法
     * @param a 未排序的数组
     * @param low 本次需要排序的最小下标
     * @param high 本次需要排序的最大下标
     */
    private static void quickSort(int[] a, int low, int high) {
        //1,找到递归算法的出口
        if( low >= high) {
            return;
        }
        // 存
        int i = low;
        int j = high;
        //key（基准数）
        int key = a[ low ];
        //完成一趟排序
        while( i< j) {
            //从右往左找到第一个小于key的数
            while(i<j && a[j] > key){
                j--;
            }
            //从左往右找到第一个大于key的数
            while( i<j && a[i] <= key) {
                i++;
            }
            //交换
            if(i<j) {
                int p = a[i];
                a[i] = a[j];
                a[j] = p;
            }
        }
        // 将基准数交换至中间
        int p = a[i];
        a[i] = a[low];
        a[low] = p;
        //5, 对基准数左边的数快排
        quickSort(a, low, i-1 );
        //6, 对key（基准数）右边的数快排
        quickSort(a, i+1, high);
    }
}
 
 
 
 
 