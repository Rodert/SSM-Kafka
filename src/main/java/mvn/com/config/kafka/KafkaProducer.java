package mvn.com.config.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/producer")
public class KafkaProducer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@RequestMapping("/send.do")
	@ResponseBody
	public String sendMessgae(){
		for(int i = 0 ;i<20;i++){
			kafkaTemplate.send("myTopic", "i am handsame"+i);
			System.out.println(i);
		}
		return "·¢ËÍ³É¹¦";
	}
}
