package leetcode.basicAlgorithm.sorting;

/**
 * description: 快速排序算法
 * 分治法进行快速排序:
 * 1.确定基准值，按照基准值分成左右两部分(只进行值比较)，左半部分全部小于等于最小值，右半部分全部大于基准值
 * 如何确定基准值：
 * 默认数组a起止索引为p、r，基准为q，定义索引变量i、j划分左右半区域
 * a[p]--a[i] <= a[r]
 * a[i+1]--a[j] > a[r]
 * (1).默认选取尾部值为基准，依次遍历数组
 * (2).当前值小于等于基准值时，归入左半区域，左半区间扩张
 * (3).当前值大于基准值时，归入右半区域，右半区间扩张
 * (4).循环结束后交换尾部值和右半区间的左边界值，将数组拆分为左右两部分
 * 2.递归对左右部分进行操作1, 基准值不参与后续递归操作
 * 3.直到操作1进行确认的数组长度为0或1时停止
 * @author yuanjie 2020/02/17 15:48
 */
public class QuickSort {

    public static void quickSort(int nums[]) {
        int len = nums.length;
        int start = 0, end = len -1;
        quickSortRecursive(nums, start, end);
    }

    // 递归进行快速排序
    private static void quickSortRecursive(int[] nums, int start, int end) {
        if(start >= end) {
            return;
        }
        int standard = getStandard(nums, start, end);
        quickSortRecursive(nums, start, standard - 1);
        quickSortRecursive(nums, standard + 1, end);
    }

    // 选取基准值，基准值大于等于左边区域全部值，小于右边区域全部值
    private static int getStandard(int[] nums, int start, int end) {
        int selectedVal = nums[end];
        int standard = start - 1;
        for(int j = start; j <= end - 1; j++) {
            if(nums[j] <= selectedVal) {
                standard = standard + 1;
                int temp = nums[j];
                nums[j] = nums[standard];
                nums[standard] = temp;
            }
        }
        // 循环结束后交换尾部值和右半区间的左边界值
        int temp = nums[end];
        nums[end] = nums[standard+1];
        nums[standard+1] = temp;
        return standard + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 7, 3, 5, 4};
        quickSort(nums);
        for(int num : nums) {
            System.out.print(num+"-->");
        }
    }
}
