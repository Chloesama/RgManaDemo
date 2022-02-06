package com.chloe.kafka.demo1;

import org.apache.kafka.clients.producer.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @ClassName ProducerDemo1
 * @Description TODO
 * @Author RgMana
 * @Date 2022/2/4 12:16
 * @Version 1.0
 **/
public class ProducerDemo1 {
    public static void main(String[] args) {
        int sendNum = 10;
        Properties properties = new Properties();

        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.93.128:9092,192.168.93.128:9093,192.168.93.128:9094");
//        properties.put(ProducerConfig.ACKS_CONFIG, "all");
//        properties.put("retries", 1);
//        properties.put("batch.size", 16384);
//        properties.put("linger.ms", 1);
//        properties.put("buffer.memory", 33554432);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        List<String> list = new ArrayList<>();
        properties.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG,
                Arrays.asList("com.chloe.kafka.demo1.TimeInterceptor","com.chloe.kafka.demo1.CounterInterceptor"));


//        try{
//            KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
//            for (int i = 0; i < sendNum; i++) {
//                System.out.println("Chloe:" + i);
//                producer.send(new ProducerRecord<>("ScarketTopoc", "Scarelt:" + i));
//            }
//
//            Thread.sleep(100);
////            producer.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        try (KafkaProducer<String, String> producer = new KafkaProducer<>(properties)) {
            for (int i = 0; i < sendNum; i++) {
                producer.send(new ProducerRecord<>("ScarketTopoc", "Scarelt:" + i), (recordMetadata, e) -> {
                    if (e == null) {
                        System.out.println(recordMetadata.partition() + "====" + recordMetadata.offset());
                    } else {
                        e.printStackTrace();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}