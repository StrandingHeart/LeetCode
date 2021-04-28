package offer;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zhangyong
 * Created on 2021-04-21
 */
public class 剑指Offer41数据流中的中位数 {

}
class MedianFinder {

    Queue<Integer> a;
    Queue<Integer> b;
    /** initialize your data structure here. */
    public MedianFinder() {
        a = new PriorityQueue<>();
        b = new PriorityQueue<>((x,y)->y-x);
    }

    public void addNum(int num) {
        if (a.size()==b.size()){
            //都空
            b.add(num);
            a.add(b.poll());
        }else {
            a.add(num);
            b.add(a.poll());
        }
    }

    public double findMedian() {
        return a.size()!=b.size()?a.peek():(a.peek()+b.peek())/2.0;
    }
}
