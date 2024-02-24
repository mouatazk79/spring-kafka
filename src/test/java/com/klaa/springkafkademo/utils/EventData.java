package com.klaa.springkafkademo.utils;

import com.klaa.springkafkademo.model.OrderCreated;

import java.util.UUID;

public class EventData {

   public static OrderCreated TestData(){
       return OrderCreated.builder()
               .id(UUID.randomUUID())
               .item(UUID.randomUUID().toString())
               .build();

   }
}
