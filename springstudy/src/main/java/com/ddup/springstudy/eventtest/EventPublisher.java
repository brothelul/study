package com.ddup.springstudy.eventtest;

import com.ddup.springstudy.domain.EventDTO;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.EventListener;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.Executors;

/**
 * <p> </p>
 *
 * @author chenglu
 * @date 2019/11/8
 */
@Component
public class EventPublisher implements ApplicationListener<ApplicationStartingEvent> {
    @Resource
    ApplicationEventPublisher applicationEventPublisher;
    @Resource
    SimpleApplicationEventMulticaster applicationEventMulticaster;

    @PostConstruct
    void initMulticaster(){
        applicationEventMulticaster.setTaskExecutor(Executors.newFixedThreadPool(2));
    }



    public void sendEvent() {
        System.out.println(1111);
        EventDTO eventDTO = new EventDTO();
        applicationEventPublisher.publishEvent(eventDTO);
    }

    @EventListener
    public void listenEvent(EventDTO eventDTO) {
        System.out.println( Thread.currentThread().getName()+" "+eventDTO);
    }

    public void onApplicationEvent(ApplicationStartingEvent applicationReadyEvent) {
        sendEvent();
    }
}
