package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * description
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author yuanjie 2020/04/26 15:22
 */
public class TwoSum {


    private static int[] twoSum(int[] nums, int target) {
//        return twoSumByIteration(nums, target);
        return twoSumByHashMap(nums, target);
    }

    // 使用HashMap存储已遍历的元素, 键(元素)值(索引)对
    private static int[] twoSumByHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0, len = nums.length; i < len; i++) {
            int curNum = nums[i];
            if(map.containsKey(target - curNum)) {
                return new int[] {map.get(target - curNum), i};
            }
            map.put(curNum, i);
        }
        throw new RuntimeException("no such elements");
    }

    // 迭代找到数组中和为目标值的两数索引
    // 时间复杂度O(n^2) 空间复杂度O(1)
    private static int[] twoSumByIteration(int[] nums, int target) {
        int indices[] = new int[2];
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    indices[0] = i;
                    indices[1] = j;
                    return indices;
                }
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        int nums[] = new int[] {2, 7, 11, 15};
        int target = 9;
        int indices[] = twoSum(nums, target);
        for(int index : indices) {
            System.out.print(index + ", ");
        }
    }

}
