package mvn.com.config.kafka;

import java.util.Properties;
import java.util.TreeMap;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

/**
 * @author wangshiyu
 * @Date 2019年7月18日 下午2:38:06 类说明
 */
public class KafkaUtils {
    private static String kafkaHost = "";

    private static void init() {
//        String conf = util.Directory.GetAppPath("conf") + "server.conf";
//        TreeMap<String, String> conf_map = util.Configer.GetMap(conf, "=");
        kafkaHost = "127.0.0.1:9092";
    }

    static {
        init();
    }

    /**
     * 私有静态方法，创建Kafka生产者
     * 
     * @author
     * @return KafkaProducer
     */
    public static KafkaProducer<String, String> createProducer() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", kafkaHost);
        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("compression.type", "none");
        properties.put("buffer.memory", 33554432);
        properties.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        return new KafkaProducer<String, String>((properties));
    }

    /**
     *
     * 传入kafka约定的topicName,json格式字符串，发送给kafka集群
     *
     * @author
     * @param topicName
     */
    public void sendMessage(String topicName, String Message) {
        KafkaProducer<String, String> producer = createProducer();
        producer.send(new ProducerRecord<String, String>(topicName, Message));
        producer.close();
    }

    public static void main(String[] args) {
        KafkaProducer<String, String> producer = KafkaUtils
                .createProducer();
        Future<RecordMetadata> send = producer
                .send(new ProducerRecord<String, String>("xhs_wangshiyu_topic", "test_data"));
    }
}
