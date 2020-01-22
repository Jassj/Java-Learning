package leetcode;

/**
 * description:
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 *
 * 反转字符串后：求两个字符串中最长相同子串,最长公共子序列法(LCS)--[aacdefcaa]存在问题需优化
 * @author yuanjie 2020/01/09 10:45
 */
public class LongestPalindromeSubstring {

    private static String longestPalindrome(String s) {
//        return longestPalindromeByAllChecked(s);
//        return longestPalindromeByLCS(s);
        return longestPalindromeByDynamicProgramming(s);
//        return longestPalindromeByCenterExtension(s);
    }

    private static String longestPalindromeByCenterExtension(String s) {
        return null;
    }

    //③.动态规划找出最长回文子串：Todo 空间复杂度可优化
    // 规则：
    // 长度1：p(i, j)   ==> i == j 时必为回文
    // 长度2：p(i, j)   ==> j == i + 1 && s[i] == s[j] 回文
    // 长度3~n：p(i, j) ==> p(i+1, j-1) && s[i] == s[j] 回文
    private static String longestPalindromeByDynamicProgramming(String s) {
        int length = s.length();
        String ansStr = "";
/*        boolean p[][] = new boolean[length][length];
        //按照子串长度遍历,从1-n
        for(int len = 1; len <= length; len++) {
            for(int start = 0; start < length; start++) {
                int end = start + len - 1;
                if(end >= length) {
                    break;
                }
                //n(n+1)/2 种可能情况
                //b(p[0][0]) a(p[1][1]) b(p[2][2]) a(p[3][3]) d(p[4][4])
                //ba(p[0][1]) ab(p[1][2]) ba(p[2][3]) ad(p[3][4])
                //bab(p[0][2]) aba(p[1][3]) bad(p[2][4])
                //baba(p[0][3]) abad(p[1][4])
                //babad(p[0][4])
                p[start][end] = start == end || (end - start == 1 && s.charAt(start) == s.charAt(end)) || (end - start >= 2 && p[start+1][end-1] && s.charAt(start) == s.charAt(end));
                if(p[start][end] && len > ansStr.length()) {
                    ansStr = s.substring(start, end + 1);
                }
            }
        }*/

/*        boolean p[][] = new boolean[length][length];
        //倒序遍历
        //d(p[4][4])
        //a(p[3][3]) ad(p[3][4])
        //b(p[2][2]) ba(p[2][3]) bad(p[2][4])
        //a(p[1][1]) ab(p[1][2]) aba(p[1][3]) abad(p[1][4])
        //b(p[0][0]) ba(p[0][1]) bab(p[0][2]) baba(p[0][3]) babad(p[0][4])
        for(int i = length - 1; i >= 0; i--) {
            for(int j = i; j < length ; j++) {
                p[i][j] = (i == j) || (j - i == 1 && s.charAt(i) == s.charAt(j)) || (j - i >= 2 && p[i+1][j-1] && s.charAt(i) == s.charAt(j));
                if(p[i][j] && j - i + 1 > ansStr.length()) {
                    ansStr = s.substring(i, j + 1);
                }
            }
        }*/

        return ansStr;
    }

    //②.反转后求两个字符串的最长公共子串
    // 循环遍历找出反转字符串中子串是否在原串中
    // ==> 只能证明原串中有此子串和其反转,但并一定连续
    // ==> 并非强约束条件,当两串中间包含非回文串时(aacdefcaa)存在问题,需要增加子串索引判断
    // 长度为1的字符串特殊处理：Todo 方法待完善
    private static String longestPalindromeByLCS(String s) {
        String reversedStr = new StringBuilder(s).reverse().toString();

        for(int i = 0, len = reversedStr.length(); i < len; i++) {

        }
        return null;
    }

    //①.暴力法列出所有字符串并判断是否回文,找出最长子串：长度为1和2的字符串特殊处理
    private static String longestPalindromeByAllChecked(String s) {
        String ansStr = "";
        for(int i = 0, len = s.length(); i < len; i++) {
            for(int j = i + 2; j <= len; j++) {
                if(j - i == 2) {
                    if (ansStr.length() < 2 && s.charAt(i) == s.charAt(j - 1)) {
                        ansStr = s.substring(i, j);
                    } else {
                        continue;
                    }
                }

                if(ansStr.length() < j - i && isPalindrome(s.substring(i, j))) {
                    ansStr = s.substring(i, j);
                }
            }
        }
        if("".equals(ansStr) && s.length() >= 1) {
            ansStr = s.substring(0, 1);
        }
        return ansStr;
    }

    //判断字符串是否回文
    private static boolean isPalindrome(String s) {
        for(int i = 0, len = s.length(); i < len / 2; i++) {
            if(s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(longestPalindrome("aaacbbd"));
        long longTime = System.currentTimeMillis();
        System.out.println("耗时：" + (longTime - startTime));
    }
}
