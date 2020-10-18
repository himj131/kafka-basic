package mj.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaNonAckProducer implements KafkaProducerRunner {
    @Override
    public void run() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", StringSerializer.class);
        props.put("value.serializer", StringSerializer.class);

        Producer<String, String> producer = new KafkaProducer<>(props);
        try {
            producer.send(new ProducerRecord<String, String>("mjtest", "message from non ack producer"));
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        };
    }
}
