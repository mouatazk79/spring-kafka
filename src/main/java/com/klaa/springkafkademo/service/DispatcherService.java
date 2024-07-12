package com.klaa.springkafkademo.service;

import com.klaa.springkafkademo.model.OrderCreated;

public interface DispatcherService {
    void process(OrderCreated payload) throws Exception;
}
