package com.klaa.springkafkademo.handler;

import com.klaa.springkafkademo.service.DispatcherService;
import com.klaa.springkafkademo.service.impl.DispatcherServiceImpl;
import com.klaa.springkafkademo.utils.EventData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

class OrderCreatedHandlerTest {

    private OrderCreatedHandler orderCreatedHandler;
    private DispatcherService dispatcherServiceMock;
    @BeforeEach
    void setUp() {
        dispatcherServiceMock= mock(DispatcherServiceImpl.class);
        orderCreatedHandler=new OrderCreatedHandler(dispatcherServiceMock);
    }

    @Test
    void listen() {
        orderCreatedHandler.listen(EventData.TestData());
    }
}