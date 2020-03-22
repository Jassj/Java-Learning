package leetcode.basicAlgorithm.sorting;

/**
 * description
 * 堆排序
 * 1.堆的定义
 *   a.堆可以被看做一个近似的完全二叉树的数组对象, 堆中的元素由全部或部分数组构成
 *   b.数组A的堆结构：0 <= A.heap <= A.length
 *   c.A[1](实际位置)为当做根节点, 且对于所有的A[i]都有
 *      父节点 = A[i / 2]
 *      左节点 = A[i * 2]
 *      右节点 = A[i * 2 + 1]
 * 2.建堆
 *   a.建立最小堆: A[PARENT(i)] <= A[i]
 *   b.建立最大堆: A[PARENT(i)] >= A[i]
 * 3.排序
 * @author yuanjie 2020/03/22 15:03
 */
public class HeapSort {

    private static void heapSort(int[] nums) {
        // 先建堆再排序
        buildMaxHeap(nums);
        // 排序由小到大的顺序排序, 因此依次从尾到头取最大堆中的根节点, 取完后缩减堆并将新的根节点下沉以构造新的最大堆
        for(int len = nums.length, i = len - 1; i >= 1; i--) {
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            maxHeapIFY(nums, i, 1);
        }
    }

    /**
     * 建立最大堆
     * 前提条件: 数组A[1..n]的子数组A[(n/2+1)...n]都可以被当做叶节点
     * 迭代: 依次将数组A[n/2...1]的值与其左右节点比较, 与左右节点中的最大值交换
     * 递归：此节点下沉并递归进行操作
     */
    private static void buildMaxHeap(int[] nums) {
        for(int len = nums.length, i = len / 2; i >= 1; i--) {
            maxHeapIFY(nums, len, i);
        }
    }

    private static void maxHeapIFY(int[] nums, int heapSize, int curPosition) {
        // 找出左右节点中的最大值
        int curIndex = curPosition - 1; // 索引 = 实际位置(从1计算) - 1
        int maxIndex = curIndex;
        if((curPosition << 1) <= heapSize && nums[(curPosition << 1) - 1] > nums[curIndex]) {
            maxIndex = (curPosition << 1) - 1;
        }
        if((curPosition << 1) + 1  <= heapSize && nums[curPosition << 1]  > nums[maxIndex]) {
            maxIndex = curPosition << 1;
        }
        // 如果比根节点大, 则进行交换
        if(nums[maxIndex] > nums[curIndex]) {
            int temp = nums[curIndex];
            nums[curIndex] = nums[maxIndex];
            nums[maxIndex] = temp;
            maxHeapIFY(nums, heapSize, maxIndex + 1); // 此节点下沉并递归进行操作
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        heapSort(nums);
        for(int num : nums) {
            System.out.print(num+"-->");
        }
    }

}
