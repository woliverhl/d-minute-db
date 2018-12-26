package cl.usach.dminute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication(scanBasePackages = "cl.usach.dminute")
@EnableDiscoveryClient
@EnableAutoConfiguration
@EnableCaching
public class DMinuteMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DMinuteMsApplication.class, args);
	}
}