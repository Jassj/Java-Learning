package leetcode.basicAlgorithm.sorting;

/**
 * description:
 * 迭代进行冒泡排序
 * 1.
 * @author yuanjie 2020/03/20 17:19
 */
public class BubbleSort {

    private static void bubbleSort(int[] nums) {
        for(int i = 0, len = nums.length; i < len - 1; i++) {
            for(int j = i; j < len - 1; j++) {
                if(nums[j+1] < nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 7, 3, 5, 4};
        bubbleSort(nums);
        for(int num : nums) {
            System.out.print(num+"-->");
        }
    }

}
