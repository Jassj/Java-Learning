package leetcode.basicAlgorithm.sorting;

/**
 * description
 * 选择排序:
 * 1.多次迭代从待排序数组中选择最小值
 * 2.将每次获取的最小值按序放入数组头部
 * @author yuanjie 2020/03/22 16:56
 */
public class SelectionSort {

    private static void selectionSort(int[] nums) {
        for(int i = 0, len = nums.length; i < len; i++) {
            int min = nums[i];
            int minIndex = i;
            for(int j = i + 1; j < len; j++) {
                if(nums[j] < min) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            if(minIndex != i) { // 存在当前索引小的值则交换
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 5, 1};
        selectionSort(nums);
        for(int num : nums) {
            System.out.print(num+"-->");
        }
    }

}
