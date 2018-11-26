package com.kafka.learnings.one;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerKafka {
    public static void main(String[] args) {
        // Properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // create an object of producer
        KafkaProducer<String, String> producer =new KafkaProducer<String, String>(properties);
        // send messages
        ProducerRecord<String, String> r =
                new ProducerRecord<String, String>("nov26_topic", "Hello World!");
        System.out.println("Sent the message" + producer.send(r));
        producer.flush();
        producer.close();
    }
}
