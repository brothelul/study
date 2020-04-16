package com.ddup.leetcode.other;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p> LRU的实现, get set , delete时间复杂度为O(1) </p>
 *
 * @author chenglu
 * @date 2020/4/16
 */
public class LRU {
    public static void main(String[] args) {
        Cache<Integer, Integer> cache = new Cache<>(3);
        System.out.println(cache.set(1, 2));
        System.out.println(cache.set(2, 2));
        System.out.println(cache.set(8, 9));
        System.out.println(cache.set(6, 9));
        System.out.println(cache.get(1));
        System.out.println(cache.delete(8));
    }
}

class Cache<K, V> {

    private Link<K, V> head;
    private Link<K, V> tail;
    private int maxSize;
    private int length;
    private Map<K, Link<K, V>> map = new ConcurrentHashMap<>(64);

    public Cache(int maxSize) {
        this.maxSize = maxSize;
    }

    public V get(K key) {
        Link<K, V> node = map.get(key);
        if (node == null) {
            return null;
        }
        if (node.pre == null) {
            return node.value;
        }
        if (node.next == null) {
            tail = node.pre;
            node.next = head;
            head = node;
            return node.value;
        }
        node.pre.next = node.next;
        node.next = head;
        head = node;
        return node.value;
    }
    public boolean set(K key, V value) {
        if (map.get(key) != null) {
            Link<K, V> node = map.get(key);
            node.value = value;
            if (node.pre == null) {
                return true;
            }
            if (node.next == null) {
                tail = node.pre;
                node.next = head;
                head.pre = node;
                head = node;
                head.pre = null;
                return true;
            }
            node.pre.next = node.next;
            node.next = head;
            head = node;
            head.pre = null;
            return true;
        }
        if (length >= maxSize) {
            tail = tail.pre;
            delete(tail.next.key);
            tail.next = null;
            Link<K, V> current = new Link<>(key, value);
            current.next = head;
            head.pre = current;
            head = current;
            map.put(key, current);
            return true;
        }
        length++;
        Link<K, V> node = new Link<>(key, value);
        node.next = head;
        if (length > 1) {
            head.pre = node;
        }
        head = node;
        map.put(key, node);
        if (length == 1) {
            tail = head;
            head.next = tail;
            tail.pre = head;
        }
        if (length == 2) {
            tail = head.next;
            tail.pre = head;
        }
        return true;
    }

    public boolean delete(K key) {
        Link<K, V> node = map.get(key);
        if (node == null) {
            return false;
        }
        length --;
        map.remove(key);
        if (node.next == null) {
            tail = node.pre;
            tail.next = null;
            return true;
        }
        if (node.pre == null) {
            head = node.next;
            head.pre = null;
            return true;
        }
        node.pre.next = node.next;
        node.next.pre = node.pre;
        return true;
    }

    class Link<K, V> {
        Link<K, V> pre;
        Link<K, V> next;
        K key;
        V value;

        public Link(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
