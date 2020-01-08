package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * description：滑动窗口法--set、Map集合以及Math的巧妙运用
 * @author yuanjie 2019/10/31 17:43
 */
public class LongestSubstring {

    private static int lengthOfLongestSubstring(String s) {
//        return checkAllSubString(s);
//        return scrollWindow(s);
        return optimizationScrollWindow(s);
    }

    // 优化滑动窗口法：滑动窗口向右滑动遇到重复字符时,会依次移动左边界将重复字符过滤
    // 那么此时可以直接根据重复字符在集合中的索引值直接移动左边界
    // 时间复杂度O(n)
    private static int optimizationScrollWindow(String s) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>(); // Map集合用于记录字符和索引值
        // 依次向右滑动右边界,将字符置于Map集合中,当遇到重复字符时,左边界移动且此字符索引值被更新
        for(int i = 0, j = 0, len = s.length(); j < len; j++) {
            if(map.containsKey(s.charAt(j))) {
                // 左边界移动时需进行判断,如果当前左边界位于的索引大于重复字符所在的低位索引,则不更新左边界,否则更新
                // 因为是先移动左边界再更新重复字符索引值,所以需考虑此种情况
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            map.put(s.charAt(j), j);
            result = Math.max(result, j - i + 1);
        }
        return result;
    }

    // 滑动窗口法：暴力法会重复检验子字符串中是否包含重复字符,使用滑动窗口
    // 初始情况下滑动窗口的set集合为空,左窗索引i、右窗索引j
    // 每次进行尝试滑动右窗,当前索引对应字符未重复时：右窗增加,重复时：左窗减少
    // 时间复杂度O(2n)
    private static int scrollWindow(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, n = s.length();
        int result = 0;
        while(i < n && j < n) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                result = Math.max(result, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return result;
    }

    //暴力法：双层循环遍历整个字符串,找出所有可能的字串,且筛选获取没有重复数字的字符串,长度最长的则为结果
    //时间复杂度O(n^3), 空间复杂度O(k): set集合的大小-----效率过低
    private static int checkAllSubString(String s) {
        int result = 0;
        int length = s.length();
        for(int i = 0; i <= length - 1; i++) {
            for(int j = i + 1; j <= length; j++) {
                if(checkAllUnique(s, i , j)) {
                    result = Math.max(result, j - i); //Math函数比较两数获取较大值
                }
            }
        }
        return result;
    }

    //判断字符串每个字符是否唯一,唯一返回true,不唯一返回false
    private static boolean checkAllUnique(String str, int start, int end) {
        Set<Character> set = new HashSet<>();//使用set集合判断是否重复
        for(int n = start; n < end; n++) {
            char c = str.charAt(n);
            if(!set.contains(c)) {
                set.add(c);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }
}
