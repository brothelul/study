package com.ddup.springstudy.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p> </p>
 *
 * @author chenglu
 * @date 2019/12/6
 */
public class TestAop {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.scan("com.ddup");
        annotationConfigApplicationContext.refresh();
        HelloService helloService = annotationConfigApplicationContext.getBean(HelloService.class);
        System.out.println(helloService.getClass());
        helloService.sayHello();

        HelloService helloService1 = annotationConfigApplicationContext.getBean(HelloService.class);
        System.out.println(helloService1.getClass());
        helloService1.sayWa();
    }
}
