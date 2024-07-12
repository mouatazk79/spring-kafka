package com.klaa.springkafkademo.handler;

import com.klaa.springkafkademo.model.OrderCreated;
import com.klaa.springkafkademo.service.DispatcherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
@Slf4j
@Component
@RequiredArgsConstructor
@KafkaListener(
        id = "orderConsumerClient",
        topics = "order.created",
        groupId = "dispatch.order.consumer",
        containerFactory = "concurrentKafkaListenerContainerFactory"
)
public class OrderCreatedHandler {
    private final DispatcherService dispatcherService;


    @KafkaHandler
    public void listen(@Header(KafkaHeaders.RECEIVED_PARTITION) Integer id,@Header(KafkaHeaders.RECEIVED_KEY) String key, @Payload OrderCreated payload) throws Exception {
        log.info("received payload: "+payload);
        dispatcherService.process(payload);
    }
}
