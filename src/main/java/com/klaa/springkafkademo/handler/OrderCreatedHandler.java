package com.klaa.springkafkademo.handler;

import com.klaa.springkafkademo.model.OrderCreated;
import com.klaa.springkafkademo.service.DispatcherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
@Slf4j
@Component
@RequiredArgsConstructor
public class OrderCreatedHandler {
    private final DispatcherService dispatcherService;

    @KafkaListener(
            id = "orderConsumerClient",
            topics = "order.created",
            groupId = "dispatch.order.consumer"
    )
    public void listen(OrderCreated payload){
        log.info("received payload: "+payload);
        dispatcherService.process(payload);
    }
}
