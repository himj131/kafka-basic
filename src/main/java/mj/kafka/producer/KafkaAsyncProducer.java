package mj.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.Future;

public class KafkaAsyncProducer implements KafkaProducerRunner {
    @Override
    public void run() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", StringSerializer.class);
        props.put("value.serializer", StringSerializer.class);

        Producer<String, String> producer = new KafkaProducer<>(props);
        try {
            Future<RecordMetadata> metadataFuture =
                    producer.send(new ProducerRecord<String, String>("mjtest", "message from asyncProducer"),
                            new MJCallback());
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }
}
