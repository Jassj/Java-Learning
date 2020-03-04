package leetcode;

/**
 * description
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * @author yuanjie 2020/02/26 15:01
 */
public class MoveZeroes {

    /**
     * 重新初始化数组：遍历原数组，按照新索引依次置值，遇到0时跳过、新索引不增加，最后尾部补充等量0
     */
    private static void moveZeroes(int[] nums) {
        int j = 0, len = nums.length;
        for(int i = 0; i < len; i++) {
            if(nums[i] == 0) { // 遇到0跳过
                continue;
            }
            if(i == j) { // 索引相同时，不进行写入操作
                j++;
            } else {
                nums[j++] = nums[i];
            }
        }
        for(; j < len; j++) {
            if(nums[j] != 0) { // 尾部补充0时减少写入操作
                nums[j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]  {1, 0, 2, 0, 3, -2, 0};
        moveZeroes(nums);
        for(int num : nums) {
            System.out.print(num+", ");
        }
    }
}
