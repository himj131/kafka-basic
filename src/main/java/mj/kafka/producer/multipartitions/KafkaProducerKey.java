package mj.kafka.producer.multipartitions;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaProducerKey {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "1");
        props.put("compression.type", "gzip");
        props.put("key.serializer", StringSerializer.class);
        props.put("value.serializer", StringSerializer.class);

        Producer<String, String> producer = new KafkaProducer<>(props);
        String topicName = "mjtest2";
        String oddKey = "1";
        String evenKey = "2";

        for (int i = 1; i < 11; i++) {
            if(i % 2 == 1) {
                producer.send(new ProducerRecord<>(topicName,
                        oddKey, String.format("%d - message From partition oddKey producer - key = " + oddKey, i)));
            } else {
                producer.send(new ProducerRecord<>(topicName,
                        evenKey, String.format("%d - message From partition evenKey producer - key = " + evenKey, i)));
            }
        }

        producer.close();
    }
}
