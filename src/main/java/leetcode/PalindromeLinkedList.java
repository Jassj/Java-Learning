package leetcode;

import leetcode.bean.ListNode;

import java.util.ArrayList;

/**
 * description
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * @author yuanjie 2020/02/24 16:38
 */
public class PalindromeLinkedList {

    private static boolean isPalindrome(ListNode head) {
//        return isPalindromeByArrayList(head);
        return isPalindromeByReversed(head);
    }

    // 反转一半链表，从前往后和从后往前遍历值相同则为回文链表
    private static boolean isPalindromeByReversed(ListNode head) {
        int index = 1;
        ListNode copyHead = head;
        while(head != null && head.next != null) {
            index++;
            head = head.next;
        }
        int midIndex = index / 2 + index % 2; // 找到中间值(也可以使用快慢指针法找到中间值)
        int endIndex = index; // 尾结点索引
        ListNode tail = null; // 记录尾结点
        // 初始化，准备反转一半链表
        ListNode preNode = null;
        head = copyHead;
        index = 1;
        while(head != null) {
            ListNode nextNode = head.next;
            if(index == endIndex) { // 记录尾结点
                tail = head;
            }
            if(index > midIndex) { // 反转
                if(index == midIndex +1 && endIndex % 2 == 0) { // 偶数情况处理中间两节点的后续节点都指向null
                    head.next = null;
                    preNode.next = null;
                } else {
                    head.next = preNode;
                }
            }
            preNode = head;
            head = nextNode;
            index++;
        }

        // 头结点和尾结点依次遍历比较
        while(copyHead != tail) {
            if(copyHead.val != tail.val) {
                return false;
            }
            copyHead = copyHead.next;
            tail = tail.next;
        }

        return true;
    }

    /**
     * 将链表值复制到数组list中，使用双指针法判断是否回文
     * 时间复杂度：O(n)
     * 空间复杂度：0(n)
     */
    private static boolean isPalindromeByArrayList(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        // 复制数据
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }

        // 判断回文
        int front = 0;
        int back = list.size() - 1;
        while(front < back) {
            // Number objects(Integer) are compared using 'equals()'
            if(!list.get(front).equals(list.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode list =  new ListNode(1, new ListNode(1));
        System.out.println(isPalindrome(list));
    }
}
