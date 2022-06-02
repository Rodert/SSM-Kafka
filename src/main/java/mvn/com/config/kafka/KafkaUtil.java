package mvn.com.config.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @author weijie
 * @date 2020/7/30 15:21
 */
public class KafkaUtil {

    public static final String kafka_topic =  "topic_xhs_wangshiyu";
    private static final String kafka_hosts = "127.0.0.1:9092";
    private static final String kafka_producer_buffer_memory = "40960";
    private static final String kafka_producer_batch_size = "4096";
    private static final String kafka_producer_linger_ms = "1";


    private static KafkaProducer<String, String> producer;


    static {
        /**
         * 初始化加载配置类
         */
        Properties properties = new Properties();
        properties.put("bootstrap.servers", kafka_hosts);
        properties.put("buffer.memory",kafka_producer_buffer_memory); // 缓存大小
        properties.put("batch.size",kafka_producer_batch_size); // producer试图批量处理消息记录。目的是减少请求次数，改善客户端和服务端之间的性能。
        // 这个配置是控制批量处理消息的字节数。如果设置为0，则禁用批处理。如果设置过大，会占用内存空间.
        properties.put("linger.ms",kafka_producer_linger_ms);
        properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer<>(properties);
    }

    public static KafkaProducer<String, String> getProducer() {
        return producer;
    }

    public static void main(String[] args) {
        KafkaProducer<String, String> producer = KafkaUtil.getProducer();
        producer.send(new ProducerRecord<String, String>(KafkaUtil.kafka_topic, "data value"));
        System.out.println("11");    }
}
