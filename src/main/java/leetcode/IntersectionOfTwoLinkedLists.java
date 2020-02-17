package leetcode;

import leetcode.bean.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * description:
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 注意：
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * @author yuanjie 2020/02/16 21:50
 */
public class IntersectionOfTwoLinkedLists {

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        return getIntersectionNodeByHashSet(headA, headB);
        return getIntersectionNodeByDoublePointer(headA, headB);
    }

    /**
     * 遍历链表A和B，当链表A遍历到尾结点时，连接到链表B的头结点继续遍历，链表B遍历到尾结点时连接到A的头结点继续遍历
     * ①.如果两个链表有交点：SingleA + Common + SingleB = SingleB + Common + SingleA
     * ②.因此两个指针相同时即为交点
     * ③.注意点：A、B相交时尾结点一定相同，排除不相交null的情况
     * 时间复杂符 0(m+n) = O(n)
     * 空间复杂度 0(1)
     */
    private static ListNode getIntersectionNodeByDoublePointer(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }

        ListNode flagA = headA;
        ListNode flagB = headB;

        while(flagA != flagB) { // 如果A+B和B+A遍历完相同为null,则返回null
            if(flagA == null) {
                flagA = headB;
            } else {
                flagA = flagA.next;
            }

            if(flagB == null) {
                flagB = headA;
            } else {
                flagB = flagB.next;
            }
        }

        return flagA;
    }

    /**
     * 遍历链表A和B，将遍历的节点存入set中，如果两个链表相交：则遍历时set集合值重复，即为起始交点
     * 时间复杂符 0(m+n) = O(n)
     * 空间复杂度 0(m)或O(n)
     */
    private static ListNode getIntersectionNodeByHashSet(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode flagA = headA;
        ListNode flagB = headB;

        // 同时遍历A、B
/*        while(flagA != null || flagB != null) {
            if(flagA != null) {
                if(set.contains(flagA)) {
                    return flagA;
                }
                set.add(flagA);
                flagA = flagA.next;
            }

            if(flagB != null) {
                if(set.contains(flagB)) {
                    return flagB;
                }
                set.add(flagB);
                flagB = flagB.next;
            }
        }*/

        //先遍历A、后遍历B
        while(flagA != null) {
            set.add(flagA);
            flagA = flagA.next;
        }

        while(flagB != null) {
            if(set.contains(flagB)) {
                return flagB;
            }
            flagB = flagB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode commonListNode = new ListNode(3);
        ListNode a = new ListNode(1, commonListNode);
        ListNode b = new ListNode(1, new ListNode(2, commonListNode));
        System.out.println(getIntersectionNode(a, b).val);
    }
}

