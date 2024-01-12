package com.klaa.springkafkademo.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DispatcherServiceImplTest {

    private DispatcherServiceImpl dispatcherService;
    @BeforeEach
    void setUp() {
        dispatcherService=new DispatcherServiceImpl();
    }

    @Test
    void process() {
        dispatcherService.process("payload");
    }
}