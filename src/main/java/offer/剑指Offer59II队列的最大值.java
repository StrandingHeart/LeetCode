package offer;

import java.util.*;

/**
 * @author zhangyong
 * Created on 2021-05-15
 */
public class 剑指Offer59II队列的最大值 {
//请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
//
//若队列为空，pop_front 和 max_value 需要返回 -1
//
//示例 1：
//
//输入:
//["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
//[[],[1],[2],[],[],[]]
//输出: [null,null,null,2,1,2]
//示例 2：
//
//输入:
//["MaxQueue","pop_front","max_value"]
//[[],[],[]]
//输出: [null,-1,-1]
//
}

class MaxQueue {
    private PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
    private Deque<Integer> deque = new LinkedList<>();
    public MaxQueue() {

    }

    public int max_value() {
        if (queue.isEmpty()){
            return -1;
        }
        return queue.peek();
    }

    public void push_back(int value) {
        queue.add(value);
        deque.push(value);
    }

    public int pop_front() {
        if (deque.isEmpty()){
            return -1;
        }
        Integer pop = deque.pollLast();
        queue.remove(pop);
        return pop;
    }

    public static void main(String[] args) {

        //["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
        //[[],[1],[2],[],[],[]]
        //输出
        //[null,null,null,1,2,2]
        //预期结果
        //[null,null,null,2,1,2]
        MaxQueue s = new MaxQueue();
        s.push_back(1);
        s.push_back(2);
        System.out.println(s.max_value());
        System.out.println(s.pop_front());
        System.out.println(s.max_value());

//        PriorityQueue<Integer> queue1 = new PriorityQueue<>(Comparator.reverseOrder());
//        queue1.add(2);
//        queue1.add(1);
//        queue1.add(3);
//        queue1.add(4);
//        queue1.add(0);
//        queue1.add(9);
//        System.out.println(queue1.peek());
//        System.out.println(queue1);
    }
}