package com.klaa.springkafkademo.service;

public interface DispatcherService {
    void process(String payload);
}
