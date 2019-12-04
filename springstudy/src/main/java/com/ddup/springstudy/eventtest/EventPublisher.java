package com.ddup.springstudy.eventtest;

import com.ddup.springstudy.domain.EventDTO;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
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
public class EventPublisher implements ApplicationListener<ApplicationReadyEvent> {

    @Resource
    SimpleApplicationEventMulticaster applicationEventMulticaster;

    @PostConstruct
    void initMulticaster(){
        applicationEventMulticaster.setTaskExecutor(Executors.newFixedThreadPool(2));
    }


    @Resource
    ApplicationEventPublisher applicationEventPublisher;

    public void sendEvent() {
        EventDTO eventDTO = new EventDTO();
        applicationEventPublisher.publishEvent(eventDTO);
    }

    @EventListener
    public void listenEvent(EventDTO eventDTO) {
        System.out.println( Thread.currentThread().getName()+" "+eventDTO);
    }

    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        sendEvent();
    }
}
