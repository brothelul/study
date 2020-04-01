package com.ddup.leetcode.other;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>手里有一副扑克牌。按照下列规则吧他堆放桌上。
 * 一，拿出最上面的一张牌，放桌上，然后把接下来的一张牌放在扑克牌的最下面。循环，直到没有手牌。
 * 现在已知桌上牌的顺序。求原手牌的顺序 </p>
 *
 * @author chenglu
 * @date 2020/4/1
 */
public class PokerCardOrder {
    public static void main(String[] args) {
        System.out.println(recoverOrder(Arrays.asList(1, 3, 5, 7, 9, 2, 6, 10, 8, 4)));
    }

    public static List<Integer> recoverOrder(List<Integer> currentOrder) {
        LinkedList<Integer> originOrder = new LinkedList<>();
        Collections.reverse(currentOrder);
        for (int i = 0; i < currentOrder.size(); i++) {
            originOrder.addFirst(currentOrder.get(i));
            if (i == currentOrder.size()-1) {
                break;
            }
            Integer last = originOrder.getLast();
            originOrder.removeLast();
            originOrder.addFirst(last);

        }
        return originOrder;
    }
}
