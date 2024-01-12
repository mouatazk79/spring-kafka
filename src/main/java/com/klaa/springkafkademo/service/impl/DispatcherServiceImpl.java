package com.klaa.springkafkademo.service.impl;

import com.klaa.springkafkademo.service.DispatcherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DispatcherServiceImpl implements DispatcherService {
    @Override
    public void process(String payload) {
        log.info("payload processed");
    }
}
