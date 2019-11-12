package leetcode;

import javax.swing.*;

/**
 * @author yuanjie
 * @description
 * @date 2019/10/31 17:43
 */
public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        int length = s.length();
        for(int i = 0; i <= length - 1; i++) {
            for(int j = i + 1; j <= length - 1; j++) {
                String subStr = s.substring(i, j + 1);
//                if(checkAllUnique(subStr)) {
//                    return j - 1 + 1;
//                }
            }
        }
        return  result;
    }

//    private static boolean checkAllUnique(String subStr) {
//
//    }

    public static void main(String[] args) {
        int result = lengthOfLongestSubstring("pwkewp");
        System.out.println("result:"+result);
    }
}
