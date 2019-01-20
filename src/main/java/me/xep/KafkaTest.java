package me.xep;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.*;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class KafkaTest {

    public static void main(String args[]) {
        Properties kafkaProp = new Properties();

        kafkaProp.put("bootstrap.servers","kafka:9092");
        kafkaProp.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProp.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaAvroSerializer test;

        Producer<String, String> producer = new KafkaProducer<String, String>(kafkaProp);

        ProducerRecord<String, String> record = new ProducerRecord<String, String>("test", "Precision Products", "France");
        try {
            producer.send(record).get(5000, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }

        System.out.println("TEST");

    }
}