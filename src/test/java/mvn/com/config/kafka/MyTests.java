package mvn.com.config.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.concurrent.Future;

/**
 * @author JavaPub rodert
 * @date 2020/7/30 14:19
 * @description
 */
public class MyTests {

//    public static KafkaProducer<String, String> producer = KafkaUtils.createProducer();

    public static void main(String[] args) {
//        Future<RecordMetadata> send = producer
//                .send(new ProducerRecord<String, String>("xhs_wangshiyu_test_topic", "data1"));
//        System.out.println(send);

        KafkaUtils kafkaUtils = new KafkaUtils();
        kafkaUtils.sendMessage("xhs_wangshiyu_test_topic", "data1");
    }

}
