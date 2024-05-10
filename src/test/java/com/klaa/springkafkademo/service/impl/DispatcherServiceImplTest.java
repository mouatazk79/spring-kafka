package com.klaa.springkafkademo.service.impl;

import com.klaa.springkafkademo.model.OrderCreated;
import com.klaa.springkafkademo.utils.EventData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.Mockito.mock;

class DispatcherServiceImplTest {

    private DispatcherServiceImpl dispatcherService;
    private KafkaTemplate<String,Object> kafkaProducer;
    @BeforeEach
    void setUp() {

        kafkaProducer=mock(KafkaTemplate.class);
        dispatcherService=new DispatcherServiceImpl(kafkaProducer);
    }

    @Test
    void process() {
        OrderCreated orderCreated=EventData.TestData();
        dispatcherService.process(orderCreated);
    }
}