import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class KafkaProducerApplication {

    public static void main(String[] args) {
        //메세지를 보내고 확인하지 않기
        KafkaProducerRunner producer = new KafkaNonAckProducer();
        producer.run();

        //동기전송
        KafkaProducerRunner syncProducer = new KafkaSyncProducer();
        producer.run();
        
    }
}
