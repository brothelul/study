package com.ddup.leetcode.offer;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 *     请定义一个队列并实现函数 max_value 得到队列里的最大值，
 *     要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 示例 1：
 *
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 *
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 *  
 *
 * 限制：
 *
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * 1 <= value <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/7/31
 */
public class Q59_2 {
    public static void main(String[] args) {
        MaxQueue obj = new MaxQueue();
        int param_1 = obj.max_value();
        System.out.println(param_1);
        obj.push_back(1);
        obj.push_back(3);
        System.out.println(obj.max_value());
        int param_3 = obj.pop_front();
        System.out.println(param_3);
        System.out.println(obj.max_value());
    }

    static class MaxQueue {

        List<Integer> container;
        List<Integer> serialQueue;

        public MaxQueue() {
            container = new LinkedList<>();
            serialQueue = new LinkedList<>();
        }

        public int max_value() {
            if (container.isEmpty()) {
                return -1;
            }
            return serialQueue.get(0);
        }

        public void push_back(int value) {
            container.add(value);
            if (serialQueue.isEmpty()) {
                serialQueue.add(value);
                return;
            }
            if (value > serialQueue.get(serialQueue.size() - 1)) {
                serialQueue.removeIf(integer -> integer < value);
                serialQueue.add(value);
                return;
            }
            serialQueue.add(value);
        }

        public int pop_front() {
            if (container.isEmpty()) {
                return -1;
            }
            Integer res = container.get(0);
            container.remove(0);
            if (res.equals(serialQueue.get(0))) {
                serialQueue.remove(0);
            }
            return res;
        }
    }
}
