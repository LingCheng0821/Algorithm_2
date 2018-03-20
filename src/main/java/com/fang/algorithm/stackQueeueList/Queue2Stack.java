package com.fang.algorithm.stackQueeueList;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 两个队列实现栈
 * 思想：
 *      入栈：两个队列哪个不为空，就把元素入队到哪个队列中；
 *      出栈：把不为空的队列中出最后一个元素外的所有元素都移动到两一个队列中，然后出队最后一个元素
 */
public class Queue2Stack {
    private Queue queue1;
    private Queue queue2;
    private int maxLenth;

    public Queue2Stack(int maxLenth){
        this.maxLenth = maxLenth;
        this.queue1 = new ArrayBlockingQueue(maxLenth);
        this.queue2 = new ArrayBlockingQueue(maxLenth);
    }

    public boolean push(int item){
        if(size() == maxLenth){
            return false;
        }

        if(queue2.isEmpty()) {
            queue2.add(item);
        }else {
            queue1.add(item);
        }
        return true;
    }

    public Object pop(){
        if(size() == 0){
            return null;
        }else{
            if(queue2.isEmpty()){
                while(queue1.size() > 1){
                    queue2.add(queue1.poll());
                }
                return queue1.poll();
            }else{
                while(queue2.size() > 1){
                    queue1.add(queue2.poll());
                }
                return queue2.poll();
            }
        }
    }

    public int size(){
        return queue1.size() + queue2.size();
    }
}
