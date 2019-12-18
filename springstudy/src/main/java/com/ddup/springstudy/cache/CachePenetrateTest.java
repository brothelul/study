package com.ddup.springstudy.cache;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * <p> 缓存穿透测试 </p>
 *
 * @author chenglu
 * @date 2019/12/18
 */
@Component
public class CachePenetrateTest {
    @Resource
    private RedisTemplate<String, String> redisTemplate;
    private static final String CACHE_KEY = "cache";

    public void request(Integer id){
        String cacheKey = CACHE_KEY + ":" + id;
        String value = redisTemplate.opsForValue().get(cacheKey);
//        if (Objects.nonNull(value)) {
//            System.out.println("从[缓存]中获取到数据");
//            return;
//        }
        // 取出null值的缓存，防止缓存穿透
        if (redisTemplate.hasKey(cacheKey)) {
            System.out.println("从[缓存]中获取到数据:" + value);
            return;
        }
        if (id == 1) {
            System.out.println("从[DB]中获取到数据:" + value);
            redisTemplate.opsForValue().set(cacheKey, "DB1");
        } else {
            System.out.println("DB中不存在数据");
            // 设置短时间的缓存null
            redisTemplate.opsForValue().set(cacheKey, null, 5, TimeUnit.SECONDS);
        }
    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("com.ddup");
        applicationContext.refresh();
        CachePenetrateTest cachePenetrateTest = applicationContext.getBean(CachePenetrateTest.class);
        cachePenetrateTest.request(2);
    }
}
