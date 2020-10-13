package mj.kafkaproducer;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProducerApplication {

    public static void main(String[] args) {
        //메세지를 보내고 확인하지 않기
        KafkaProducerRunner ackProducer = new KafkaNonAckProducer();
        ackProducer.run();

        //동기전송
        KafkaProducerRunner syncProducer = new KafkaSyncProducer();
        syncProducer.run();

        //비동기 전송
        KafkaProducerRunner asyncProducer = new KafkaAsyncProducer();
        asyncProducer.run();

        // for-loop을 사용한 메세지 전송
        KafkaProducerRunner forLoopProducer = new KafkaForloopProducer();
        forLoopProducer.run();
    }
}
