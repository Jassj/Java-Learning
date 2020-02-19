package leetcode;

import leetcode.demo.sortingAlgorithm.QuickSort;

import java.util.HashMap;
import java.util.Map;

/**
 * description:
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * @author yuanjie 2020/02/17 13:37
 */
public class MajorityElement {

    private static int majorityElement(int[] nums) {
//        return majorityElementByHashMap(nums);
//        return majorityElementByOrderedArray(nums);
//        return majorityElementByRandomNum(nums);
//        return majorityElementByRandomNumByVote(nums);
        return majorityElementByDAC(nums, 0, nums.length - 1);
    }


    /**
     * 分治法
     * 分解：将数组拆分为左右两半区间
     * 解决：通过递归数组将会被分解成单个元素，其本身即为众数，递归结束
     * 合并：将左右区间众数合并时，如果众数相同则返回，众数不同则比较两数左右区间的出现频率，确定众数
     */
    private static int majorityElementByDAC(int[] nums, int left, int right) {
        if(left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;
        int leftMode = majorityElementByDAC(nums, left, mid);
        int rightMode = majorityElementByDAC(nums, mid + 1, right);
        if(leftMode == rightMode) {
            return leftMode;
        }

        return calculateMode(nums, left, right, leftMode, rightMode);
    }

    // 计算左右区间的真正众数
    private static int calculateMode(int[] nums, int left, int right, int leftMode, int rightMode) {
        int countLeft = 0, countRight = 0;
        for(int i = left; i <= right; i++) {
            if(nums[i] == leftMode) {
                countLeft++;
            }
            if(nums[i] == rightMode) {
                countRight++;
            }
        }

        return countLeft > countRight ? leftMode : rightMode;
    }

    /**
     * Boyer-Moore投票算法:
     * ①.初始化计数器为0，遍历数组。当计数器为0时，选择当前数为默认众数
     * ②.当数字为众数时+1，非众数时-1
     * [7, 7, 5, 7, 5, 1 | 5, 7 | 5, 5, 7, 7 | 7, 7, 7, 7]
     * 实现原理：众数总是占比超过一半，因此遍历过程中计数器重新归零时代表相同数量的众数与非众数被抵消
     * 因此，剩余的数组众数仍不变，经历N次抵消过程后，即可得到期望众数。
     * 时间复杂符 0(n)
     * 空间复杂度 0(1)：仅需定义计数器和期望众数
     */
    private static int majorityElementByRandomNumByVote(int[] nums) {
        int exceptMode = 0; //默认众数
        int count = 0; //计数器初始化为0
        for(int num : nums) {
            if(count == 0) {
                exceptMode = num;
            }

            count += (num == exceptMode) ? 1 : -1;
        }

        return exceptMode;
    }

    // 不按序遍历整个数组，而是随机选取数组元素进行判断，因为众数大于n/2，选择成功的概率较高
    private static int majorityElementByRandomNum(int[] nums) {
        int len = nums.length;
        while(true) {
            int index = (int)Math.round(Math.random()*(len-1));
            int count = 0;
            for(int num : nums) {
                if(num == nums[index]) {
                    count++;
                }
            }
            if(count > len/2) {
                return nums[index];
            }
        }
    }

    /**
     * 先将数组升序排序，然后依次遍历，判断第i与i+len/2的数字是否相同<==>多数元素
     * ①.优化点：遍历时如果当前元素与前序元素相同且都不符合多数元素时，可跳过
     * ②.问题点：样本太大导致排序算法时间开销较大
     * 时间复杂符 遍历0(n^2)-O(nlogn) 选择不同的排序算法时间复杂度不同：以下选择快速排序算法
     * 空间复杂度 0(1)
     */
    private static int majorityElementByOrderedArray(int[] nums) {
        QuickSort.quickSort(nums);
//        Arrays.sort(nums); 可调用Arrays工具类的快速排序算法
        return nums[nums.length/2]; // 题目给出总是存在众数, 因此直接返回
    }

    /**
     * 使用哈希表进行存储，无当前元素时初始化，存在当前元素时更新个数，当元素个数大于n/2时，即为所求值
     * 时间复杂符 0(n)
     * 空间复杂度 0(n)
     */
    private static int majorityElementByHashMap(int[] nums) {
        int len = nums.length;
        if(len == 0) {
            throw new RuntimeException("The dimension of array can not be empty");
        }
        if(len == 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(map.containsKey(num)) {
                int curCount = map.get(num);
                if(curCount+1 > len/2) {
                    return num;
                } else {
                    map.put(num, curCount+1);
                }
            } else {
                map.put(num, 1);
            }
        }
        throw new RuntimeException("There is no majority element in this array");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 2};
        System.out.println(majorityElement(nums));
    }
}
