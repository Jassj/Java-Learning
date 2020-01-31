package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * description:
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 注意:
 * ①.空字符串可被认为是有效字符串
 * ②.奇数位字符串可被认为是无效字符串
 * @author yuanjie 2020/01/31 14:09
 */
public class ValidParentheses {

    private static boolean isValid(String s) {
        return isValidByStack(s);
//        return isValidByReplace(s);
//        return isValidByHashMap(s);
    }

    //使用replace置换函数得出结果
    private static boolean isValidByReplace(String s) {
        int beforeLen;
        do {
            beforeLen = s.length();
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
        }while (s.length() > 0 && beforeLen > s.length());
        return s.length() == 0;
    }

    //使用Stack栈替换map构造的栈
    private static boolean isValidByStack(String s) {
        int len = s.length();
        if(len == 0) { //空字符串可被认为是有效字符串
            return true;
        } else if(len % 2 != 0) { //奇数位字符串可被认为是无效字符串
            return false;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> parenthesesMap = new HashMap<Character, Character>(3) {
            { put(')','('); put('}','{'); put(']','[');}
        }; //左右括弧的map映射
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                char oppositeChar = parenthesesMap.get(c);
                if(!stack.empty())  {
                    char existChar = stack.pop();
                    if(existChar != oppositeChar) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            if(stack.size() << 1 > len) { //栈中已知字符深度大于字符串一半长度时，即可终止遍历
                return false;
            }
        }
        return stack.empty();
    }

    /**
     * 遍历字符串，使用HashMap依次存储字符--键为索引、值为字符，相当于构造一个先进后出的栈
     * 当遇到左括弧时push入map中，当遇到右括弧时查找对应左括弧并且判断：
     * ①.如果右括弧对应的左括弧位于栈的最外部，则匹配成功，从map中pop此字符;否则终止遍历
     * ②.栈中已知字符深度大于字符串一半长度时，即可终止遍历
     * */
    private static boolean isValidByHashMap(String s) {
        int len = s.length();
        if(len == 0) { //空字符串可被认为是有效字符串
            return true;
        } else if(len % 2 != 0) { //奇数位字符串可被认为是无效字符串
            return false;
        }
        Map<Integer, Character> map = new HashMap<>(len); //map集合构造的栈
        Map<Character, Character> parenthesesMap = new HashMap<Character, Character>(3) {
            { put(')','('); put('}','{'); put(']','[');}
        }; //左右括弧的map映射
        int mapLen = 0; //记载栈已有字符深度的变量
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                map.put(++mapLen, c);
            } else {
                char oppositeChar = parenthesesMap.get(c);
                if(mapLen > 0 && oppositeChar == map.get(mapLen))  {
                    map.remove(mapLen--);
                } else {
                    return false;
                }
            }
            if(mapLen << 1 > len) { //栈中已知字符深度大于字符串一半长度时，即可终止遍历
                return false;
            }
        }
        return mapLen == 0;
    }

    public static void main(String[] args) {
//        System.out.println(isValid("([])"));
    }
}
