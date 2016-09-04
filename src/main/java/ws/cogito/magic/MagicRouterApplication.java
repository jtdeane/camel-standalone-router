package ws.cogito.magic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Standalone Client for Enterprise Message Workshop
 * @author jeremydeane
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@ImportResource("classpath:camel-route-spring.xml")
public class MagicRouterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagicRouterApplication.class, args);
	}
}