package com.ddup.springstudy.eventtest;

import com.ddup.springstudy.domain.EventDTO;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p> </p>
 *
 * @author chenglu
 * @date 2019/11/8
 */
@Component
public class EventTest {
    @EventListener
    @Transactional
    public void listenEvent(EventDTO e) {
        System.out.println(Thread.currentThread().getName()+""+e);
    }
}
