package leetcode.basicAlgorithm.sorting;

/**
 * description
 * 快速排序：
 * 时间复杂度O(n^2): 数组大小为n,则迭代次数为: 1+2+...+n-1 = n(n-1)/2
 * 空间复杂度O(1): 仅用于进行数据交换
 * 1.初始从第二个元素进行迭代至最后一个元素
 * 2.每次将当前元素与排序好的元素进行从后往前的比较
 *   ①.若当前元素小于已排序元素, 则以排序元素右移为了留出插入空位
 * 注: 优情况下仅需一次迭代(数组本身就是升序排序)就可完成, 时间复杂度为O(n)
 * @author yuanjie 2020/03/21 17:15
 */
public class InsertSort {

    private static void insertSort(int[] nums) {
        for(int i = 1, len = nums.length; i < len; i++) {
            int key = nums[i];
            int j = i - 1;
            while(j >= 0 && nums[j] > key) {
                nums[j+1] = nums[j];
                j = j - 1;
            }
            nums[j+1] = key;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 5, 1};
        insertSort(nums);
        for(int num : nums) {
            System.out.print(num+"-->");
        }
    }

}
