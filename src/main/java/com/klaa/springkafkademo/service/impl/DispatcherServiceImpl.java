package com.klaa.springkafkademo.service.impl;

import com.klaa.springkafkademo.model.OrderCreated;
import com.klaa.springkafkademo.model.OrderDispatched;
import com.klaa.springkafkademo.service.DispatcherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DispatcherServiceImpl implements DispatcherService {
    private static final String TOPIC_NAME="order.dispatched";
    private final KafkaTemplate<String,Object> kafkaProducer;
    @Override
    public void process(OrderCreated payload) {
        OrderDispatched orderDispatched=OrderDispatched
                .builder()
                .orderId(payload.getId())
                .build();
        kafkaProducer.send(TOPIC_NAME,orderDispatched);
        log.info("payload processed");
    }
}
