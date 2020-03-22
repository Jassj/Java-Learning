package leetcode.basicAlgorithm.sorting;

import java.util.Arrays;

/**
 * description:
 * 归并排序
 * 分解：分解待排序的n个元素称为个具有n/2个元素的序列
 * 解决：使用归并排序递归的排序两个序列, 当分解的子序列长度<=1时, 递归回升开始合并
 * 合并：将分别已由小到大排序的两个子序列进行合并
 *      a.依次比较两个子序列头部的较小值, 获取较小值
 *      b.重复a操作直至迭代完两个子序列
 * @author yuanjie 2020/03/21 21:48
 */
public class MergeSort {

    private static void mergeSort(int[] nums) {
        int start = 0, end = nums.length - 1;
        mergeSortByRecursive(nums, start, end);
    }

    private static void mergeSortByRecursive(int[] nums, int start, int end) {
        if(start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSortByRecursive(nums, start, mid);
        mergeSortByRecursive(nums, mid + 1, end);
        merger(nums, start, mid, end);
    }

    // 合并已由小到大排序的两个数组
    // start-->mid    mid+1-->end
    private static void merger(int[] nums, int start, int mid, int end) {
        int[] leftArr = Arrays.copyOfRange(nums, start, mid + 1); // 左闭右开, 因此右区间+1
        int[] rightArr = Arrays.copyOfRange(nums, mid + 1, end + 1);
        for(int k = start, i = 0, leftLen = leftArr.length, j = 0, rightLen = rightArr.length; k <= end; k++) {
            if(i >= leftLen) {
                nums[k] = rightArr[j++];
            } else if(j >= rightLen) {
                nums[k] = leftArr[i++];
            } else {
                nums[k] = leftArr[i] <= rightArr[j] ? leftArr[i++] : rightArr[j++];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 5, 1};
        mergeSort(nums);
        for(int num : nums) {
            System.out.print(num+"-->");
        }
    }

}
