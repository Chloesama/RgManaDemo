package com.chloe.kafka.demo1;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

/**
 * @ClassName CounterInterceptor
 * @Description TODO
 * @Author RgMana
 * @Date 2022/2/4 17:49
 * @Version 1.0
 **/
public class CounterInterceptor implements ProducerInterceptor {
    int success = 0;
    int error = 0;

    @Override
    public ProducerRecord onSend(ProducerRecord producerRecord) {
        return producerRecord;
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {
        if (e == null) {
            success++;
        } else {
            error++;
        }
    }

    @Override
    public void close() {
        System.out.println("成功数:" + success);
        System.out.println("失败数:" + error);
    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}