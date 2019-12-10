package com.ddup.springstudy.aop;

import org.springframework.stereotype.Service;

/**
 * <p> </p>
 *
 * @author chenglu
 * @date 2019/12/6
 */
@Service
public class HelloServiceImpl implements HelloService {
    public void sayHello() {
        System.out.println("hell0");
    }

    public void sayWa() {
        System.out.println("wa");
    }
}
