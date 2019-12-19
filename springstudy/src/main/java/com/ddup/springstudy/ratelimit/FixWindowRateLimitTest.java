package com.ddup.springstudy.ratelimit;

import com.ddup.springstudy.base.BaseConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p> 固定窗口限流 </p>
 *
 * @author chenglu
 * @date 2019/12/19
 */
@Component
public class FixWindowRateLimitTest {
    @Resource
    private RedisTemplate<String, Integer> redisTemplate;
    private static final String CACHE_KEY = "FixWindowRateLimit";
    private AtomicInteger limitCount = new AtomicInteger();
    private AtomicInteger passCount = new AtomicInteger();

    public synchronized void request(){
        Integer rate = redisTemplate.opsForValue().get(CACHE_KEY);
        if (Objects.nonNull(rate)) {
            if (rate > 6) {
                System.out.println("[固定窗口限流] 请求被丢弃了");
                limitCount.incrementAndGet();
            } else {
                passCount.incrementAndGet();
                System.out.println("[固定窗口限流] 请求被接受了");
            }
            redisTemplate.opsForValue().getAndSet(CACHE_KEY, ++ rate);
            return;
        }
        redisTemplate.opsForValue().set(CACHE_KEY, 1, 1, TimeUnit.SECONDS);
        passCount.incrementAndGet();
        System.out.println("[固定窗口限流] 请求被接受了");
    }
    public void doRequest(CountDownLatch countDownLatch) {
        request();
        countDownLatch.countDown();
    }

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.ddup");
        ThreadPoolExecutor threadPoolExecutor = applicationContext.getBean(ThreadPoolExecutor.class);
        FixWindowRateLimitTest fixWindowRateLimitTest = applicationContext.getBean(FixWindowRateLimitTest.class);
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {
            threadPoolExecutor.execute(() -> fixWindowRateLimitTest.doRequest(countDownLatch));
        }
        countDownLatch.await();
        System.out.println(String.format("通过请求数: %s, 失败请求数: %s.", fixWindowRateLimitTest.passCount.get(), fixWindowRateLimitTest.limitCount.get()));
        threadPoolExecutor.shutdown();
    }
}
