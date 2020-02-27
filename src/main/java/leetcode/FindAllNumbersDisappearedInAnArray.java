package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * description
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 * @author yuanjie 2020/02/27 11:18
 */
public class FindAllNumbersDisappearedInAnArray {
    private static List<Integer> findDisappearedNumbers(int[] nums) {
//        return findDisappearedNumbersByList(nums);
//        return findDisappearedNumbersBySort(nums);
        return findDisappearedNumbersByReversedNumber(nums);
    }

    /**
     * 4,3,2,7,8,2,3,1,5
     * 1,2,3,4,5,6,7,8,9
     * 遍历数组把 |nums[i]|-1 索引位置的元素标记为负数。即 nums[|nums[i]| - 1] * -1 。
     * 然后遍历数组，若当前数组元素nums[i]为负数，说明我们在数组中存在数字 i+1。Todo
     */
    private static List<Integer> findDisappearedNumbersByReversedNumber(int[] nums) {
        return null;
    }

    // 排序后依次遍历，按照1-n的顺序判断当前索引值与实际值是否相等，不相等则为消失的元素，每次遍历定位实际值 = 索引值 + 1
    private static List<Integer> findDisappearedNumbersBySort(int[] nums) {
        List<Integer> list = new LinkedList<>(); // LinkedList.add方法的时间复杂度小于ArrayList.add
        Arrays.sort(nums);
        int j = 1, len = nums.length;
        for(int num : nums) {
            if(num != j) {
                for(int i = j; i < num; i++) { // 添加中间消失的元素
                    list.add(i);
                }
            }
            j = num + 1;
        }
        for(; j <= len; j++) { // 添加末尾消失的元素
            list.add(j);
        }
        return list;
    }

    /**
     * 样本容量过大时空间复杂度过高: list.add方法会先计算当前容量，容量不够时需要扩容
     * 扩容操作 {@link java.util.Arrays#copyOf(Object[], int)}: 重新拷贝数组导致额外空间的浪费
     * list.remove {@link java.lang.System#arraycopy(Object, int, Object, int, int)}: 重新拷贝数组导致额外空间的浪费
     */
    private static List<Integer> findDisappearedNumbersByList(int[] nums) {
        List<Integer> list = new ArrayList<>(); // 初始容量为10
        int len = nums.length;
        for(int i = 1; i <= len; i++) {
            list.add(i);
        }

        for(int num : nums) {
            list.remove((Integer) num);
        }

        return list;
    }

    public static void main(String[] args) {
        int [] nums = new int[] {4,3,2,7,8,2,3,1,5};
        List<Integer> list = findDisappearedNumbers(nums);
        for(Integer i : list) {
            System.out.print(i+"-->");
        }
    }
}
