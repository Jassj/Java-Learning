package leetcode.work;

import java.util.HashMap;
import java.util.Map;

/**
 * description
 * 找出所有不连续且已出现过的数字
 * 输入:
 * [1,1,1,2,2,3,1,1,3,3,2]
 *
 * 输出:
 * [1,1,3,3,2]
 * @author yuanjie 2020/03/02 9:37
 */
public class FindAllDiscontinuousAppearedNumber {

    private static void findAllDiscontinuousAppearedNumber(int nums[]) {
        findAllDiscontinuousAppearedNumberByHashMap(nums);
    }

    // 记住哈希表完成
    private static void findAllDiscontinuousAppearedNumberByHashMap(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        int curNum = Integer.MIN_VALUE;
        for(int num : nums) {
            if(!map.containsKey(num)) { // 第一次出现时初始化并保存入哈希表
                map.put(num, true);
                curNum = num;
            } else { // 集合中已有此数
                if(!map.get(num)) { // 如果此数同类已经被标红，则直接标记
                    System.out.print(num+" ");
                } else if(curNum != num) { // 与前一个数不相同，则直接标红
                    System.out.print(num+" ");
                    map.put(num, false);
                }
                curNum = num;
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = new int[] {1,1,1,2,2,3,1,1,3,3,2}; // 测试样本数据量5000+
        findAllDiscontinuousAppearedNumber(nums);
    }
}
