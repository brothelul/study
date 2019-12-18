package com.ddup.springstudy.cache;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p> 缓存击穿例子 </p>
 *
 * @author chenglu
 * @date 2019/12/18
 */
@Component
public class CacheBrokenDownTest {
    @Resource
    private RedisTemplate<String, String> redisTemplate;
    private static final String CACHE_KEY = "cache";
    private AtomicInteger dbCount = new AtomicInteger(0);
    private AtomicInteger cacheCount = new AtomicInteger(0);

    public void scene(){
        String value = redisTemplate.opsForValue().get(CACHE_KEY);
        if (Objects.nonNull(value)) {
            System.out.println("==================== 从【缓存】获取到数据 ====================");
            cacheCount.incrementAndGet();
            return;
        }
        System.out.println("==================== 从【数据库】获取到数据 ====================");
        redisTemplate.opsForValue().set(CACHE_KEY, "ccc", 2, TimeUnit.SECONDS);
        dbCount.incrementAndGet();
    }

    public synchronized void solution1(){
        scene();
    }

    public void solution2(){
        String value = redisTemplate.opsForValue().get(CACHE_KEY);
        if (Objects.nonNull(value)) {
            System.out.println("==================== 从【缓存】获取到数据 ====================");
            cacheCount.incrementAndGet();
            return;
        }
        synchronized (this) {
            scene();
        }
    }

    public void executeSolution(CountDownLatch countDownLatch) {
        solution2();
        countDownLatch.countDown();
    }

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("com.ddup");
        applicationContext.refresh();

        CacheBrokenDownTest cacheBrokenDownTest = applicationContext.getBean(CacheBrokenDownTest.class);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(50, 50, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1000));
        cacheBrokenDownTest.solution1();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {
            executor.submit(() -> cacheBrokenDownTest.executeSolution(countDownLatch));
        }
        countDownLatch.await();
        System.out.println("DB次数:" + cacheBrokenDownTest.dbCount.get() + " Cache次数:" + cacheBrokenDownTest.cacheCount.get());
        executor.shutdown();
    }
}
