package leetcode;

import java.util.*;

/**
 * description：
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * @author yuanjie 2020/02/15 16:49
 */
public class MinStack {
    /**
     * 使用Stack存储元素，每次将当前元素和当前最小元素同时压入栈
     * ①.push操作：将当前元素和当前最小元素同时压入栈
     * ②.pop操作：删除栈顶元素与其对应的当时最小值，及删除栈顶两个元素
     * ③.top：返回栈顶索引-1的元素
     * ④.getMin：返回栈顶元素
     */
    private Stack<Integer> stack = new Stack<>();

    private MinStack() {

    }

    private void push(int x) {
        int min = stack.size() > 0 ? stack.peek() : x;
        stack.push(x);
        if(x < min) {
            stack.push(x);
        } else {
            stack.push(min);
        }
    }

    private void pop() {
        stack.pop();
        stack.pop();
    }

    private int top() {
        return stack.elementAt(stack.size()-2);
    }

    private int getMin() {
        return stack.peek();
    }

    public static void main(String[] args) {
        MinStackByList obj = new MinStackByList();
        obj.push(2);
        obj.push(3);
        obj.push(1);
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());

        MinStack obj1 = new MinStack();
        obj1.push(2);
        obj1.push(3);
        obj1.push(1);
        obj1.pop();
        System.out.println(obj1.top());
        System.out.println(obj1.getMin());
    }
}

class MinStackByList {
    /**
     * 使用List集合代替Stack, min记录集合中的最小值
     * ①.push操作：往集合中增加元素比较并计算当前最小值O(n)
     * ②.pop操作：找出剩余元素中的最小数,并删除索引最大的元素O(N)
     * ③.top：返回集合中索引最大的元素O(1)
     * ④.getMin：返回min的值O(1)
     */
    private List<Integer> list = new ArrayList<>();
    private int min = Integer.MAX_VALUE;

    MinStackByList() {

    }

    void push(int x) {
        list.add(x);
        min = Math.min(x, min);
    }

    void pop() {
        if(list.size() == 0) { // 栈无元素抛出异常
            throw new EmptyStackException();
        }
        // 排序并找出最小值
        min = list.get(0);
        for(int i = 0; i < list.size() - 1; i++) {
            min = Math.min(list.get(i), min);
        }
        list.remove(list.size()-1);
        if(list.size() == 0) { // 栈无元素后初始化最小值
            min = Integer.MAX_VALUE;
        }
    }

    int top() {
        if(list.size() == 0) { // 栈无元素抛出异常
            throw new EmptyStackException();
        }
        return list.get(list.size()-1);
    }

    int getMin() {
        if(list.size() == 0) { // 栈无元素抛出异常
            throw new EmptyStackException();
        }
        return min;
    }

}


