package leetcode;

/**
 * description
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * @author yuanjie 2020/02/19 14:22
 */
public class HouseRobber {

    /**
     *
     * 动态规划求解：推导规律得：f(n).max = Math.max(f(n-2).max + n, f(n-1).max))
     */
    private static int rob(int[] nums) {
//        return robByRecursive(nums, nums.length - 1);
        return robByIteration(nums, nums.length - 1);
    }

    // 迭代法:
    private static int robByIteration(int[] nums, int maxIndex) {
        if(maxIndex < 0) { // 空数组直接返回
            return 0;
        }

        int max1 = 0, max2 = 0, curMax = 0;
        for(int i = 0; i <= maxIndex; i++) {
            if(i == 0) { // 索引为1和2时单独处理
                max1 = nums[0];
                curMax = max1;
                continue;
            }

            if(i == 1) {
                max2 = Math.max(nums[0], nums[1]);
                curMax = max2;
                continue;
            }

            curMax = Math.max(max1+nums[i], max2);
            max1 = max2;
            max2 = curMax;
        }

        return curMax;
    }

    // 递归法：耗时较长
    private static int robByRecursive(int[] nums, int maxIndex) {
        if(maxIndex < 0) {
            return 0;
        }

        if(maxIndex == 0) {
            return nums[0];
        }

        if(maxIndex == 1) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(robByRecursive(nums, maxIndex - 2) + nums[maxIndex], robByRecursive(nums, maxIndex - 1));
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
        int[] nums = new int[]{2,7,9,3,1};
        System.out.println(rob(nums));
    }
}
