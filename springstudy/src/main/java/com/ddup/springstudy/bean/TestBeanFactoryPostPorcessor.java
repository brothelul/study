package com.ddup.springstudy.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * <p> </p>
 *
 * @author chenglu
 * @date 2019/12/9
 */
@Component
public class TestBeanFactoryPostPorcessor implements BeanFactoryPostProcessor {
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println(beanFactory);
        System.out.println("===============bean factory post processor");
    }
}
