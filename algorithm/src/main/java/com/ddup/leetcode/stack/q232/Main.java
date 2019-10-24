package com.ddup.leetcode.stack.q232;

/**
 * <p> 实现栈 </p>
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 *
 * @author chenglu
 * @date 2019/10/24
 */
public class Main {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(2);
        myQueue.push(3);
        int param2 = myQueue.pop();
        int param3 = myQueue.peek();
        boolean param4 = myQueue.empty();
        System.out.println(""+param2 +"-"+param3+"-"+param4);
    }
}

class MyQueue {

    int[] queue = new int[]{};

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        int[] newQueue = new int[queue.length + 1];
        System.arraycopy(queue, 0, newQueue, 0, queue.length);
        newQueue[queue.length] = x;
        queue = newQueue;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int value = queue[0];
        int[] newQueue = new int[queue.length - 1];
        System.arraycopy(queue, 1, newQueue, 0 , queue.length - 1);
        queue = newQueue;
        return value;
    }

    /** Get the front element. */
    public int peek() {
        return queue[0];
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queue.length == 0;
    }
}
