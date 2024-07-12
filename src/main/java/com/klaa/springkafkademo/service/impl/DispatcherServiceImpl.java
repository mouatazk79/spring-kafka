package com.klaa.springkafkademo.service.impl;

import com.klaa.springkafkademo.model.OrderCreated;
import com.klaa.springkafkademo.model.OrderDispatched;
import com.klaa.springkafkademo.service.DispatcherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class DispatcherServiceImpl implements DispatcherService {
    private static final String TOPIC_NAME="order.dispatched";
    private static final String DISPATCH_TRACKING_TOPIC="dispatch.tracking";
    private static final UUID APPLICATION_ID=UUID.randomUUID();

    private final KafkaTemplate<String,Object> kafkaProducer;
    @Override
    public void process(OrderCreated payload) throws Exception {
        OrderDispatched orderDispatched=OrderDispatched
                .builder()
                .orderId(payload.getId())
                .processedById(APPLICATION_ID)
                .notes(payload.getItem())
                .build();
        kafkaProducer.send(TOPIC_NAME,orderDispatched).get();
        log.info("payload processed");
    }
}
