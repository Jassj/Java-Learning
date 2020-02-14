package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * description
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * @author yuanjie 2020/02/13 15:22
 */
public class SingleNumber {

    // 数组长度一定为奇数
    // 2∗(a+b+c)−(a+a+b+b+c)=c 可能存在溢出问题
    private static int singleNumber(int[] nums) {
//        return singleNumberByHashMap(nums);
        return singleNumberByXOR(nums);
    }

    /**
     * 概念--通过异或位运算符来计算：相异位为1，相同位为0，且异或运算满足结合律
     *
     * 如果我们对 0 和二进制位做 XOR 运算，得到的仍然是这个二进制位
     * a⊕0=a
     * 如果我们对相同的二进制位做 XOR 运算，返回的结果是 0
     * a⊕a=0
     * XOR 满足交换律和结合律
     * a⊕b⊕a=(a⊕a)⊕b=0⊕b=b
     *
     */
    private static int singleNumberByXOR(int[] nums) {
        for (int i = 0, len = nums.length; i < len; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }

    // 使用map进行存储
    private static int singleNumberByHashMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.remove(num);
            } else {
                map.put(num, 1);
            }
        }

        return map.keySet().iterator().next();
    }

    public static void main(String[] args) {
        int a[] = new int[]{4,1,2,1,2};
        System.out.println(singleNumber(a));
    }
}
