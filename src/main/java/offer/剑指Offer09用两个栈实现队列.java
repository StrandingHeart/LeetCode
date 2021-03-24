package offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhangyong
 * Created on 2021-03-24
 */
public class 剑指Offer09用两个栈实现队列 {
}

class CQueue {
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public CQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    /**
     * 判定第二个栈是否为空，如果为空就把stack1中的元素全部放到Stack2，然后再执行stack2的删除出栈操作
     *
     * @return
     */
    public int deleteHead() {
        if (stack2.isEmpty()){
            if (!stack1.isEmpty()){
                while (!stack1.isEmpty()){
                    Integer pop = stack1.pop();
                    stack2.push(pop);
                }
                return stack2.pop();
            }else {
                return -1;
            }
        }else {
            return stack2.pop();
        }
    }
}