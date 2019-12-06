package com.ddup.springstudy.aop;

import com.ddup.springstudy.utils.LogUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * <p> </p>
 *
 * @author chenglu
 * @date 2019/12/6
 */
@Aspect
@Component
public class LogAop {

    @Around("execution(* com.ddup.springstudy.aop.HelloService.sayHello(..))")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LogUtil.getLogger().info("=====================start==========");
        Object proceed = proceedingJoinPoint.proceed();
        LogUtil.getLogger().info("=====================end============");
        return proceed;
    }
}
