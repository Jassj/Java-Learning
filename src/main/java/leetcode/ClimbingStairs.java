package leetcode;

/**
 * description:
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * Todo 了解构造递归模型的方法，以及方法调用与返回顺序
 * @author yuanjie 2020/02/01 19:19
 */
public class ClimbingStairs {

    private static int climbStairs(int n) {
        return climbStairsByDynamic(n);
//        return climbStairsByExhaustion(n);
//        return climbStairsByFibonacci(n);
    }

    /**
     * 动态规划
     * ①.n = 1，有1种方法
     * ②.n = 2，有2种方法
     * ③.当n >= 3时，有两种选择方式
     * a.计算dp[n-1]的结果后走1步
     * b.计算dp[n-2]的结果后走2步
     * 因此dp[n] = dp[n-1] + dp[n-2]
     *
     * 时间复杂度O(n)，空间复杂度O(n)
     */
    private static int climbStairsByDynamic(int n) {
        if(n <= 2) {
            return n;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        int i = 3;
        while(i <= n) {
            dp[i] = dp[i-1] + dp[i-2];
            i++;
        }
        return dp[n];
    }

    /**
     * 斐波那契数列：f(n) = f(n-1) + f(n-2)
     * 假设爬n个台阶时有f(n)种方法
     * ①.n = 1，有1种方法
     * ②.n = 2，有2种方法
     * ③.当n >= 3时，每次都有两种选择
     * a.爬1阶，剩余n-1阶有f(n-1)种结果
     * b.爬2阶，剩余n-2阶有f(n-2)种结果
     * 因此，f(n) = f(n-1) + f(n-2)，结果为斐波那切数列
     *
     * 时间复杂度O(n)，空间复杂度O(1)
     */
    private static int climbStairsByFibonacci(int n) {
        if(n <= 2) {
            return n;
        }

//        return climbStairsByFibonacci(n-1) + climbStairsByFibonacci(n-2); // 使用递归求解菲波那切数列时：会重复计算已有结果的值，效率太低需要优化
        int f1 = 1, f2 = 2, result = 0;
        while(n >= 3) {
            result = f1+f2;
            f1 = f2;
            f2 = result;
            n--;
        }

        return result;
    }

    // 暴力穷举法(及优化方法)，使用递归列举所有可能情况，时间复杂度为O(2^n)
    private static int climbStairsByExhaustion(int n) {
//        return climb_stairs(0, n);
        int memo[] = new int[n+1];
        return climb_stairs(0, n, memo);
    }

    // 递归遍历所有二叉树的路径: 会重复计算已有结果的值，效率太低需要优化
    private static int climb_stairs(int i, int n) {
        if(i > n) {
            return 0;
        }

        if(i == n) {
            return 1;
        }

        return climb_stairs(i+1, n) + climb_stairs(i+2, n);
    }

    // 优化递归遍历所有二叉树的路径: 可以将每一步的结果存储起来，减少重复计算次数
    // 递归遍历所有二叉树的路径: 会重复计算已有结果的值，效率太低需要优化
    private static int climb_stairs(int i, int n, int[] memo) {
        if(i > n) {
            return 0;
        }

        if(i == n) {
            return 1;
        }

        if(memo[i] > 0) {
            return memo[i];
        }

        memo[i] += climb_stairs(i+1, n, memo) + climb_stairs(i+2, n, memo);

        return memo[i];
    }


    public static void main(String[] args) {
//        System.out.println(climbStairs(45));
    }
}
