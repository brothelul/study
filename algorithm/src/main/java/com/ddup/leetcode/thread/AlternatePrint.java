package com.ddup.leetcode.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p> 线程交替打印，一个线程打印数组[1, 2, 3], 一个打印 ['a', 'b', 'c'] </p>
 *
 * @author chenglu
 * @date 2020/3/28
 */
public class AlternatePrint {
    public static void main(String[] args) {
        solution1();
    }
    private static void solution1(){

        Integer[] i1 = new Integer[]{ 1, 2, 3};
        String[] i2 = new String[]{"a", "b", "c"};
        Lock lock = new ReentrantLock();
        Condition c = lock.newCondition();
        AtomicInteger times = new AtomicInteger(0);
        Thread t1 = new Thread(() -> {
            while (times.get() / 2 < i1.length) {
                try {
                    lock.lock();
                    if (times.get() % 2 == 0) {
                        System.out.println(i1[times.get()/2]);
                        times.getAndIncrement();
                        c.signal();
                    } else {
                        c.await();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (times.get() / 2 < i2.length) {
                try {
                    lock.lock();
                    if (times.get() % 2 == 1) {
                        System.out.println(i2[times.get()/2]);
                        times.getAndIncrement();
                        c.signal();
                    } else {
                        c.await();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        t1.start();
        t2.start();
        LockSupport.park();
    }

    public static void solution2(){
        Integer[] i1 = new Integer[]{ 1, 2, 3};
        String[] i2 = new String[]{"a", "b", "c"};
        AtomicInteger times = new AtomicInteger(0);
        Object lock = new Object();
        Thread t1 = new Thread(() ->{
            while (times.get() / 2 < i1.length) {
                synchronized (lock) {
                    if (times.get() % 2 == 0) {
                        System.out.println(i1[times.get()/2]);
                        times.getAndIncrement();
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread t2 = new Thread(() ->{
            while (times.get() / 2 < i2.length) {
                synchronized (lock) {
                    if (times.get() % 2 == 1) {
                        System.out.println(i2[times.get()/2]);
                        times.getAndIncrement();
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        t1.start();
        t2.start();
        LockSupport.park();
    }
}
