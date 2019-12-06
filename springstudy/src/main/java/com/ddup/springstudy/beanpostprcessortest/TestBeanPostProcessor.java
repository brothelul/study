package com.ddup.springstudy.beanpostprcessortest;

import com.ddup.springstudy.utils.LogUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * <p> </p>
 *
 * @author chenglu
 * @date 2019/11/16
 */
@Component
public class TestBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof  TestBeanPostProcessor) {
            LogUtil.getLogger().info("bean: {}, beanName: {}", bean, beanName);
        }

        return bean;
    }
}
