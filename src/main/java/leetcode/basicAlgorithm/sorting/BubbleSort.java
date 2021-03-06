package leetcode.basicAlgorithm.sorting;

/**
 * description:
 * 迭代进行冒泡排序
 * 时间复杂度O(n^2): 数组大小为n, 迭代次数为: (n-1)+(n-2)+...+1 = n(n-1)/2
 * 空间复杂度O(1): 仅用于进行数据交换
 * 1.设置起点为索引0, 终点为索引n-1至0, 对起止点划分的所有子区间依次进行操作2
 * 2.迭代比较相邻数, 若前数>后数则交换位置, 每次迭代将获取当前子区间最大值移到区间终点
 * 优化点: 增加计数器, 记录交换次数, 如果存在某次迭代结束后未发生交换的情况, 则代表数组已升序排序, 即可终止。
 * 注: 优化后最优情况下仅需一次迭代(数组本身就是升序排序)就可完成, 时间复杂度为O(n)
 * @author yuanjie 2020/03/20 17:19
 */
public class BubbleSort {

    private static void bubbleSort(int[] nums) {
        for(int i = 1, len = nums.length; i <= len - 1; i++) {
            int swapCount = 0;
            for(int j = 0; j <= len - i - 1; j++) {
                if(nums[j+1] < nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    swapCount++;
                }
            }
            if(swapCount == 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 5, 1};
        bubbleSort(nums);
        for(int num : nums) {
            System.out.print(num+"-->");
        }
    }

}
