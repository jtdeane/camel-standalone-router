package ws.cogito.magic;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.redis.processor.idempotent.RedisIdempotentRepository;
import org.apache.camel.processor.idempotent.MemoryIdempotentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class IdempotentConsumerRouteBuilder extends RouteBuilder {

	//@Autowired
	//RedisTemplate<String, String> redisTemplate;
	
	
	@Override
	public void configure() throws Exception {
		
    	/*
    	 * Route errors to DLQ after one retry and one second delay
    	 */
    	errorHandler(deadLetterChannel("activemq:unique.dead").
    			maximumRedeliveries(1).redeliveryDelay(1000));
    	
    	/*
    	 * Idempotent Consumer - In Memory 
    	 * - requires uniqueId - GUUD
    	 * Cannot use with competing consumer
    	 */
    	from("activemq:unique.order").
    		idempotentConsumer(header("uniqueId"),
    		MemoryIdempotentRepository.memoryIdempotentRepository(200)).
		to("activemq:magic.order");
    	
    	/*
    	 * Idempotent Consumer - Redis
    	 * - requires uniqueId - GUUD
    	 * - require redis running and configured
    	 
    	from("activemq:unique.order").
    		idempotentConsumer(header("uniqueId"), 
    				RedisIdempotentRepository.redisIdempotentRepository(redisTemplate, "camel-repo")).
		to("activemq:magic.order");*/
	}
}