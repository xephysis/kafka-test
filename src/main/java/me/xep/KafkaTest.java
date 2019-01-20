package me.xep;
import org.apache.kafka.clients.producer.*;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static io.github.benas.randombeans.api.EnhancedRandom.random;

public class KafkaTest {

    public static void main(String args[]) {
        Properties kafkaProp = new Properties();


        kafkaProp.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"kafka:9092");
        kafkaProp.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                io.confluent.kafka.serializers.KafkaAvroSerializer.class);
        kafkaProp.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                io.confluent.kafka.serializers.KafkaAvroSerializer.class);
        kafkaProp.put("schema.registry.url", "http://localhost:8081");
        Producer<String, Customer> producer = new KafkaProducer<String, Customer>(kafkaProp);

        while(true) {
            Customer customer = random(Customer.class);
            System.out.println(customer);
            ProducerRecord<String, Customer> record = new ProducerRecord<>("customer", customer.getName(), customer);
            producer.send(record);
        }
    }
}